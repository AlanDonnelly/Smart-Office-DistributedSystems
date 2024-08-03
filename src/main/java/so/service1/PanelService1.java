package so.service1;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.event.ActionListener;

public class PanelService1 
{

    private JTextField operationTypeField;
    private JTextField ventilationLevelField;
    private JTextField airQualReplyField;
    private JTextField tempLevelField;
    private JTextField tempReplyField;
    private JButton setAirQualButton;
    private JButton getAirQualButton;
    private JButton setTempButton;
    private JButton getTempButton;
    private JButton backButton; 

    public JPanel createPanel(ActionListener listener) 
    {
        JPanel panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        // Air Quality Control Panel
        JPanel airQualPanel = new JPanel();
        BoxLayout airQualLayout = new BoxLayout(airQualPanel, BoxLayout.X_AXIS);

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
        BoxLayout tempLayout = new BoxLayout(tempPanel, BoxLayout.X_AXIS);

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

        //Back button
        backButton = new JButton("Back to Main Menu");
        backButton.setActionCommand("BACK_TO_MAIN_MENU");
        backButton.addActionListener(listener);
        tempPanel.add(backButton);

        //Add panels to main panel
        panel.add(airQualPanel);
        panel.add(tempPanel);
        panel.setLayout(boxLayout);

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
            // Ensure ventilation level is between 1 and 10
            if (level < 1 || level > 10) {
                throw new NumberFormatException("Ventilation level must be between 1 and 10.");
            }
            return level;
        } catch (NumberFormatException e) {
            System.err.println("Invalid ventilation level input. " + e.getMessage());
            return 1; // Default value or handle as needed
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

    public float getTempLevel() {
        try {
            float level = Float.parseFloat(tempLevelField.getText());
            // Ensure temperature level is between 15 and 100
            if (level < 15.0f || level > 100.0f) {
                throw new NumberFormatException("Temperature level must be between 15 and 100.");
            }
            return level;
        } catch (NumberFormatException e) {
            System.err.println("Invalid temperature level input. " + e.getMessage());
            return 30.0f; // Default value or handle as needed
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
}
