package so.service2;

import io.grpc.stub.StreamObserver;
import com.google.protobuf.ByteString;

public class CameraControlImpl extends CameraControlGrpc.CameraControlImplBase 
{

    @Override
    public void monitorCamera(CameraRequest request, StreamObserver<CameraFeed> responseObserver) 
    {
        int cameraId = request.getMonitorCamera();
        System.out.println("Monitoring camera ID: " + cameraId); //Printing out the camera we are monitoring

        //Camera stream messages
        for (int i = 0; i < 6; i++) //Set to 5 for test, increase to test dealine error
        {
            byte[] dummyFeed = generateMockStream(cameraId, i); //creating streamdata
            CameraFeed feed = CameraFeed.newBuilder()
                    .setCameraFeed(ByteString.copyFrom(dummyFeed))
                    .build();
            responseObserver.onNext(feed);
            
            try 
            {
                Thread.sleep(1000); //Set the delay per streaming message
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }

        responseObserver.onCompleted();
        System.out.println("Completed streaming for camera ID: " + cameraId);
    }

    private byte[] generateMockStream(int cameraId, int frameNumber) 
    {
        //Generate Mock stream data
        return ("Camera " + cameraId + " Frame " + frameNumber).getBytes();
    }
}

