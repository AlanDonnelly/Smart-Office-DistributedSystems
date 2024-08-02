package so;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import so.service3.WhiteboardContentImpl;
import so.service3.WhiteboardCreationImpl;

import java.io.IOException;
import java.util.logging.Logger;

public class SmartOfficeServer 
{

    private static final Logger logger = Logger.getLogger(SmartOfficeServer.class.getName());

    public static void main(String[] args) 
    {
        int portWhiteboardCreation = 50051; //Port: WhiteboardCreation
        int portWhiteboardContent = 50052;  //Port: WhiteboardContent

        try 
        {
        //Service 3:

            //Whiteboard Creation
            Server whiteboardCreationServer = ServerBuilder.forPort(portWhiteboardCreation) //Creating and starting the server                
                .addService(new WhiteboardCreationImpl()) //Adding the WhiteboardCreation service implementation                
                .build() //Build the server
                .start(); //Start the server
            logger.info("Server started, listening on " + portWhiteboardCreation); //Confirmation message to show server is running

            //Whiteboard Content
            Server whiteboardContentServer  = ServerBuilder.forPort(portWhiteboardContent) //Creating and starting the server                
                .addService(new WhiteboardContentImpl()) //Adding the WhiteboardContent service implementation                
                .build() //Build the server
                .start(); //Start the server
            logger.info("Server started, listening on " + portWhiteboardContent); //Confirmation message to show server is running

           
            whiteboardCreationServer.awaitTermination(); //Run server until terminated
            whiteboardContentServer.awaitTermination(); 
        } 
        catch (IOException | InterruptedException e) 
        {
            logger.severe("Server failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


