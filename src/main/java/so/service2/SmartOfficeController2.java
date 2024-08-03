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
import so.client.MainMenu;

public class SmartOfficeController2 implements ActionListener 
{

    private PanelService2 panelService2; 
    private ManagedChannel channel;
    private JFrame frame; 

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
            case "CAMERA_CONTROL":
                handleCameraControl();
                break;
            case "DOOR_CONTROL":
                handleDoorControl();
                break;
            case "ALARM_CONTROL":
                handleAlarmControl();
                break;
            case "BACK_TO_MAIN_MENU":
                handleBackToMainMenu(); //Handle back to main menu
                break;
            default:
                System.out.println("Unknown action command: " + label);
                break;
        }
    }

    private void handleBackToMainMenu() {
        if (frame != null) {
            frame.dispose(); // Close the current window
        }
        SwingUtilities.invokeLater(() -> {
            MainMenu.main(new String[0]); // Restart the main menu
        });
    }

    // Service 2 methods
    private void handleCameraControl() 
    {
        System.out.println("Service 2 Camera Control...");
        
    }

    private void handleDoorControl() 
    {
        System.out.println("Service 2 Door Control...");
       
    }

    private void handleAlarmControl() 
    {
        System.out.println("Service 2 Alarm Control...");
        
    }
}
