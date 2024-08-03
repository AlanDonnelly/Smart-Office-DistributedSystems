package so.service1;

import javax.swing.JTextField;
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

    public int getVentilationLevel() {
        try {
            int level = Integer.parseInt(ventilationLevelField.getText());
            //Ensure ventilation level is between 1 and 10
            if (level < 1 || level > 10) {
                throw new NumberFormatException("Ventilation level must be between 1 and 10.");
            }
            return level;
        } catch (NumberFormatException e) {
            System.err.println("Invalid ventilation level input. " + e.getMessage());
            return 1; //Default value or handle as needed
        }
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

    public float getTempLevel() 
    {
        try 
        {
            float level = Float.parseFloat(tempLevelField.getText());
            //Ensure temperature level is between 15 and 100
            if (level < 15.0f || level > 100.0f) 
            {
                throw new NumberFormatException("Temperature level must be between 15 and 100.");
            }
            return level;
        } 
        catch (NumberFormatException e) 
        {
            System.err.println("Invalid temperature level input. " + e.getMessage());
            return 30.0f; //Default 
        }
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
    public int getLightingLevel() 
    {
        try 
        {
            int level = Integer.parseInt(lightingLevelField.getText());
            //Ensure lighting level is between 1 and 10
            if (level < 1 || level > 10) 
            {
                throw new NumberFormatException("Lighting level must be between 1 and 10, setting to 1");
            }
            return level;
        } 
        catch (NumberFormatException e) 
        {
            System.err.println("Invalid lighting level input. " + e.getMessage());
            return 1; //Default value
        }
    }

    public JTextField getLightingReplyField() {
        return lightingReplyField;
    }

    public JButton getSetLightingButton() {
        return setLightingButton;
    }
}

