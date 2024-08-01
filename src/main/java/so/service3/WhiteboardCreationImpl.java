package so.service3;

import io.grpc.stub.StreamObserver;
import so.service3.WhiteboardCreationGrpc.WhiteboardCreationImplBase;

public class WhiteboardCreationImpl extends WhiteboardCreationImplBase 
{
    @Override
    public void createWhiteboard(CreateWhiteboardRequest request, StreamObserver<CreateWhiteboardResponse> responseObserver) 
    {
        String whiteboardName = request.getNewWhiteboard();
        
        CreateWhiteboardResponse response = CreateWhiteboardResponse.newBuilder()
                .setWhiteboardName(whiteboardName)
                .build();
        
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
