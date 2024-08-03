package so.service2;

import io.grpc.stub.StreamObserver;

public class DoorControlImpl extends DoorControlGrpc.DoorControlImplBase 
{

    private String doorState = "locked"; //Default state for doors

    @Override
    public void controlDoor(DoorRequest request, StreamObserver<DoorResponse> responseObserver) 
    {
        String operationType = request.getOperationType();
        int doorNumber = request.getDoorNumber();

        //Validate alarm number is between 1 and 5
        if (doorNumber < 1 || doorNumber > 10) 
        {        
            DoorResponse response = DoorResponse.newBuilder()
                    .setCurrentDoorState("Door number must be between 1-10.") //Error message
                    .setNewDoorState("unknown")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }

        //Determine new door state based on operationType
        String newDoorState;
        if ("lockDoor".equalsIgnoreCase(operationType)) 
        {
            newDoorState = "Door Locked";
        } 
        else if ("unlockDoor".equalsIgnoreCase(operationType)) 
        {
            newDoorState = "Door Unlocked";
        } 
        else 
        {
            //Handle unknown operationType
            newDoorState = "unknown";
        }

        //Build the response
        DoorResponse response = DoorResponse.newBuilder()
                .setCurrentDoorState(doorState)
                .setNewDoorState(newDoorState)
                .build();

        //Update the current state if operation is valid
        if (!"unknown".equals(newDoorState)) 
        {
            doorState = newDoorState;
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
