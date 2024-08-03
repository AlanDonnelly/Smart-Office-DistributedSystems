package so.service1;

import io.grpc.stub.StreamObserver;

public class LightingControlImpl extends LightingControlGrpc.LightingControlImplBase 
{

    private int lightingLevel = 1; //Set Default Lighting level

    @Override
    public void setLighting(LightingRequest request, StreamObserver<LightingResponse> responseObserver) 
    {
        int newLightingLevel = request.getLightingLevel();

        //Check if lighting level is between 1 and 10
        if (newLightingLevel < 1 || newLightingLevel > 10) 
        {
            newLightingLevel = 1; //If its out of range set to 1
        }
        lightingLevel = newLightingLevel;

        LightingResponse response = LightingResponse.newBuilder() //Building with updated lighting level
                .setNewLightingLevel(String.valueOf(lightingLevel)) //Set the new lighting level as a string
                .build();

        responseObserver.onNext(response); //Send response to client
        responseObserver.onCompleted();
    }
}
