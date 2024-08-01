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
 *Whiteboard Creation Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service3.proto")
public final class WhiteboardCreationGrpc {

  private WhiteboardCreationGrpc() {}

  public static final String SERVICE_NAME = "service3.WhiteboardCreation";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<so.service3.CreateWhiteboardRequest,
      so.service3.CreateWhiteboardResponse> getCreateWhiteboardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateWhiteboard",
      requestType = so.service3.CreateWhiteboardRequest.class,
      responseType = so.service3.CreateWhiteboardResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<so.service3.CreateWhiteboardRequest,
      so.service3.CreateWhiteboardResponse> getCreateWhiteboardMethod() {
    io.grpc.MethodDescriptor<so.service3.CreateWhiteboardRequest, so.service3.CreateWhiteboardResponse> getCreateWhiteboardMethod;
    if ((getCreateWhiteboardMethod = WhiteboardCreationGrpc.getCreateWhiteboardMethod) == null) {
      synchronized (WhiteboardCreationGrpc.class) {
        if ((getCreateWhiteboardMethod = WhiteboardCreationGrpc.getCreateWhiteboardMethod) == null) {
          WhiteboardCreationGrpc.getCreateWhiteboardMethod = getCreateWhiteboardMethod = 
              io.grpc.MethodDescriptor.<so.service3.CreateWhiteboardRequest, so.service3.CreateWhiteboardResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service3.WhiteboardCreation", "CreateWhiteboard"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service3.CreateWhiteboardRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service3.CreateWhiteboardResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new WhiteboardCreationMethodDescriptorSupplier("CreateWhiteboard"))
                  .build();
          }
        }
     }
     return getCreateWhiteboardMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WhiteboardCreationStub newStub(io.grpc.Channel channel) {
    return new WhiteboardCreationStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WhiteboardCreationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WhiteboardCreationBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WhiteboardCreationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WhiteboardCreationFutureStub(channel);
  }

  /**
   * <pre>
   *Whiteboard Creation Service
   * </pre>
   */
  public static abstract class WhiteboardCreationImplBase implements io.grpc.BindableService {

    /**
     */
    public void createWhiteboard(so.service3.CreateWhiteboardRequest request,
        io.grpc.stub.StreamObserver<so.service3.CreateWhiteboardResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateWhiteboardMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateWhiteboardMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                so.service3.CreateWhiteboardRequest,
                so.service3.CreateWhiteboardResponse>(
                  this, METHODID_CREATE_WHITEBOARD)))
          .build();
    }
  }

  /**
   * <pre>
   *Whiteboard Creation Service
   * </pre>
   */
  public static final class WhiteboardCreationStub extends io.grpc.stub.AbstractStub<WhiteboardCreationStub> {
    private WhiteboardCreationStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WhiteboardCreationStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WhiteboardCreationStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WhiteboardCreationStub(channel, callOptions);
    }

    /**
     */
    public void createWhiteboard(so.service3.CreateWhiteboardRequest request,
        io.grpc.stub.StreamObserver<so.service3.CreateWhiteboardResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateWhiteboardMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *Whiteboard Creation Service
   * </pre>
   */
  public static final class WhiteboardCreationBlockingStub extends io.grpc.stub.AbstractStub<WhiteboardCreationBlockingStub> {
    private WhiteboardCreationBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WhiteboardCreationBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WhiteboardCreationBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WhiteboardCreationBlockingStub(channel, callOptions);
    }

    /**
     */
    public so.service3.CreateWhiteboardResponse createWhiteboard(so.service3.CreateWhiteboardRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateWhiteboardMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Whiteboard Creation Service
   * </pre>
   */
  public static final class WhiteboardCreationFutureStub extends io.grpc.stub.AbstractStub<WhiteboardCreationFutureStub> {
    private WhiteboardCreationFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WhiteboardCreationFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WhiteboardCreationFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WhiteboardCreationFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<so.service3.CreateWhiteboardResponse> createWhiteboard(
        so.service3.CreateWhiteboardRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateWhiteboardMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_WHITEBOARD = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WhiteboardCreationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WhiteboardCreationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_WHITEBOARD:
          serviceImpl.createWhiteboard((so.service3.CreateWhiteboardRequest) request,
              (io.grpc.stub.StreamObserver<so.service3.CreateWhiteboardResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class WhiteboardCreationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WhiteboardCreationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return so.service3.Service3Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WhiteboardCreation");
    }
  }

  private static final class WhiteboardCreationFileDescriptorSupplier
      extends WhiteboardCreationBaseDescriptorSupplier {
    WhiteboardCreationFileDescriptorSupplier() {}
  }

  private static final class WhiteboardCreationMethodDescriptorSupplier
      extends WhiteboardCreationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WhiteboardCreationMethodDescriptorSupplier(String methodName) {
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
      synchronized (WhiteboardCreationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WhiteboardCreationFileDescriptorSupplier())
              .addMethod(getCreateWhiteboardMethod())
              .build();
        }
      }
    }
    return result;
  }
}
