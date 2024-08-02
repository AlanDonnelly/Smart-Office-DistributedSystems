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

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import so.service3.PanelService3;
import so.service3.WhiteboardCreationGrpc;
import so.service3.CreateWhiteboardRequest;
import so.service3.CreateWhiteboardResponse;
import so.service3.WhiteboardContentGrpc;
import so.service3.AddContentRequest;
import so.service3.AddContentResponse;

public class SmartOfficeController implements ActionListener 
{

    private PanelService3 panelService3;

    public SmartOfficeController() 
    {
        panelService3 = new PanelService3();
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

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051) //Create and connect a ManagedChannel to connect to appropriate port on server
                    .usePlaintext() //Allows local development
                    .build();

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
            finally 
            {
                channel.shutdownNow(); //Shutdown managedchannel
                try 
                {
                    if (!channel.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS)) //Allow time for channel termination
                    {
                        System.err.println("Channel did not terminate in the specified time.");
                    }
                } 
                catch (InterruptedException e1) //Handle any disruption while channel attempts to terminate
                {
                    System.err.println("Interrupted while waiting for channel to terminate: " + e1.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        } 
        else if (label.equals("ADD_CONTENT")) //Checking if Add Content button is pressed
        {
            System.out.println("Adding content..."); //Terminal message to say that if content has been added

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052) //Create and connect a ManagedChannel to connect to appropriate port on server
                    .usePlaintext() //Allows local development
                    .build();

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
            }  
            catch (StatusRuntimeException ex) //Managing RPC call errors
            {
                System.err.println("RPC failed: " + ex.getStatus());
                panelService3.getContentReply().setText("Error: " + ex.getStatus().toString());
            } 
            finally 
            {
                channel.shutdownNow(); //Shutdown managedchannel
                try 
                {
                    if (!channel.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS)) //Allow time for channel termination
                    {
                        System.err.println("Channel did not terminate in the specified time.");
                    }
                } 
                catch (InterruptedException e1) //Handle any disruption while channel attempts to terminate
                {
                    System.err.println("Interrupted while waiting for channel to terminate: " + e1.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
