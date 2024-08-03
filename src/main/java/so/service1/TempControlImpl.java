package so.service1;

import io.grpc.stub.StreamObserver;

public class TempControlImpl extends TempControlGrpc.TempControlImplBase 
{

    private float temp = 37.5f; //Default temperature value

    @Override
    public void setTemp(TempRequest request, StreamObserver<TempResponse> responseObserver) 
    {
        float tempLevel = request.getTempLevel();

        //Check if tempLevel is between 15 and 100
        if (tempLevel < 15.0f || tempLevel > 100.0f) 
        {
            tempLevel = 30.0f; //If out of range, set to 30
        }
        //Update the internal temperature
        temp = tempLevel;

        //Build the response with the updated temperature and new temperature level
        TempResponse response = TempResponse.newBuilder()
                .setCurrentTemp(temp) //Set the current temperature
                .setNewTempLevel(String.valueOf(tempLevel)) //Set new temperature level as a string
                .build();

        responseObserver.onNext(response); //Send response to client
        responseObserver.onCompleted();
    }

    @Override
    public void getTemp(TempRequest request, StreamObserver<TempResponse> responseObserver) 
    {
        //Build the response with the current temperature and a default value for tempLevel
        TempResponse response = TempResponse.newBuilder()
                .setCurrentTemp(temp) //Set current temperature
                .setNewTempLevel("37.5") //Set default value for temperature level
                .build();

        responseObserver.onNext(response); //Send response to client
        responseObserver.onCompleted();
    }
}
