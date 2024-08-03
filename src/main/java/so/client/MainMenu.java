package so.client;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import so.service1.SmartOfficeController1;
import so.service2.SmartOfficeController2;
import so.service3.SmartOfficeController3;

public class MainMenu 
{

    public static void main(String[] args) 
    {
        JOptionPane.showMessageDialog(null, "Welcome to your Smart Office");
        JOptionPane.showMessageDialog(null, "Select the service you wish to manage");
        String[] options = {"Environment System", "Security System", "Whiteboard System"};
        int choice = JOptionPane.showOptionDialog(null, "SMART OFFICE SERVICE MENU",
                "Main Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0] // Default option
        );

        switch (choice) 
        {
            case 0:
                //Start Service 1 Controller 
                SwingUtilities.invokeLater(() -> 
                {
                    SmartOfficeController1 controller = new SmartOfficeController1();
                    controller.build();
                });
                break;
            case 1:
                //Start Service 2 Controller
                SwingUtilities.invokeLater(() -> 
                {
                    SmartOfficeController2 controller = new SmartOfficeController2();
                    controller.build();
                });
                break;
            case 2:
                //Start Service 3 Controller
                SwingUtilities.invokeLater(() -> 
                {
                    SmartOfficeController3 controller = new SmartOfficeController3();
                    controller.build();
                });
                break;
            default:
                System.out.println("No valid option selected.");
                break;
        }
    }
}
