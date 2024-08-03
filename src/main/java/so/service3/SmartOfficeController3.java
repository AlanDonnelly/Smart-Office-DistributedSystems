package so.service3;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
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
import so.client.MainMenu;
import so.service3.AddContentRequest;
import so.service3.AddContentResponse;
import so.service3.WhiteboardStreamGrpc;
import so.service3.WhiteboardUpdate;

public class SmartOfficeController3 implements ActionListener 
{

    private PanelService3 panelService3;
    private ManagedChannel channel;
    private String currentWhiteboardName;
    private String currentContent;
    private WhiteboardStreamGrpc.WhiteboardStreamStub streamStub;
    private StreamObserver<WhiteboardUpdate> requestObserver;
    private Thread streamingThread;
    private JFrame frame; 

    public SmartOfficeController3() 
    {
        panelService3 = new PanelService3();
        channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        streamStub = WhiteboardStreamGrpc.newStub(channel);
        panelService3.setStreamStub(streamStub);
    }

    public void build() 
    {
        frame = new JFrame("Whiteboard Service Controller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(); //Setting up the panel to hold the UI components
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS); //Creating the vertical axis layout for the components
        panel.setLayout(boxLayout);
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

        switch (label) 
        {
            case "CREATE_WHITEBOARD":
                handleCreateWhiteboard();
                break;
            case "ADD_CONTENT":
                handleAddContent();
                break;
            case "START_STREAMING":
                handleStartStreaming();
                break;
            case "BACK_TO_MAIN_MENU":
                handleBackToMainMenu(); //Handle back to main menu
                break;
            default:
                System.out.println("Unknown action command: " + label);
                break;
        }
    }

    private void handleBackToMainMenu() 
    {
        if (frame != null) 
        {
            frame.dispose(); //Close the current window
        }
        SwingUtilities.invokeLater(() -> 
        {
            MainMenu.main(new String[0]); //Restart the main menu
        });
    }

    private void handleCreateWhiteboard() 
    {
        System.out.println("Creating whiteboard..."); //Terminal message
        WhiteboardCreationGrpc.WhiteboardCreationBlockingStub blockingStub = WhiteboardCreationGrpc.newBlockingStub(channel); //Creating a blocking stub

        //Prepping message for sending
        CreateWhiteboardRequest request = CreateWhiteboardRequest.newBuilder()
                .setNewWhiteboard(panelService3.getWhiteboardTitle().getText())
                .build();

        try 
        {
            //Send request and pull the reply from the service
            CreateWhiteboardResponse response = blockingStub.createWhiteboard(request);
            panelService3.getWhiteboardReply().setText("Created: " + response.getWhiteboardName()); //Display response in GUI
            System.out.println("Created: " + response.getWhiteboardName()); //Display response in terminal
        } 
        catch (StatusRuntimeException ex) 
        {
            System.err.println("RPC failed: " + ex.getStatus());
            panelService3.getWhiteboardReply().setText("Error: " + ex.getStatus().toString());
        }
    }

    private void handleAddContent() 
    {
        System.out.println("Adding content..."); //Terminal message
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
            panelService3.getContentReply().setText("Content Added: " + response.getNewWhiteboardContent()); //Display response in GUI
            System.out.println("Content Added: " + response.getNewWhiteboardContent()); //Display response in terminal

            //Track the current whiteboard name and content
            currentWhiteboardName = request.getWhiteboardName();
            currentContent = request.getAddContent();
        } 
        catch (StatusRuntimeException ex) 
        {
            System.err.println("RPC failed: " + ex.getStatus());
            panelService3.getContentReply().setText("Error: " + ex.getStatus().toString());
        }
    }

    private void handleStartStreaming() 
    {
        System.out.println("Starting streaming...");
        //Creating a streaming stub
        WhiteboardStreamGrpc.WhiteboardStreamStub streamStub = WhiteboardStreamGrpc.newStub(channel);

        //Check if streamStub is initialized
        if (requestObserver == null) {
            System.out.println("Initializing streaming stub...");
            requestObserver = streamStub.whiteboardStream(new StreamObserver<WhiteboardUpdate>() 
            {
                @Override
                public void onNext(WhiteboardUpdate value) 
                {
                    String updateText = "Received update: " + value.getWhiteboardName() + " - " + value.getContent();
                    System.out.println(updateText);

                    SwingUtilities.invokeLater(() -> 
                    { //Update GUI on EDT
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

        streamingThread = new Thread(() -> 
        { //Send updates based on the stored whiteboard name and content
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
                    if (requestObserver != null) { //Ensure requestObserver is not null before calling onError
                        requestObserver.onError(ie);
                    }
                    break;
                }
            }
        });
        streamingThread.start();
    }
}
