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
 *Camera Control Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service2.proto")
public final class CameraControlGrpc {

  private CameraControlGrpc() {}

  public static final String SERVICE_NAME = "service2.CameraControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<so.service2.CameraRequest,
      so.service2.CameraFeed> getMonitorCameraMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorCamera",
      requestType = so.service2.CameraRequest.class,
      responseType = so.service2.CameraFeed.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<so.service2.CameraRequest,
      so.service2.CameraFeed> getMonitorCameraMethod() {
    io.grpc.MethodDescriptor<so.service2.CameraRequest, so.service2.CameraFeed> getMonitorCameraMethod;
    if ((getMonitorCameraMethod = CameraControlGrpc.getMonitorCameraMethod) == null) {
      synchronized (CameraControlGrpc.class) {
        if ((getMonitorCameraMethod = CameraControlGrpc.getMonitorCameraMethod) == null) {
          CameraControlGrpc.getMonitorCameraMethod = getMonitorCameraMethod = 
              io.grpc.MethodDescriptor.<so.service2.CameraRequest, so.service2.CameraFeed>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service2.CameraControl", "MonitorCamera"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service2.CameraRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service2.CameraFeed.getDefaultInstance()))
                  .setSchemaDescriptor(new CameraControlMethodDescriptorSupplier("MonitorCamera"))
                  .build();
          }
        }
     }
     return getMonitorCameraMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CameraControlStub newStub(io.grpc.Channel channel) {
    return new CameraControlStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CameraControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CameraControlBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CameraControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CameraControlFutureStub(channel);
  }

  /**
   * <pre>
   *Camera Control Service
   * </pre>
   */
  public static abstract class CameraControlImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Live video feed from security camera
     * </pre>
     */
    public void monitorCamera(so.service2.CameraRequest request,
        io.grpc.stub.StreamObserver<so.service2.CameraFeed> responseObserver) {
      asyncUnimplementedUnaryCall(getMonitorCameraMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMonitorCameraMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                so.service2.CameraRequest,
                so.service2.CameraFeed>(
                  this, METHODID_MONITOR_CAMERA)))
          .build();
    }
  }

  /**
   * <pre>
   *Camera Control Service
   * </pre>
   */
  public static final class CameraControlStub extends io.grpc.stub.AbstractStub<CameraControlStub> {
    private CameraControlStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CameraControlStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CameraControlStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CameraControlStub(channel, callOptions);
    }

    /**
     * <pre>
     *Live video feed from security camera
     * </pre>
     */
    public void monitorCamera(so.service2.CameraRequest request,
        io.grpc.stub.StreamObserver<so.service2.CameraFeed> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getMonitorCameraMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *Camera Control Service
   * </pre>
   */
  public static final class CameraControlBlockingStub extends io.grpc.stub.AbstractStub<CameraControlBlockingStub> {
    private CameraControlBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CameraControlBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CameraControlBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CameraControlBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Live video feed from security camera
     * </pre>
     */
    public java.util.Iterator<so.service2.CameraFeed> monitorCamera(
        so.service2.CameraRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getMonitorCameraMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Camera Control Service
   * </pre>
   */
  public static final class CameraControlFutureStub extends io.grpc.stub.AbstractStub<CameraControlFutureStub> {
    private CameraControlFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CameraControlFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CameraControlFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CameraControlFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_MONITOR_CAMERA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CameraControlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CameraControlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MONITOR_CAMERA:
          serviceImpl.monitorCamera((so.service2.CameraRequest) request,
              (io.grpc.stub.StreamObserver<so.service2.CameraFeed>) responseObserver);
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

  private static abstract class CameraControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CameraControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return so.service2.Service2Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CameraControl");
    }
  }

  private static final class CameraControlFileDescriptorSupplier
      extends CameraControlBaseDescriptorSupplier {
    CameraControlFileDescriptorSupplier() {}
  }

  private static final class CameraControlMethodDescriptorSupplier
      extends CameraControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CameraControlMethodDescriptorSupplier(String methodName) {
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
      synchronized (CameraControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CameraControlFileDescriptorSupplier())
              .addMethod(getMonitorCameraMethod())
              .build();
        }
      }
    }
    return result;
  }
}
