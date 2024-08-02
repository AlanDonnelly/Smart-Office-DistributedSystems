package so;

import io.grpc.Server;
import io.grpc.ServerBuilder;
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
        //Service 3:

            //Whiteboard Creation
            Server server = ServerBuilder.forPort(port)
                .addService(new WhiteboardCreationImpl())
                .addService(new WhiteboardContentImpl())
                .addService(new WhiteboardStreamImpl())
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


