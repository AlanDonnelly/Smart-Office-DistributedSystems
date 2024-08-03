package so.service1;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import so.client.MainMenu; 

public class SmartOfficeController1 implements ActionListener 
{

    private PanelService1 panelService1;
    private ManagedChannel channel;
    private JFrame frame; 

    public SmartOfficeController1() 
    {
        panelService1 = new PanelService1();
        channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
    }

    public void build() 
    {
        frame = new JFrame("Service 1 Controller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(); //Setting up the panel to hold the UI components
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS); //Creating the vertical axis layout for the components
        panel.setLayout(boxLayout);
        panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100))); //Create a border for the panel
        panel.add(panelService1.createPanel(this)); //Pass "this" as ActionListener

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
            case "SET_AIR_QUAL":
                handleAirQualControl(true); //True will 'SET'
                break;
            case "GET_AIR_QUAL":
                handleAirQualControl(false); //False will 'GET'
                break;
            case "BACK_TO_MAIN_MENU":
                handleBackToMainMenu(); //Handle back to main menu
                break;
            case "SET_TEMP":  
                handleTempControl(true); //True will 'SET'
                break;
            case "GET_TEMP": 
                handleTempControl(false); //False will 'GET'
                break;
            case "LIGHTING_CONTROL":
                handleLightingControl();
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
    
    //Service 1 methods
    private void handleAirQualControl(boolean isSet) //Handle air quality control requests
    {
        String operationType = isSet ? "SET" : "GET"; //Determine if we are setting or getting the air quality based on the isSet flag.
        int ventilationLevel = isSet ? panelService1.getVentilationLevel() : 0; //Get the ventilation level if we are setting the air quality, otherwise use 0.

        AirQualRequest request = AirQualRequest.newBuilder() //Build the request object with the determined operation type and ventilation level.
                .setOperationType(operationType)
                .setVentilationLevel(ventilationLevel)
                .build();
        //Create a blocking stub to communicate with the gRPC server for air quality control.
        AirQualityControlGrpc.AirQualityControlBlockingStub blockingStub = AirQualityControlGrpc.newBlockingStub(channel);
        AirQualResponse response;

        try 
        {
            if ("SET".equals(operationType)) //If "SET", then send a request to set the air quality.
            {
                response = blockingStub.setAirQual(request);
                panelService1.getAirQualReplyField().setText("New Air Quality Set: " + response.getCurrentAirQuality() + //Update UI to reflect the new air quality and vent level
                                                            ", New Ventilation Level: " + response.getNewVentilationLevel());
            } 
            else if ("GET".equals(operationType)) // If "GET", the send a request to get the current air quality.
            {
                response = blockingStub.getAirQual(request);
                panelService1.getAirQualReplyField().setText("Current Air Quality: " + response.getCurrentAirQuality() + //Update UI to reflect the current air quality and vent level
                                                            ", Ventilation Level: " + response.getNewVentilationLevel());
            } 
            else 
            {
                System.out.println("Invalid operation type: " + operationType); //Print if invalid
            }
        } 
        catch (StatusRuntimeException ex) 
        {
            System.err.println("RPC failed: " + ex.getStatus()); //Print if RPC fails
        }
    }

    private void handleTempControl(boolean isSet) //Handle temp control requests
    {
        String operationType = isSet ? "SET" : "GET"; //Determine if we are setting or getting the temp based on the isSet flag.
        float tempLevel = isSet ? panelService1.getTempLevel() : 0.0f; //Get the temp level if we are setting the temp, otherwise use 0.

        TempRequest request = TempRequest.newBuilder()  //Build the request object with the determined operation type and temp level.
                .setOperationType(operationType)
                .setTempLevel(tempLevel)
                .build();
        //Create a blocking stub to communicate with the gRPC server for temp control.
        TempControlGrpc.TempControlBlockingStub blockingStub = TempControlGrpc.newBlockingStub(channel);
        TempResponse response;

        try 
        {
            if ("SET".equals(operationType)) //If "SET", then send a request to set the temp.
            {
                response = blockingStub.setTemp(request);
                panelService1.getTempReplyField().setText("New Temperature Set: " + response.getCurrentTemp() + //Update UI to reflect the new temp and temp level
                                                          ", New Temperature Level: " + response.getNewTempLevel());
            } 
            else if ("GET".equals(operationType)) //If "GET", then send a request to get the temp.
            {
                response = blockingStub.getTemp(request);
                panelService1.getTempReplyField().setText("Current Temperature: " + response.getCurrentTemp() + //Update UI to reflect the current temp and temp level
                                                          ", Temperature Level: " + response.getNewTempLevel());
            } 
            else 
            {
                System.out.println("Invalid operation type: " + operationType); //Print if invalid
            }
        } 
        catch (StatusRuntimeException ex) 
        {
            System.err.println("RPC failed: " + ex.getStatus()); //Print if RPC fails
        }
    }

    private void handleLightingControl() 
    {
        System.out.println("Service 1 Lighting Control");     
    }
}
