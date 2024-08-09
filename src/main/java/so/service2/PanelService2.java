package so.service2;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionListener;



public class PanelService2 
{

    //Camera Control Components
    private JTextField cameraNumberField;
    private JButton startStreamButton;
    private JButton stopStreamButton;
    private JTextArea streamingUpdatesArea;
    //Door Control Components
    private JTextField doorOperationTypeField;
    private JTextField doorNumberField;
    private JButton sendDoorRequestButton;
    private JTextArea doorControlOutputArea;
    //Alarm Control Components
    private JTextField operationTypeField;
    private JTextField alarmNumberField;   
    private JButton sendAlarmRequestButton;
    private JTextArea alarmControlOutputArea;
    private JButton backButton; 

    public JPanel createPanel(ActionListener listener) //Service 3 Panel
    {
        JPanel panel = new JPanel(); 
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);

        JLabel titleLabel = new JLabel("SECURITY SYSTEM"); //Labeling the Service Panel
        titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT); //Centering the label
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); //Adding space below the lable 

        //Camera Control Panel
        JPanel cameraControlPanel = new JPanel();
        cameraControlPanel.setLayout(new BoxLayout(cameraControlPanel, BoxLayout.Y_AXIS));

        startStreamButton = new JButton("Start Camera Control");
        startStreamButton.setActionCommand("CAMERA_STREAM_START");
        startStreamButton.addActionListener(listener);
        cameraControlPanel.add(startStreamButton);

        stopStreamButton = new JButton("Stop Camera Control");
        stopStreamButton.setActionCommand("CAMERA_STREAM_STOP");
        stopStreamButton.addActionListener(listener);
        cameraControlPanel.add(stopStreamButton);

        //Add input for camera number
        cameraNumberField = new JTextField(5);
        cameraControlPanel.add(new JLabel("Camera Number:"));
        cameraControlPanel.add(cameraNumberField);

        streamingUpdatesArea = new JTextArea(5, 50);
        streamingUpdatesArea.setEditable(false);
        JScrollPane cameraScrollPane = new JScrollPane(streamingUpdatesArea);
        cameraControlPanel.add(new JLabel("Streaming Updates:"));
        cameraControlPanel.add(cameraScrollPane);
        cameraControlPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        //Door Control Panel
        JPanel doorControlPanel = new JPanel();
        doorControlPanel.setLayout(new BoxLayout(doorControlPanel, BoxLayout.Y_AXIS));

        doorOperationTypeField = new JTextField(5);
        doorNumberField = new JTextField(5);
        doorControlOutputArea = new JTextArea(2, 2);
        doorControlOutputArea.setEditable(false);
        JScrollPane doorScrollPane = new JScrollPane(doorControlOutputArea);

        doorControlPanel.add(new JLabel("Operation Type (lockDoor/unlockDoor):"));
        doorControlPanel.add(doorOperationTypeField);
        doorControlPanel.add(new JLabel("Door Number:"));
        doorControlPanel.add(doorNumberField);
        doorControlPanel.add(new JLabel("Response:"));
        doorControlPanel.add(doorScrollPane);

        sendDoorRequestButton = new JButton("Control Doors");
        sendDoorRequestButton.setActionCommand("DOOR_CONTROL");
        sendDoorRequestButton.addActionListener(listener);
        doorControlPanel.add(sendDoorRequestButton);
        doorControlPanel.add(Box.createRigidArea(new Dimension(0, 20)));
       

        //Alarm Control Panel
        JPanel alarmControlPanel = new JPanel();
        alarmControlPanel.setLayout(new BoxLayout(alarmControlPanel, BoxLayout.Y_AXIS));

        operationTypeField = new JTextField(5);
        alarmNumberField = new JTextField(5);
        alarmControlOutputArea = new JTextArea(2, 2);
        alarmControlOutputArea.setEditable(false);
        JScrollPane alarmScrollPane = new JScrollPane(alarmControlOutputArea);

        alarmControlPanel.add(new JLabel("Operation Type (startAlarm/stopAlarm):"));
        alarmControlPanel.add(operationTypeField);
        alarmControlPanel.add(new JLabel("Alarm Number:"));
        alarmControlPanel.add(alarmNumberField);
        alarmControlPanel.add(new JLabel("Response:"));
        alarmControlPanel.add(alarmScrollPane);

        sendAlarmRequestButton = new JButton("Control Alarms");
        sendAlarmRequestButton.setActionCommand("ALARM_CONTROL");
        sendAlarmRequestButton.addActionListener(listener);
        alarmControlPanel.add(sendAlarmRequestButton);
        alarmControlPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        //Creating a panel for the back button and centering it
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButton = new JButton("Back to Main Menu");
        backButton.setActionCommand("BACK_TO_MAIN_MENU");
        backButton.addActionListener(listener);
        backButtonPanel.add(backButton);

        //Combining the Panels    
        panel.add(cameraControlPanel); 
        panel.add(doorControlPanel);    
        panel.add(alarmControlPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); //Space between panels       
        panel.add(backButtonPanel); 

        return panel;
    }

    //Get methods 

    //Getter for Camera Control
    public JTextField getCameraNumberField() {
        return cameraNumberField;
    }
    public JTextArea getStreamingUpdatesArea() {
        return streamingUpdatesArea;
    }

    //Get methods for Door Control
    public JTextField getDoorOperationTypeField() {
        return doorOperationTypeField;
    }

    public JTextField getDoorNumberField() {
        return doorNumberField;
    }

    public JTextArea getDoorControlOutputArea() {
        return doorControlOutputArea;
    }
    
    //Get methods for Alarm Control
    public JTextField getOperationTypeField() {
        return operationTypeField;
    }

    public JTextField getAlarmNumberField() {
        return alarmNumberField;
    }

    public JTextArea getAlarmControlOutputArea() {
        return alarmControlOutputArea;
    }

    public JButton getBackButton() 
    {
        return backButton;
    }
}
