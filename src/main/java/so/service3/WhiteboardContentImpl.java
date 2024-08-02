package so.service3;

import io.grpc.stub.StreamObserver;
import so.service3.WhiteboardContentGrpc.WhiteboardContentImplBase;

public class WhiteboardContentImpl extends WhiteboardContentImplBase {

    @Override
    public void addContent(AddContentRequest request, StreamObserver<AddContentResponse> responseObserver) {
        // Extract content and whiteboard name from the request
        String whiteboardName = request.getWhiteboardName();
        String contentToAdd = request.getAddContent();

        // Process the content and whiteboard name
        // Here we simulate adding content to a whiteboard with a simple print statement
        System.out.println("Adding content to whiteboard '" + whiteboardName + "': " + contentToAdd);

        // Create a response object
        AddContentResponse response = AddContentResponse.newBuilder()
                .setNewWhiteboardContent("Content added to whiteboard '" + whiteboardName + "': " + contentToAdd)
                .build();

        // Send the response to the client
        responseObserver.onNext(response);
        
        // Complete the RPC call
        responseObserver.onCompleted();
    }
}
