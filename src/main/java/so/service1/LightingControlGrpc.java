package so.service1;

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
 * Lighting Control Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service1.proto")
public final class LightingControlGrpc {

  private LightingControlGrpc() {}

  public static final String SERVICE_NAME = "service1.LightingControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<so.service1.LightingRequest,
      so.service1.LightingResponse> getSetLightingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetLighting",
      requestType = so.service1.LightingRequest.class,
      responseType = so.service1.LightingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<so.service1.LightingRequest,
      so.service1.LightingResponse> getSetLightingMethod() {
    io.grpc.MethodDescriptor<so.service1.LightingRequest, so.service1.LightingResponse> getSetLightingMethod;
    if ((getSetLightingMethod = LightingControlGrpc.getSetLightingMethod) == null) {
      synchronized (LightingControlGrpc.class) {
        if ((getSetLightingMethod = LightingControlGrpc.getSetLightingMethod) == null) {
          LightingControlGrpc.getSetLightingMethod = getSetLightingMethod = 
              io.grpc.MethodDescriptor.<so.service1.LightingRequest, so.service1.LightingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service1.LightingControl", "SetLighting"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service1.LightingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service1.LightingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightingControlMethodDescriptorSupplier("SetLighting"))
                  .build();
          }
        }
     }
     return getSetLightingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightingControlStub newStub(io.grpc.Channel channel) {
    return new LightingControlStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightingControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LightingControlBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightingControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LightingControlFutureStub(channel);
  }

  /**
   * <pre>
   * Lighting Control Service
   * </pre>
   */
  public static abstract class LightingControlImplBase implements io.grpc.BindableService {

    /**
     */
    public void setLighting(so.service1.LightingRequest request,
        io.grpc.stub.StreamObserver<so.service1.LightingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetLightingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetLightingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                so.service1.LightingRequest,
                so.service1.LightingResponse>(
                  this, METHODID_SET_LIGHTING)))
          .build();
    }
  }

  /**
   * <pre>
   * Lighting Control Service
   * </pre>
   */
  public static final class LightingControlStub extends io.grpc.stub.AbstractStub<LightingControlStub> {
    private LightingControlStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightingControlStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightingControlStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightingControlStub(channel, callOptions);
    }

    /**
     */
    public void setLighting(so.service1.LightingRequest request,
        io.grpc.stub.StreamObserver<so.service1.LightingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetLightingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Lighting Control Service
   * </pre>
   */
  public static final class LightingControlBlockingStub extends io.grpc.stub.AbstractStub<LightingControlBlockingStub> {
    private LightingControlBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightingControlBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightingControlBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightingControlBlockingStub(channel, callOptions);
    }

    /**
     */
    public so.service1.LightingResponse setLighting(so.service1.LightingRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetLightingMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Lighting Control Service
   * </pre>
   */
  public static final class LightingControlFutureStub extends io.grpc.stub.AbstractStub<LightingControlFutureStub> {
    private LightingControlFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightingControlFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightingControlFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightingControlFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<so.service1.LightingResponse> setLighting(
        so.service1.LightingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetLightingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_LIGHTING = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LightingControlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LightingControlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_LIGHTING:
          serviceImpl.setLighting((so.service1.LightingRequest) request,
              (io.grpc.stub.StreamObserver<so.service1.LightingResponse>) responseObserver);
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

  private static abstract class LightingControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightingControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return so.service1.Service1Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LightingControl");
    }
  }

  private static final class LightingControlFileDescriptorSupplier
      extends LightingControlBaseDescriptorSupplier {
    LightingControlFileDescriptorSupplier() {}
  }

  private static final class LightingControlMethodDescriptorSupplier
      extends LightingControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LightingControlMethodDescriptorSupplier(String methodName) {
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
      synchronized (LightingControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightingControlFileDescriptorSupplier())
              .addMethod(getSetLightingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
