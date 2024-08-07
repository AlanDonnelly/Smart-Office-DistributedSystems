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
import so.ServiceRegistrationJMDNS;
import so.client.MainMenu; 
import javax.jmdns.ServiceInfo;

public class SmartOfficeController1 implements ActionListener 
{

    private PanelService1 panelService1;
    private ManagedChannel channel;
    private JFrame frame; 
    private ServiceRegistrationJMDNS registrationManagerJMDNS;
    private ServiceInfo serviceInfo;

    public SmartOfficeController1() 
    {
        panelService1 = new PanelService1();
        channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        registrationManagerJMDNS = new ServiceRegistrationJMDNS();        
        registrationManagerJMDNS.registerService("_smartoffice._tcp.local.", "EnvironmentService", 50051, "path=index.html");
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
            case "SET_LIGHTING":
                handleLightingControl(); //Set the lighting level
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
        int ventilationLevel = 1; //Default ventilationLevel
        String errorMessage = null;

        //Getting text inpt from the panelService1
        String ventilationLevelText = panelService1.getVentilationLevelField().getText().trim();

        if (ventilationLevelText.isEmpty()) 
        {
            //If input is empty and setting ventilation level, show error
            if (isSet) 
            {
                errorMessage = "Ventilation level must be between 1-10.";
            }
        } 
        else 
        {
            try 
            {
                ventilationLevel = Integer.parseInt(ventilationLevelText);
                
                //Is the ventilationLevel between 1 and 10
                if (ventilationLevel < 1 || ventilationLevel > 10) 
                {
                    errorMessage = "Ventilation level must be between 1-10.";
                }
            } 
            catch (NumberFormatException e) 
            {
                errorMessage = "Invalid ventilation level input. " + e.getMessage();
            }
        }

        if (errorMessage != null) 
        {
            panelService1.getAirQualReplyField().setText(errorMessage);
            return;
        }


        String operationType = isSet ? "SET" : "GET"; //Determine if we are setting or getting the air quality based on the isSet flag.        

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
                panelService1.getAirQualReplyField().setText("Current Air Quality: " + response.getCurrentAirQuality()); //Update UI to reflect the current air quality and vent level                                                 
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
        float tempLevel = 18.8f; //Default tempeLevel
        String errorMessage = null;
    
        String tempLevelText = panelService1.getTempLevelField().getText().trim();
    
        if (tempLevelText.isEmpty()) 
        {
            //If input is empty and setting temperature, show error message
            if (isSet) 
            {
                errorMessage = "Temperature level must be between 15-100.";
            }
        } 
        else 
        {
            try 
            {
                tempLevel = Float.parseFloat(tempLevelText);
                
                if (tempLevel < 15.0f || tempLevel > 100.0f) //Setting range for temperature
                {
                    errorMessage = "Temperature level must be between 15-100.";
                }
            } 
            catch (NumberFormatException e) 
            {
                errorMessage = "Invalid temperature level input. " + e.getMessage();
            }
        }
    
        if (errorMessage != null) 
        {
            panelService1.getTempReplyField().setText(errorMessage);
            return;
        }
    
        String operationType = isSet ? "SET" : "GET"; //Determine if we are setting or getting the air quality based on the isSet flag.
    
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
                panelService1.getTempReplyField().setText("Current Temperature: " + response.getCurrentTemp()); //Update UI to reflect the current temp and temp level                                                          
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
        int lightingLevel = 0;
        String errorMessage = null;

        try 
        {
            lightingLevel = Integer.parseInt(panelService1.getLightingLevelField().getText());
            if (lightingLevel < 1 || lightingLevel > 10) 
            {
                throw new NumberFormatException("Lighting level must be between 1-10.");
            }
        } 
        catch (NumberFormatException e) 
        {
            errorMessage = "Set lighting level between 1-10";
        }
        
        if (errorMessage != null) 
        {
            panelService1.getLightingReplyField().setText(errorMessage);
            return;
        }
    
        LightingRequest request = LightingRequest.newBuilder() //Build the request object with the lighting level to be set
                .setLightingLevel(lightingLevel) //Set the lighting level
                .build(); //Build the request object

        //Create a blocking stub to communicate with the gRPC server for lighting control
        LightingControlGrpc.LightingControlBlockingStub blockingStub = LightingControlGrpc.newBlockingStub(channel);
        LightingResponse response;
    
        try 
        {
            response = blockingStub.setLighting(request);
            panelService1.getLightingReplyField().setText("New Lighting Level: " + response.getNewLightingLevel()); //Update UI to reflect the lighting level
        } 
        catch (StatusRuntimeException ex) 
        {
            System.err.println("RPC failed: " + ex.getStatus());
        }
    }

    public void close() 
    {
        registrationManagerJMDNS.unregisterService(serviceInfo);
        registrationManagerJMDNS.close();
    }
}
    
    

    

