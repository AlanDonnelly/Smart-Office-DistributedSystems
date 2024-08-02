package so.service3;

import io.grpc.stub.StreamObserver;
import so.service3.WhiteboardStreamGrpc;
import so.service3.WhiteboardUpdate;

public class WhiteboardStreamImpl extends WhiteboardStreamGrpc.WhiteboardStreamImplBase {

    @Override
    public StreamObserver<WhiteboardUpdate> whiteboardStream(StreamObserver<WhiteboardUpdate> responseObserver) {
        return new StreamObserver<WhiteboardUpdate>() {

            @Override
            public void onNext(WhiteboardUpdate value) {
                // Process the incoming update
                String whiteboardName = value.getWhiteboardName();
                String content = value.getContent();

                // Log received update
                System.out.println("Received update for whiteboard: " + whiteboardName);
                System.out.println("Content: " + content);

                // Echo the update back to the client
                WhiteboardUpdate reply = WhiteboardUpdate.newBuilder()
                        .setWhiteboardName(whiteboardName)
                        .setContent("Received: " + content)
                        .build();
                responseObserver.onNext(reply);
            }

            @Override
            public void onError(Throwable t) {
                // Handle errors
                System.err.println("Error in streaming: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                // Clean up when the stream is completed
                responseObserver.onCompleted();
                System.out.println("Stream completed.");
            }
        };
    }
}

