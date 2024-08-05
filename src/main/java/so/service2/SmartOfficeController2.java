package so.service2;

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
import io.grpc.stub.StreamObserver;

import so.client.MainMenu;


public class SmartOfficeController2 implements ActionListener 
{

    private PanelService2 panelService2; 
    private ManagedChannel channel;
    private JFrame frame; 
    private StreamObserver<CameraFeed> responseObserver;    

    public SmartOfficeController2() 
    {
        panelService2 = new PanelService2();
        channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
    }

    public void build() 
    {
        frame = new JFrame("Service 2 Controller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(); //Setting up the panel to hold the UI components
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS); //Creating the vertical axis layout for the components
        panel.setLayout(boxLayout);
        panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100))); // Create a border for the panel
        panel.add(panelService2.createPanel(this)); //Pass "this" as ActionListener

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
            case "CAMERA_STREAM_START":
                handleCameraControl();
                break;
            case "CAMERA_STREAM_STOP":
                handleStopCameraControl();
                break;            
            case "DOOR_CONTROL":
                handleDoorControl();
                break;            
            case "ALARM_CONTROL":
                handleAlarmControl();
                break;            
            case "BACK_TO_MAIN_MENU":
                handleBackToMainMenu(); 
                break;
            default:
                System.out.println("Unknown action command: " + label);
                break;
        }
    }

    private void handleBackToMainMenu() 
    {
        if (frame != null) {
            frame.dispose(); //Close the current window
        }
        SwingUtilities.invokeLater(() -> 
        {
            MainMenu.main(new String[0]); //Restart the main menu
        });
    }

    //Service 2 methods
    private void handleCameraControl() 
    {
        System.out.println("Starting Camera Control...");
    
        //Get the camera number for the UI Panel
        String cameraNumberText = panelService2.getCameraNumberField().getText().trim();
        int cameraNumber;
        try 
        {
            cameraNumber = Integer.parseInt(cameraNumberText);
        } 
        catch (NumberFormatException e) 
        {
            System.err.println("Please enter a camera ID number.");
            SwingUtilities.invokeLater(() -> 
            {
                panelService2.getCameraNumberField().setText("Please enter a camera ID number.");
            });
            return;
        }
    
        //Create a stub for the CameraControl service
        CameraControlGrpc.CameraControlStub cameraControlStub = CameraControlGrpc.newStub(channel);
    
        //Create a response observer to handle camera feed
        responseObserver = new StreamObserver<CameraFeed>() 
        {
            @Override
            public void onNext(CameraFeed cameraFeed) 
            {
                if (responseObserver == null) 
                {
                    //Ignore data if the stream was stopped
                    return;
                }
                byte[] feedData = cameraFeed.getCameraFeed().toByteArray();
                System.out.println("Camera Streaming, data size: " + feedData.length);
                panelService2.getStreamingUpdatesArea().append("Camera Streaming, data size: " + feedData.length + "\n");
            }
    
            @Override
            public void onError(Throwable t) 
            {
                System.err.println("Camera stream error: " + t.getMessage());
                SwingUtilities.invokeLater(() -> 
                {
                    panelService2.getStreamingUpdatesArea().append("Camera stream error: " + t.getMessage() + "\n"); //Printing to field
                });
            }
    
            @Override
            public void onCompleted() 
            {
                System.out.println("Camera stream completed.");
                SwingUtilities.invokeLater(() -> 
                {
                    panelService2.getStreamingUpdatesArea().append("Camera stream completed.\n"); //Printing to field
                });
            }
        };
    
        //Create and send request with the camera number
        CameraRequest request = CameraRequest.newBuilder()
                .setMonitorCamera(cameraNumber) //Use the user defined camera number
                .build();
    
        cameraControlStub.monitorCamera(request, responseObserver);
    }
    

    private void handleStopCameraControl() 
    {
        if (responseObserver != null) {
            responseObserver.onError(new RuntimeException("Camera stream stopped by user."));
            responseObserver = null; //Clean up reference
            System.out.println("Camera stream stopped.");
            SwingUtilities.invokeLater(() -> 
            {
                panelService2.getStreamingUpdatesArea().append("Camera stream stopped by user.\n");
            });
        } 
        else 
        {
            System.out.println("No camera is streaming.");
        }
    }
    
    

    private void handleDoorControl() 
    {
        try 
        {
            String operationType = panelService2.getDoorOperationTypeField().getText().trim();
            int doorNumber = Integer.parseInt(panelService2.getDoorNumberField().getText().trim());

            DoorRequest request = DoorRequest.newBuilder()
                    .setOperationType(operationType)
                    .setDoorNumber(doorNumber)
                    .build();

            DoorControlGrpc.DoorControlBlockingStub stub = DoorControlGrpc.newBlockingStub(channel);
            DoorResponse response = stub.controlDoor(request);

            panelService2.getDoorControlOutputArea().setText(
                    "Current Door State: " + response.getCurrentDoorState() + "\n" +
                    "New Door State: " + response.getNewDoorState()
            );

        } 
        catch (NumberFormatException ex) 
        {
            System.err.println("Invalid door number. Please enter a valid number.");
            SwingUtilities.invokeLater(() -> 
            {
                panelService2.getDoorNumberField().setText("Invalid door number. Please enter a valid number.");
            });
        } 
        catch (StatusRuntimeException ex) {
            System.err.println("RPC failed: " + ex.getStatus());
        }
    }


    private void handleAlarmControl() 
    {
        try 
        {
            //Get values from UI components
            String operationType = panelService2.getOperationTypeField().getText().trim();
            int alarmNumber = Integer.parseInt(panelService2.getAlarmNumberField().getText().trim());

            //Prepare the request
            AlarmRequest request = AlarmRequest.newBuilder()
                    .setOperationType(operationType)
                    .setAlarmNumber(alarmNumber)
                    .build();

            //Make the gRPC call
            AlarmControlGrpc.AlarmControlBlockingStub stub = AlarmControlGrpc.newBlockingStub(channel);
            AlarmResponse response = stub.controlAlarm(request);

            //Display the response in the UI
            panelService2.getAlarmControlOutputArea().setText(
                    "Current Alarm State: " + response.getCurrentAlarmState() + "\n" +
                    "New Alarm State: " + response.getNewAlarmState()
            );

        } 
        catch (NumberFormatException ex) 
        {
            System.err.println("Invalid alarm number. Please enter a valid number."); 
            SwingUtilities.invokeLater(() -> 
            {
                panelService2.getAlarmNumberField().setText("Invalid alarm number. Please enter a valid number.");
            });
                        
        } 
        catch (StatusRuntimeException ex) 
        {
            System.err.println("RPC failed: " + ex.getStatus());                
        }
    }

}