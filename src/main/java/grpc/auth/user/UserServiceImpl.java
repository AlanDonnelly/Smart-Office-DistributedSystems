package grpc.auth.user;

import io.grpc.stub.StreamObserver;
import grpc.auth.user.UserServiceGrpc.UserServiceImplBase;


public class UserServiceImpl extends UserServiceImplBase 
{

    @Override
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) 
    {
        //Pull the user name and password from the request
        String username = request.getUsername();
        String password = request.getPassword();

        LoginResponse.Builder response = LoginResponse.newBuilder();
        
        if ("user".equals(username) && "pass".equals(password)) //Check to see if username, password match the set values.
        {
            //Return Success response
            response.setResponseCode(200)
                    .setResponseMessage(username + " successfully logged in");
        } 
        else 
        {
            //Return Failure response
            response.setResponseCode(401)
                    .setResponseMessage(username + " sorry login Failed");
        }

        responseObserver.onNext(response.build()); //Send response to client
        responseObserver.onCompleted(); 
    }

    @Override
    public void logout(LogoutRequest request, StreamObserver<LogoutResponse> responseObserver) 
    {
        //Pull the user name from the request
        String username = request.getUsername();

        LogoutResponse.Builder response = LogoutResponse.newBuilder();
        System.out.println("Logging out username = " + username);

        //For simplicity, we assume logout is always successful
        response.setResponseCode(200)
                .setResponseMessage(username + " successfully logged out");

        responseObserver.onNext(response.build()); //Send response to client
        responseObserver.onCompleted();
    }
}
