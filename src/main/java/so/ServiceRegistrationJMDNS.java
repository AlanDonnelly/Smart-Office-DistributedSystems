package so;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;

public class ServiceRegistrationJMDNS 
{
    private JmDNS jmdns;

    public ServiceRegistrationJMDNS() 
    {
        try 
        {
            jmdns = JmDNS.create(); //Creating JmDNS for registration
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); //Print stack trace if IOException happens during creation
        } 
        catch (Exception e) 
        { 
            e.printStackTrace(); //If any other exceptions occur print the stack trace
        }
    }

    public void registerService(String serviceType, String serviceName, int port, String description) //Register a serviec with JmDNS
    {
        try 
        {
            ServiceInfo serviceInfo = ServiceInfo.create(serviceType, serviceName, port, description); //serviceInfo object with the necessary details of the service
            jmdns.registerService(serviceInfo); //Register with JmDNS
            System.out.println("Service registered: " + serviceInfo); //Confirmation msg
        } 
        catch (Exception e) 
        { 
            e.printStackTrace(); //Print Stacktrace if exception during registration of service
        }
    }

    public void unregisterService(ServiceInfo serviceInfo) 
    {
        try 
        {
            jmdns.unregisterService(serviceInfo); //unregister service from JmDNS
        } 
        catch (Exception e) 
        { 
            e.printStackTrace();
        }
    }

    public void close() 
    {
        try 
        {
            jmdns.close(); //Close JmDNS
        } catch (Exception e) 
        { 
            e.printStackTrace();
        }
    }
}
