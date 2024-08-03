package so;

import io.grpc.Server;
import io.grpc.ServerBuilder;
//Service 1 Imports
import so.service1.AirQualImpl;
import so.service1.TempControlImpl;
//Service 2 Imports

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
        int port = 50051;

        try 
        {
        //Add Services to server

            Server server = ServerBuilder.forPort(port)
                //Service 1:
                .addService(new AirQualImpl()) //Add AirQualImpl service
                .addService(new TempControlImpl()) //Add TempControlImpl service
                //Service 2:

                //Service 3:
                .addService(new WhiteboardCreationImpl()) //Add Whiteboard Creaiton
                .addService(new WhiteboardContentImpl()) //Add Whiteboard Content
                .addService(new WhiteboardStreamImpl()) //Add Whiteboard Stream                
                .build()
                .start();
    
            logger.info("Server started, listening on " + port); //Confirmation message to show server is running
           
            server.awaitTermination(); // Run server until terminated
        } 
        catch (IOException | InterruptedException e) 
        {
            logger.severe("Server failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


