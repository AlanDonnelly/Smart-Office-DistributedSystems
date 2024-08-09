package so.service3;

import io.grpc.stub.StreamObserver;
import so.service3.WhiteboardCreationGrpc.WhiteboardCreationImplBase;

public class WhiteboardCreationImpl extends WhiteboardCreationImplBase 
{
    @Override
    public void createWhiteboard(CreateWhiteboardRequest request, StreamObserver<CreateWhiteboardResponse> responseObserver) 
    {
        String whiteboardName = request.getNewWhiteboard(); //Pull the whiteboard name from the request
        
        CreateWhiteboardResponse response = CreateWhiteboardResponse.newBuilder() //Build a repsonse with the whiteboard name
                .setWhiteboardName(whiteboardName)
                .build();
        
        responseObserver.onNext(response); //Send to client
        responseObserver.onCompleted();
    }
}
