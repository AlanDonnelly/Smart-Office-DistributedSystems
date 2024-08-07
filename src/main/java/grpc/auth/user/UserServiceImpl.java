package grpc.auth.user;

import io.grpc.stub.StreamObserver;
import grpc.auth.user.UserServiceGrpc.UserServiceImplBase;


public class UserServiceImpl extends UserServiceImplBase 
{

    @Override
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) 
    {
        String username = request.getUsername();
        String password = request.getPassword();

        LoginResponse.Builder response = LoginResponse.newBuilder();
        
        if ("user".equals(username) && "pass".equals(password)) 
        {
            // return Success response
            response.setResponseCode(200)
                    .setResponseMessage(username + ".....Successfully logged in");
        } 
        else 
        {
            // return Failure response
            response.setResponseCode(401)
                    .setResponseMessage(username + "... Sorry Login Failed");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(LogoutRequest request, StreamObserver<LogoutResponse> responseObserver) 
    {
        String username = request.getUsername();

        LogoutResponse.Builder response = LogoutResponse.newBuilder();
        System.out.println("Logging out username = " + username);

        // For simplicity, assume logout is always successful
        response.setResponseCode(200)
                .setResponseMessage(username + ".....Successfully logged out");

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
