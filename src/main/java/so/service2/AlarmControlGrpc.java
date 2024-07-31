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
 *Alarm Control Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service2.proto")
public final class AlarmControlGrpc {

  private AlarmControlGrpc() {}

  public static final String SERVICE_NAME = "service2.AlarmControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<so.service2.AlarmRequest,
      so.service2.AlarmResponse> getControlAlarmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ControlAlarm",
      requestType = so.service2.AlarmRequest.class,
      responseType = so.service2.AlarmResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<so.service2.AlarmRequest,
      so.service2.AlarmResponse> getControlAlarmMethod() {
    io.grpc.MethodDescriptor<so.service2.AlarmRequest, so.service2.AlarmResponse> getControlAlarmMethod;
    if ((getControlAlarmMethod = AlarmControlGrpc.getControlAlarmMethod) == null) {
      synchronized (AlarmControlGrpc.class) {
        if ((getControlAlarmMethod = AlarmControlGrpc.getControlAlarmMethod) == null) {
          AlarmControlGrpc.getControlAlarmMethod = getControlAlarmMethod = 
              io.grpc.MethodDescriptor.<so.service2.AlarmRequest, so.service2.AlarmResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service2.AlarmControl", "ControlAlarm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service2.AlarmRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service2.AlarmResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AlarmControlMethodDescriptorSupplier("ControlAlarm"))
                  .build();
          }
        }
     }
     return getControlAlarmMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AlarmControlStub newStub(io.grpc.Channel channel) {
    return new AlarmControlStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AlarmControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AlarmControlBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AlarmControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AlarmControlFutureStub(channel);
  }

  /**
   * <pre>
   *Alarm Control Service
   * </pre>
   */
  public static abstract class AlarmControlImplBase implements io.grpc.BindableService {

    /**
     */
    public void controlAlarm(so.service2.AlarmRequest request,
        io.grpc.stub.StreamObserver<so.service2.AlarmResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getControlAlarmMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getControlAlarmMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                so.service2.AlarmRequest,
                so.service2.AlarmResponse>(
                  this, METHODID_CONTROL_ALARM)))
          .build();
    }
  }

  /**
   * <pre>
   *Alarm Control Service
   * </pre>
   */
  public static final class AlarmControlStub extends io.grpc.stub.AbstractStub<AlarmControlStub> {
    private AlarmControlStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AlarmControlStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlarmControlStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AlarmControlStub(channel, callOptions);
    }

    /**
     */
    public void controlAlarm(so.service2.AlarmRequest request,
        io.grpc.stub.StreamObserver<so.service2.AlarmResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getControlAlarmMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *Alarm Control Service
   * </pre>
   */
  public static final class AlarmControlBlockingStub extends io.grpc.stub.AbstractStub<AlarmControlBlockingStub> {
    private AlarmControlBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AlarmControlBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlarmControlBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AlarmControlBlockingStub(channel, callOptions);
    }

    /**
     */
    public so.service2.AlarmResponse controlAlarm(so.service2.AlarmRequest request) {
      return blockingUnaryCall(
          getChannel(), getControlAlarmMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Alarm Control Service
   * </pre>
   */
  public static final class AlarmControlFutureStub extends io.grpc.stub.AbstractStub<AlarmControlFutureStub> {
    private AlarmControlFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AlarmControlFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlarmControlFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AlarmControlFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<so.service2.AlarmResponse> controlAlarm(
        so.service2.AlarmRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getControlAlarmMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONTROL_ALARM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AlarmControlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AlarmControlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONTROL_ALARM:
          serviceImpl.controlAlarm((so.service2.AlarmRequest) request,
              (io.grpc.stub.StreamObserver<so.service2.AlarmResponse>) responseObserver);
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

  private static abstract class AlarmControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AlarmControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return so.service2.Service2Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AlarmControl");
    }
  }

  private static final class AlarmControlFileDescriptorSupplier
      extends AlarmControlBaseDescriptorSupplier {
    AlarmControlFileDescriptorSupplier() {}
  }

  private static final class AlarmControlMethodDescriptorSupplier
      extends AlarmControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AlarmControlMethodDescriptorSupplier(String methodName) {
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
      synchronized (AlarmControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AlarmControlFileDescriptorSupplier())
              .addMethod(getControlAlarmMethod())
              .build();
        }
      }
    }
    return result;
  }
}
