package so.service2;

import io.grpc.stub.StreamObserver;

public class AlarmControlImpl extends AlarmControlGrpc.AlarmControlImplBase 
{

    private String alarmState = "disarmed"; //Default state for alarms

    @Override
    public void controlAlarm(AlarmRequest request, StreamObserver<AlarmResponse> responseObserver) 
    {
        String operationType = request.getOperationType();
        int alarmNumber = request.getAlarmNumber();

        //Validate alarm number is between 1 and 5
    if (alarmNumber < 1 || alarmNumber > 5) 
    {        
        AlarmResponse response = AlarmResponse.newBuilder()
                .setCurrentAlarmState("Alarm number must be between 1-5.") //Error message
                .setNewAlarmState("unknown")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
        return;
    }

        //Determine new alarm state based on operationType
        String newAlarmState;
        if ("startAlarm".equalsIgnoreCase(operationType)) 
        {
            newAlarmState = "raised";
        } 
        else if ("stopAlarm".equalsIgnoreCase(operationType)) 
        {
            newAlarmState = "disarmed";
        } 
        else 
        {
            //Handle unknown operationType
            newAlarmState = "unknown";
        }

        //Build the response
        AlarmResponse response = AlarmResponse.newBuilder()
                .setCurrentAlarmState(alarmState)
                .setNewAlarmState(newAlarmState)
                .build();

        //Update the current state if operation is valid
        if (!"unknown".equals(newAlarmState)) 
        {
            alarmState = newAlarmState;
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
