package so.client;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import so.service3.PanelService3;
import so.service3.WhiteboardCreationGrpc;
import so.service3.CreateWhiteboardRequest;
import so.service3.CreateWhiteboardResponse;
import so.service3.WhiteboardContentGrpc;
import so.service3.AddContentRequest;
import so.service3.AddContentResponse;
import so.service3.WhiteboardStreamGrpc;
import so.service3.WhiteboardUpdate;

public class SmartOfficeController implements ActionListener 
{

    private PanelService3 panelService3;
    private ManagedChannel channel;
    private String currentWhiteboardName;
    private String currentContent;
    private WhiteboardStreamGrpc.WhiteboardStreamStub streamStub;
    private StreamObserver<WhiteboardUpdate> requestObserver;
    private Thread streamingThread;

    public SmartOfficeController() {
        panelService3 = new PanelService3();
        channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        streamStub = WhiteboardStreamGrpc.newStub(channel);
        panelService3.setStreamStub(streamStub);
    }

    public static void main(String[] args) 
    {
        SmartOfficeController gui = new SmartOfficeController(); //Create and show the GUI
        gui.build();
    }

    private void build() 
    {
        JFrame frame = new JFrame("Whiteboard Service Controller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(); //Setting up the panel to hold the UI components
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS); //Creating the vertical axis layout for the components
        panel.setLayout(boxlayout);

        panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100))); //Create a border for the panel

        panel.add(panelService3.createPanel(this)); //Pass "this" as ActionListener

        frame.setSize(500, 300); //Adjust frame size as needed
        frame.add(panel); //Add main panel to frame
        frame.pack(); //Use content to determine the frame size
        frame.setVisible(true); //Make it visible
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        JButton button = (JButton) e.getSource();
        String label = button.getActionCommand();

        if (label.equals("CREATE_WHITEBOARD")) //Checking if Create Whiteboard button is pressed
        {
            System.out.println("Creating whiteboard..."); //Terminal message to say that whiteboard is being created
            WhiteboardCreationGrpc.WhiteboardCreationBlockingStub blockingStub = WhiteboardCreationGrpc.newBlockingStub(channel); //Creating a blocking stub

            //Prepping message for sending
            CreateWhiteboardRequest request = CreateWhiteboardRequest.newBuilder()
                    .setNewWhiteboard(panelService3.getWhiteboardTitle().getText())
                    .build();

            try 
            {
                //Send request and pull the reply from the service
                CreateWhiteboardResponse response = blockingStub.createWhiteboard(request);
                panelService3.getWhiteboardReply().setText("Created: " + response.getWhiteboardName()); //Display the response in GUI
                System.out.println("Created: " + response.getWhiteboardName()); //Display the response in terminal
            } 
            catch (StatusRuntimeException ex) //Managing RPC call errors
            {
                System.err.println("RPC failed: " + ex.getStatus());
                panelService3.getWhiteboardReply().setText("Error: " + ex.getStatus().toString());
            } 
        }           
        else if (label.equals("ADD_CONTENT")) //Checking if Add Content button is pressed
        {
            System.out.println("Adding content..."); //Terminal message to say that if content has been added
            WhiteboardContentGrpc.WhiteboardContentBlockingStub blockingStub = WhiteboardContentGrpc.newBlockingStub(channel); //Creating a blocking stub

            //Prepping message for sending
            AddContentRequest request = AddContentRequest.newBuilder()
                    .setWhiteboardName(panelService3.getContentTitle().getText())
                    .setAddContent(panelService3.getAddContent().getText())
                    .build();

            try 
            {
                //Send request and pull the reply from the service
                AddContentResponse response = blockingStub.addContent(request);
                panelService3.getContentReply().setText("Content Added: " + response.getNewWhiteboardContent()); //Display the response in GUI
                System.out.println("Content Added: " + response.getNewWhiteboardContent()); //Display the response in terminal

                //Track the current whiteboard name and content
                String whiteboardName = request.getWhiteboardName();
                String content = request.getAddContent();
                
                //Update the tracked state (assuming these are instance variables)
                currentWhiteboardName = whiteboardName;
                currentContent = content;
            }  
            catch (StatusRuntimeException ex) //Managing RPC call errors
            {
                System.err.println("RPC failed: " + ex.getStatus());
                panelService3.getContentReply().setText("Error: " + ex.getStatus().toString());
            } 
            
        }

        else if (label.equals("START_STREAMING")) 
        {
            System.out.println("Starting streaming...");     
            WhiteboardStreamGrpc.WhiteboardStreamStub streamStub = WhiteboardStreamGrpc.newStub(channel); //Creating a streaming stub
        
            //Check if streamStub is initialized
            if (requestObserver == null) 
            {
                System.out.println("Initializing streaming stub...");
                requestObserver = streamStub.whiteboardStream(new StreamObserver<WhiteboardUpdate>() 
                {
                    @Override
                    public void onNext(WhiteboardUpdate value) 
                    {
                        String updateText = "Received update: " + value.getWhiteboardName() + " - " + value.getContent();
                        System.out.println(updateText);
        
                        SwingUtilities.invokeLater(() -> //Update GUI on EDT
                        {
                            //Update to the streaming panel
                            panelService3.getStreamingUpdatesArea().append(updateText + "\n");
                        });
                    }
        
                    @Override
                    public void onError(Throwable t) 
                    {
                        System.err.println("Streaming error: " + t.getMessage());
                        SwingUtilities.invokeLater(() -> 
                        {
                            //If there's an error update the GUI to show the error
                            panelService3.getStreamingUpdatesArea().append("Streaming error: " + t.getMessage() + "\n");
                        });
                    }
        
                    @Override
                    public void onCompleted() 
                    {
                        System.out.println("Streaming completed.");
                    }
                });
                System.out.println("Stream stub initialized.");
            } 
                
            
            streamingThread = new Thread(() -> //Send updates based on the stored whiteboard name and content
            {
                while (requestObserver != null) 
                {
                    try 
                    {
                        if (currentWhiteboardName != null && currentContent != null) 
                        {
                            WhiteboardUpdate update = WhiteboardUpdate.newBuilder()
                                    .setWhiteboardName(currentWhiteboardName)
                                    .setContent(currentContent)
                                    .build();
        
                            requestObserver.onNext(update);
                            Thread.sleep(3000); //Set interval time
                        }
                    } 
                    catch (InterruptedException ie) 
                    {
                        Thread.currentThread().interrupt();
                        if (requestObserver != null) // Ensure requestObserver is not null before calling onError
                        {
                            requestObserver.onError(ie);
                        }
                        break;
                    }
                }
            });
            streamingThread.start();
        } 
        else 
        {
        System.out.println("Unknown action command: " + label);
        }
    }
}