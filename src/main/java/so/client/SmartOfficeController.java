package so.client;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import so.service3.WhiteboardCreationGrpc;
import so.service3.CreateWhiteboardRequest;
import so.service3.CreateWhiteboardResponse;

public class SmartOfficeController implements ActionListener 
{

    private JTextField entryField, replyField; //Request and response text fields

    private JPanel getWhiteboardJPanel() //Creating a panel for whiteboard creation
    {
        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS); //Component horizontal axis setup

        JLabel label = new JLabel("Enter a Whiteboard Title:"); //Labling to show user to input a whiteboard title
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entryField = new JTextField("", 10); //Text field to enter title
        panel.add(entryField);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Create Whiteboard"); //Button to create whiteboard
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        replyField = new JTextField("", 20); //Reply field to show the Whiteboard title when create
        replyField.setEditable(false); //Block editing capabilities
        panel.add(replyField);

        panel.setLayout(boxlayout);

        return panel;
    }

    public static void main(String[] args) 
    {
        SmartOfficeController gui = new SmartOfficeController(); //Create and show the GUI
        gui.build();
    }

    private void build() 
    {
        JFrame frame = new JFrame("Whiteboard Creation Service Controller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(); //Setting up the panel to hold the UI components
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS); //Creating the vertical axis layout for the components
        panel.setLayout(boxlayout);

        panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100))); //Create a boarder for the panel

        panel.add(getWhiteboardJPanel()); //Add whiteboard to main panel

        frame.setSize(400, 150); //Frame size set
        frame.add(panel); //Add main panel to frame
        frame.pack(); //Use content to determine the frame size
        frame.setVisible(true); //Make it visible
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        JButton button = (JButton) e.getSource();
        String label = button.getActionCommand();

        if (label.equals("Create Whiteboard")) //Checking if button is pressed
        {
            System.out.println("Creating whiteboard..."); //Terminal message to say that whiteboard is being created

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051) //Create and connect a ManagedChannel to connect to server
                    .usePlaintext() //Allows local development
                    .build();

            WhiteboardCreationGrpc.WhiteboardCreationBlockingStub blockingStub = WhiteboardCreationGrpc.newBlockingStub(channel); //Creating a blocking stub

            //Prepping message for sending
            CreateWhiteboardRequest request = CreateWhiteboardRequest.newBuilder()
                    .setNewWhiteboard(entryField.getText())
                    .build();

            try 
            {
                //Send request and pull the reply from the service
                CreateWhiteboardResponse response = blockingStub.createWhiteboard(request);
                replyField.setText("Created: " + response.getWhiteboardName()); //Display the response in GUI
                System.out.println("Created: " + response.getWhiteboardName()); //Display the response in terminal
            } 
            catch (StatusRuntimeException ex)  //Managing RPC call errors
            {
                System.err.println("RPC failed: " + ex.getStatus());
                replyField.setText("Error: " + ex.getStatus().toString());
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
                catch (InterruptedException e1) // Handle any disruption while channel attempts to terminate
                {
                    System.err.println("Interrupted while waiting for channel to terminate: " + e1.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
