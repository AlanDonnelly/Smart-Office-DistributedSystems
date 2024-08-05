package so.service1;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Box;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelService1 
{

    private JTextField operationTypeField;
    private JTextField ventilationLevelField;
    private JTextField airQualReplyField;
    private JTextField tempLevelField;
    private JTextField tempReplyField;
    private JTextField lightingLevelField;
    private JTextField lightingReplyField;

    private JButton setAirQualButton;
    private JButton getAirQualButton;
    private JButton setTempButton;
    private JButton getTempButton;
    private JButton setLightingButton;
    

    private JButton backButton; 

    public JPanel createPanel(ActionListener listener) 
    {
        JPanel panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
        
        JLabel titleLabel = new JLabel("ENVIRONMENT SYSTEM"); //Labeling the Service Panel
        titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT); //Centering the label
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); //Adding space below the lable 

        // Air Quality Control Panel
        JPanel airQualPanel = new JPanel();        

        JLabel ventilationLevelLabel = new JLabel("Ventilation Level (1-10):");
        airQualPanel.add(ventilationLevelLabel);
        airQualPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        ventilationLevelField = new JTextField("", 10);
        airQualPanel.add(ventilationLevelField);
        airQualPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        setAirQualButton = new JButton("Set Air Quality");
        setAirQualButton.setActionCommand("SET_AIR_QUAL");
        setAirQualButton.addActionListener(listener);
        airQualPanel.add(setAirQualButton);

        getAirQualButton = new JButton("Get Air Quality");
        getAirQualButton.setActionCommand("GET_AIR_QUAL");
        getAirQualButton.addActionListener(listener);
        airQualPanel.add(getAirQualButton);

        airQualReplyField = new JTextField("", 20);
        airQualReplyField.setEditable(false);
        airQualPanel.add(airQualReplyField);

        //Temperature Control Panel
        JPanel tempPanel = new JPanel();        

        JLabel tempLevelLabel = new JLabel("Temperature Level (15-100):");
        tempPanel.add(tempLevelLabel);
        tempPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        tempLevelField = new JTextField("", 10);
        tempPanel.add(tempLevelField);
        tempPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        setTempButton = new JButton("Set Temperature");
        setTempButton.setActionCommand("SET_TEMP");
        setTempButton.addActionListener(listener);
        tempPanel.add(setTempButton);

        getTempButton = new JButton("Get Temperature");
        getTempButton.setActionCommand("GET_TEMP");
        getTempButton.addActionListener(listener);
        tempPanel.add(getTempButton);

        tempReplyField = new JTextField("", 20);
        tempReplyField.setEditable(false);
        tempPanel.add(tempReplyField);

        //Lighting Control Panel
        JPanel lightingPanel = new JPanel();
        JLabel lightingLevelLabel = new JLabel("Lighting Level (1-10):");
        lightingPanel.add(lightingLevelLabel);
        lightingPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        lightingLevelField = new JTextField("", 10);
        lightingPanel.add(lightingLevelField);
        lightingPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        setLightingButton = new JButton("Set Lighting");
        setLightingButton.setActionCommand("SET_LIGHTING");
        setLightingButton.addActionListener(listener);
        lightingPanel.add(setLightingButton);

        lightingReplyField = new JTextField("", 20);
        lightingReplyField.setEditable(false);
        lightingPanel.add(lightingReplyField);        

        //Creating a panel for the back button and centering it
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButton = new JButton("Back to Main Menu");
        backButton.setActionCommand("BACK_TO_MAIN_MENU");
        backButton.addActionListener(listener);
        backButtonPanel.add(backButton);

        //Add panels to main panel
        panel.add(airQualPanel);
        panel.add(tempPanel);
        panel.add(lightingPanel);          
        panel.add(backButtonPanel); 

        return panel;
    }

    //Getters
    public String getOperationType() 
    {
        return operationTypeField.getText();
    }

    public JTextField getVentilationLevelField() {
        return ventilationLevelField;
    }

    public JTextField getAirQualReplyField() 
    {
        return airQualReplyField;
    }

    public JButton getSetAirQualButton() 
    {
        return setAirQualButton;
    }

    public JButton getGetAirQualButton() 
    {
        return getAirQualButton;
    }

    //TemperatureControls Getters

    public JTextField getTempLevelField() {
        return tempLevelField;
    }


    public JTextField getTempReplyField() {
        return tempReplyField;
    }

    public JButton getSetTempButton() {
        return setTempButton;
    }

    public JButton getGetTempButton() {
        return getTempButton;
    }

    //LightingControl Getters
    public JTextField getLightingLevelField() {
        return lightingLevelField;
    }

    public JTextField getLightingReplyField() {
        return lightingReplyField;
    }

    public JButton getSetLightingButton() {
        return setLightingButton;
    }
}

