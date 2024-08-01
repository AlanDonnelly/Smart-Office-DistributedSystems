package so;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import so.service3.WhiteboardCreationImpl;

import java.io.IOException;
import java.util.logging.Logger;

public class SmartOfficeServer 
{

    private static final Logger logger = Logger.getLogger(SmartOfficeServer.class.getName());

    public static void main(String[] args) 
    {
        int port = 50051; //Listening port number

        try 
        {
            
            Server server = ServerBuilder.forPort(port) //Creating and starting the server
                
                .addService(new WhiteboardCreationImpl()) //Adding the WhiteboardCreation service implementation
                
                .build() //Build the server
                .start(); //Start the server

            logger.info("Server started, listening on " + port); //Confirmation message to show server is running

           
            server.awaitTermination(); //Run server until terminated
        } 
        catch (IOException | InterruptedException e) 
        {
            logger.severe("Server failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


