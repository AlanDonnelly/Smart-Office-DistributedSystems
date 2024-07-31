package so.service2;

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
 *Door Control Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service2.proto")
public final class DoorControlGrpc {

  private DoorControlGrpc() {}

  public static final String SERVICE_NAME = "service2.DoorControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<so.service2.DoorRequest,
      so.service2.DoorResponse> getControlDoorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ControlDoor",
      requestType = so.service2.DoorRequest.class,
      responseType = so.service2.DoorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<so.service2.DoorRequest,
      so.service2.DoorResponse> getControlDoorMethod() {
    io.grpc.MethodDescriptor<so.service2.DoorRequest, so.service2.DoorResponse> getControlDoorMethod;
    if ((getControlDoorMethod = DoorControlGrpc.getControlDoorMethod) == null) {
      synchronized (DoorControlGrpc.class) {
        if ((getControlDoorMethod = DoorControlGrpc.getControlDoorMethod) == null) {
          DoorControlGrpc.getControlDoorMethod = getControlDoorMethod = 
              io.grpc.MethodDescriptor.<so.service2.DoorRequest, so.service2.DoorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service2.DoorControl", "ControlDoor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service2.DoorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service2.DoorResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DoorControlMethodDescriptorSupplier("ControlDoor"))
                  .build();
          }
        }
     }
     return getControlDoorMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DoorControlStub newStub(io.grpc.Channel channel) {
    return new DoorControlStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DoorControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DoorControlBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DoorControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DoorControlFutureStub(channel);
  }

  /**
   * <pre>
   *Door Control Service
   * </pre>
   */
  public static abstract class DoorControlImplBase implements io.grpc.BindableService {

    /**
     */
    public void controlDoor(so.service2.DoorRequest request,
        io.grpc.stub.StreamObserver<so.service2.DoorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getControlDoorMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getControlDoorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                so.service2.DoorRequest,
                so.service2.DoorResponse>(
                  this, METHODID_CONTROL_DOOR)))
          .build();
    }
  }

  /**
   * <pre>
   *Door Control Service
   * </pre>
   */
  public static final class DoorControlStub extends io.grpc.stub.AbstractStub<DoorControlStub> {
    private DoorControlStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DoorControlStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DoorControlStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DoorControlStub(channel, callOptions);
    }

    /**
     */
    public void controlDoor(so.service2.DoorRequest request,
        io.grpc.stub.StreamObserver<so.service2.DoorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getControlDoorMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *Door Control Service
   * </pre>
   */
  public static final class DoorControlBlockingStub extends io.grpc.stub.AbstractStub<DoorControlBlockingStub> {
    private DoorControlBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DoorControlBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DoorControlBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DoorControlBlockingStub(channel, callOptions);
    }

    /**
     */
    public so.service2.DoorResponse controlDoor(so.service2.DoorRequest request) {
      return blockingUnaryCall(
          getChannel(), getControlDoorMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Door Control Service
   * </pre>
   */
  public static final class DoorControlFutureStub extends io.grpc.stub.AbstractStub<DoorControlFutureStub> {
    private DoorControlFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DoorControlFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DoorControlFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DoorControlFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<so.service2.DoorResponse> controlDoor(
        so.service2.DoorRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getControlDoorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONTROL_DOOR = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DoorControlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DoorControlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONTROL_DOOR:
          serviceImpl.controlDoor((so.service2.DoorRequest) request,
              (io.grpc.stub.StreamObserver<so.service2.DoorResponse>) responseObserver);
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

  private static abstract class DoorControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DoorControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return so.service2.Service2Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DoorControl");
    }
  }

  private static final class DoorControlFileDescriptorSupplier
      extends DoorControlBaseDescriptorSupplier {
    DoorControlFileDescriptorSupplier() {}
  }

  private static final class DoorControlMethodDescriptorSupplier
      extends DoorControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DoorControlMethodDescriptorSupplier(String methodName) {
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
      synchronized (DoorControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DoorControlFileDescriptorSupplier())
              .addMethod(getControlDoorMethod())
              .build();
        }
      }
    }
    return result;
  }
}
