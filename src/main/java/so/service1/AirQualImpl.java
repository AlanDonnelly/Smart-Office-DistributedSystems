package so.service1;

import io.grpc.stub.StreamObserver;

public class AirQualImpl extends AirQualityControlGrpc.AirQualityControlImplBase 
{

    private int airQuality = 100; //Set dfault air quality value

    @Override
    public void setAirQual(AirQualRequest request, StreamObserver<AirQualResponse> responseObserver) 
    {
        int ventilationLevel = request.getVentilationLevel();

        //Check if ventilation level is between 1 and 10
        if (ventilationLevel < 1 || ventilationLevel > 10) 
        {
            ventilationLevel = 1; //If its out of range set to 1
        }
        //Air quality increases with higher ventilation level
        airQuality = 0 + ventilationLevel * 10;

        AirQualResponse response = AirQualResponse.newBuilder() //Building with updated air quality level and new ventilation level
                .setCurrentAirQuality(airQuality) //Set the current air quality in the response
                .setNewVentilationLevel(String.valueOf(ventilationLevel)) //Set the new ventilation level as a string
                .build();

        responseObserver.onNext(response); //Send response to client
        responseObserver.onCompleted();
    }

    @Override //Build response with the current air quality and a default value for ventilation
    public void getAirQual(AirQualRequest request, StreamObserver<AirQualResponse> responseObserver) 
    {
        AirQualResponse response = AirQualResponse.newBuilder()
                .setCurrentAirQuality(airQuality) //Set current air quality in response
                .setNewVentilationLevel("0") //Set default value for ventilation
                .build();

        responseObserver.onNext(response); //Send the response to the client
        responseObserver.onCompleted();
    }
}
