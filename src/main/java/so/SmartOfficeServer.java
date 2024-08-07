package so;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import grpc.auth.user.UserServiceImpl; 

//Service 1 Imports
import so.service1.AirQualImpl;
import so.service1.TempControlImpl;
import so.service1.LightingControlImpl;

//Service 2 Imports
import so.service2.AlarmControlImpl;
import so.service2.CameraControlImpl;
import so.service2.DoorControlImpl;

//Service 3 Imports
import so.service3.WhiteboardContentImpl;
import so.service3.WhiteboardCreationImpl;
import so.service3.WhiteboardStreamImpl;


import java.io.IOException;
import java.util.logging.Logger;

public class SmartOfficeServer 
{

    private static final Logger logger = Logger.getLogger(SmartOfficeServer.class.getName());

    public static void main(String[] args) 
    {
        try 
        {

        //Start authentication service
            Server authServer = ServerBuilder.forPort(50050)
                .addService(new UserServiceImpl()) //Use UserServiceImpl here                
                .build();

            //Message to show authentication service is running
            logger.info("Authenticating on port 50050");
                

        //Add Services to server
            Server service1Server = ServerBuilder.forPort(50051)
            
                //Service 1:
                .addService(new AirQualImpl()) //Add AirQualImpl service
                .addService(new TempControlImpl()) //Add TempControlImpl service
                .addService(new LightingControlImpl()) //Add LightingControlImpl service
                .build();
            
            Server service2Server = ServerBuilder.forPort(50052)
                //Service 2:
                .addService(new CameraControlImpl()) //Add CameraControlImpl service
                .addService(new DoorControlImpl()) //Add DoorControlImpl service
                .addService(new AlarmControlImpl()) //Add AlarmControlImpl service
                .build();
            
            Server service3Server = ServerBuilder.forPort(50053)
                //Service 3:
                .addService(new WhiteboardCreationImpl()) //Add Whiteboard Creaiton
                .addService(new WhiteboardContentImpl()) //Add Whiteboard Content
                .addService(new WhiteboardStreamImpl()) //Add Whiteboard Stream                
                .build();
                
            //Start servers
            authServer.start();  //Start the authentication server
            service1Server.start();
            service2Server.start();
            service3Server.start();

            logger.info("Servers started, listening on ports "+ 50050 + ", "+ 50051 + ", " + 50052 + ", " + 50053);  //Confirmation message to show server is running           
           
            authServer.awaitTermination();
            service1Server.awaitTermination();
            service2Server.awaitTermination();
            service3Server.awaitTermination(); //Run server until terminated
        } 
        catch (IOException | InterruptedException e) 
        {
            logger.severe("Server failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


