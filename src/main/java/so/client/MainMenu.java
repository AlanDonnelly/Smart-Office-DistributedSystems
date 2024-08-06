package so.client;

import java.io.IOException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.jmdns.JmDNS;
import so.ServiceRegistrationJMDNS;
import so.service1.SmartOfficeController1;
import so.service2.SmartOfficeController2;
import so.service3.SmartOfficeController3;

public class MainMenu 
{
    private static ServiceRegistrationJMDNS registrationManagerJMDNS;
    private static SmartOfficeController1 service1Controller;
    private static SmartOfficeController2 service2Controller;
    private static SmartOfficeController3 service3Controller;
    private static JmDNS jmdns;


    public static void main(String[] args) 
    {
        //Start JmDNS for service discovery
        jmdnsDiscovery();

        //Start the service registration manager
        registrationManagerJMDNS = new ServiceRegistrationJMDNS();        
        registerServices(); //Register services

        JOptionPane.showMessageDialog(null, "Welcome to your Smart Office");
        JOptionPane.showMessageDialog(null, "Select the service you wish to manage");
        String[] options = {"Environment System", "Security System", "Whiteboard System", "Close"};
        int choice = JOptionPane.showOptionDialog(null, "SMART OFFICE SERVICE MENU",
                "Main Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0] //Default option
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
            case 3:
                //Close the application
                closeServices();
                JOptionPane.showMessageDialog(null, "Shutting Down");
                System.out.println("Shutting Down");
                System.exit(0);
                break;
            default:
                System.out.println("No valid option selected.");
                break;
                
        }
    }

    private static void registerServices() 
    {       
        registrationManagerJMDNS.registerService("_smartoffice._tcp.local.", "EnvironmentService", 50051, "path=index.html");
        registrationManagerJMDNS.registerService("_smartoffice._tcp.local.", "SecurityService", 50052, "path=index.html");
        registrationManagerJMDNS.registerService("_smartoffice._tcp.local.", "WhiteboardService", 50053, "path=index.html");
    }

    private static void jmdnsDiscovery() 
    {
        try 
        {
            jmdns = JmDNS.create();
            jmdns.addServiceListener("_smartoffice._tcp.local.", new ServiceDiscoveryListener());
        } 
        catch (IOException e) 
        {
            System.err.println("Couldn't start JmDNS for discovery: " + e.getMessage());
        }
    }

    private static class ServiceDiscoveryListener implements ServiceListener 
    {
        @Override
        public void serviceAdded(ServiceEvent event) 
        {
            System.out.println("Service added: " + event.getInfo());
        }

        @Override
        public void serviceRemoved(ServiceEvent event) 
        {
            System.out.println("Service removed: " + event.getInfo());
        }

        @Override
        public void serviceResolved(ServiceEvent event) 
        {
            ServiceInfo info = event.getInfo();
            System.out.println("Service resolved: " + info);            
        }
    }

    private static void closeServices() {
        if (service1Controller != null) {
            service1Controller.close();
        }
        if (service2Controller != null) {
            service2Controller.close();
        }
        if (service3Controller != null) {
            service3Controller.close();
        }
        
        if (registrationManagerJMDNS != null) {
            registrationManagerJMDNS.close(); //Close the JmDNS instance
        }
    }
}
