package so.service2;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionListener;

import io.grpc.stub.StreamObserver;
import so.service2.AlarmControlGrpc;
import so.service3.WhiteboardStreamGrpc;

public class PanelService2 
{

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

        //Camera Control
        

        //Door Control
       

        // Alarm Control Panel
        JPanel alarmControlPanel = new JPanel();
        alarmControlPanel.setLayout(new BoxLayout(alarmControlPanel, BoxLayout.Y_AXIS));

        operationTypeField = new JTextField(10);
        alarmNumberField = new JTextField(10);
        alarmControlOutputArea = new JTextArea(5, 20);
        alarmControlOutputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(alarmControlOutputArea);

        alarmControlPanel.add(new JLabel("Operation Type (startAlarm/stopAlarm):"));
        alarmControlPanel.add(operationTypeField);
        alarmControlPanel.add(new JLabel("Alarm Number:"));
        alarmControlPanel.add(alarmNumberField);
        alarmControlPanel.add(new JLabel("Response:"));
        alarmControlPanel.add(scrollPane);

        sendAlarmRequestButton = new JButton("Send Alarm Request");
        sendAlarmRequestButton.setActionCommand("SEND_ALARM_REQUEST");
        sendAlarmRequestButton.addActionListener(listener);
        alarmControlPanel.add(sendAlarmRequestButton);

        //Creating a panel for the back button and centering it
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButton = new JButton("Back to Main Menu");
        backButton.setActionCommand("BACK_TO_MAIN_MENU");
        backButton.addActionListener(listener);
        backButtonPanel.add(backButton);

        //Combining the Panels        
        panel.add(alarmControlPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); //Space between panels       
        panel.add(backButtonPanel); 

        return panel;
    }

    //Get methods 
    
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
