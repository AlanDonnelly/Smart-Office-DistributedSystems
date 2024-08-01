package so.service3;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *Whiteboard Stream Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service3.proto")
public final class WhiteboardStreamGrpc {

  private WhiteboardStreamGrpc() {}

  public static final String SERVICE_NAME = "service3.WhiteboardStream";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<so.service3.WhiteboardUpdate,
      so.service3.WhiteboardUpdate> getWhiteboardStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WhiteboardStream",
      requestType = so.service3.WhiteboardUpdate.class,
      responseType = so.service3.WhiteboardUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<so.service3.WhiteboardUpdate,
      so.service3.WhiteboardUpdate> getWhiteboardStreamMethod() {
    io.grpc.MethodDescriptor<so.service3.WhiteboardUpdate, so.service3.WhiteboardUpdate> getWhiteboardStreamMethod;
    if ((getWhiteboardStreamMethod = WhiteboardStreamGrpc.getWhiteboardStreamMethod) == null) {
      synchronized (WhiteboardStreamGrpc.class) {
        if ((getWhiteboardStreamMethod = WhiteboardStreamGrpc.getWhiteboardStreamMethod) == null) {
          WhiteboardStreamGrpc.getWhiteboardStreamMethod = getWhiteboardStreamMethod = 
              io.grpc.MethodDescriptor.<so.service3.WhiteboardUpdate, so.service3.WhiteboardUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service3.WhiteboardStream", "WhiteboardStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service3.WhiteboardUpdate.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service3.WhiteboardUpdate.getDefaultInstance()))
                  .setSchemaDescriptor(new WhiteboardStreamMethodDescriptorSupplier("WhiteboardStream"))
                  .build();
          }
        }
     }
     return getWhiteboardStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WhiteboardStreamStub newStub(io.grpc.Channel channel) {
    return new WhiteboardStreamStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WhiteboardStreamBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WhiteboardStreamBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WhiteboardStreamFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WhiteboardStreamFutureStub(channel);
  }

  /**
   * <pre>
   *Whiteboard Stream Service
   * </pre>
   */
  public static abstract class WhiteboardStreamImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Bidirectional stream for updates
     * </pre>
     */
    public io.grpc.stub.StreamObserver<so.service3.WhiteboardUpdate> whiteboardStream(
        io.grpc.stub.StreamObserver<so.service3.WhiteboardUpdate> responseObserver) {
      return asyncUnimplementedStreamingCall(getWhiteboardStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getWhiteboardStreamMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                so.service3.WhiteboardUpdate,
                so.service3.WhiteboardUpdate>(
                  this, METHODID_WHITEBOARD_STREAM)))
          .build();
    }
  }

  /**
   * <pre>
   *Whiteboard Stream Service
   * </pre>
   */
  public static final class WhiteboardStreamStub extends io.grpc.stub.AbstractStub<WhiteboardStreamStub> {
    private WhiteboardStreamStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WhiteboardStreamStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WhiteboardStreamStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WhiteboardStreamStub(channel, callOptions);
    }

    /**
     * <pre>
     *Bidirectional stream for updates
     * </pre>
     */
    public io.grpc.stub.StreamObserver<so.service3.WhiteboardUpdate> whiteboardStream(
        io.grpc.stub.StreamObserver<so.service3.WhiteboardUpdate> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getWhiteboardStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *Whiteboard Stream Service
   * </pre>
   */
  public static final class WhiteboardStreamBlockingStub extends io.grpc.stub.AbstractStub<WhiteboardStreamBlockingStub> {
    private WhiteboardStreamBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WhiteboardStreamBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WhiteboardStreamBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WhiteboardStreamBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   *Whiteboard Stream Service
   * </pre>
   */
  public static final class WhiteboardStreamFutureStub extends io.grpc.stub.AbstractStub<WhiteboardStreamFutureStub> {
    private WhiteboardStreamFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WhiteboardStreamFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WhiteboardStreamFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WhiteboardStreamFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_WHITEBOARD_STREAM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WhiteboardStreamImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WhiteboardStreamImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WHITEBOARD_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.whiteboardStream(
              (io.grpc.stub.StreamObserver<so.service3.WhiteboardUpdate>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class WhiteboardStreamBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WhiteboardStreamBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return so.service3.Service3Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WhiteboardStream");
    }
  }

  private static final class WhiteboardStreamFileDescriptorSupplier
      extends WhiteboardStreamBaseDescriptorSupplier {
    WhiteboardStreamFileDescriptorSupplier() {}
  }

  private static final class WhiteboardStreamMethodDescriptorSupplier
      extends WhiteboardStreamBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WhiteboardStreamMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (WhiteboardStreamGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WhiteboardStreamFileDescriptorSupplier())
              .addMethod(getWhiteboardStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
