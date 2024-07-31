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
 * Air Quality Control Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service1.proto")
public final class AirQualityControlGrpc {

  private AirQualityControlGrpc() {}

  public static final String SERVICE_NAME = "service1.AirQualityControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<so.service1.AirQualRequest,
      so.service1.AirQualResponse> getSetAirQualMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetAirQual",
      requestType = so.service1.AirQualRequest.class,
      responseType = so.service1.AirQualResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<so.service1.AirQualRequest,
      so.service1.AirQualResponse> getSetAirQualMethod() {
    io.grpc.MethodDescriptor<so.service1.AirQualRequest, so.service1.AirQualResponse> getSetAirQualMethod;
    if ((getSetAirQualMethod = AirQualityControlGrpc.getSetAirQualMethod) == null) {
      synchronized (AirQualityControlGrpc.class) {
        if ((getSetAirQualMethod = AirQualityControlGrpc.getSetAirQualMethod) == null) {
          AirQualityControlGrpc.getSetAirQualMethod = getSetAirQualMethod = 
              io.grpc.MethodDescriptor.<so.service1.AirQualRequest, so.service1.AirQualResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service1.AirQualityControl", "SetAirQual"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service1.AirQualRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service1.AirQualResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AirQualityControlMethodDescriptorSupplier("SetAirQual"))
                  .build();
          }
        }
     }
     return getSetAirQualMethod;
  }

  private static volatile io.grpc.MethodDescriptor<so.service1.AirQualRequest,
      so.service1.AirQualResponse> getGetAirQualMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAirQual",
      requestType = so.service1.AirQualRequest.class,
      responseType = so.service1.AirQualResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<so.service1.AirQualRequest,
      so.service1.AirQualResponse> getGetAirQualMethod() {
    io.grpc.MethodDescriptor<so.service1.AirQualRequest, so.service1.AirQualResponse> getGetAirQualMethod;
    if ((getGetAirQualMethod = AirQualityControlGrpc.getGetAirQualMethod) == null) {
      synchronized (AirQualityControlGrpc.class) {
        if ((getGetAirQualMethod = AirQualityControlGrpc.getGetAirQualMethod) == null) {
          AirQualityControlGrpc.getGetAirQualMethod = getGetAirQualMethod = 
              io.grpc.MethodDescriptor.<so.service1.AirQualRequest, so.service1.AirQualResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service1.AirQualityControl", "GetAirQual"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service1.AirQualRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service1.AirQualResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AirQualityControlMethodDescriptorSupplier("GetAirQual"))
                  .build();
          }
        }
     }
     return getGetAirQualMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AirQualityControlStub newStub(io.grpc.Channel channel) {
    return new AirQualityControlStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AirQualityControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AirQualityControlBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AirQualityControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AirQualityControlFutureStub(channel);
  }

  /**
   * <pre>
   * Air Quality Control Service
   * </pre>
   */
  public static abstract class AirQualityControlImplBase implements io.grpc.BindableService {

    /**
     */
    public void setAirQual(so.service1.AirQualRequest request,
        io.grpc.stub.StreamObserver<so.service1.AirQualResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetAirQualMethod(), responseObserver);
    }

    /**
     */
    public void getAirQual(so.service1.AirQualRequest request,
        io.grpc.stub.StreamObserver<so.service1.AirQualResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAirQualMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetAirQualMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                so.service1.AirQualRequest,
                so.service1.AirQualResponse>(
                  this, METHODID_SET_AIR_QUAL)))
          .addMethod(
            getGetAirQualMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                so.service1.AirQualRequest,
                so.service1.AirQualResponse>(
                  this, METHODID_GET_AIR_QUAL)))
          .build();
    }
  }

  /**
   * <pre>
   * Air Quality Control Service
   * </pre>
   */
  public static final class AirQualityControlStub extends io.grpc.stub.AbstractStub<AirQualityControlStub> {
    private AirQualityControlStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AirQualityControlStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirQualityControlStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AirQualityControlStub(channel, callOptions);
    }

    /**
     */
    public void setAirQual(so.service1.AirQualRequest request,
        io.grpc.stub.StreamObserver<so.service1.AirQualResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetAirQualMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAirQual(so.service1.AirQualRequest request,
        io.grpc.stub.StreamObserver<so.service1.AirQualResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAirQualMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Air Quality Control Service
   * </pre>
   */
  public static final class AirQualityControlBlockingStub extends io.grpc.stub.AbstractStub<AirQualityControlBlockingStub> {
    private AirQualityControlBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AirQualityControlBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirQualityControlBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AirQualityControlBlockingStub(channel, callOptions);
    }

    /**
     */
    public so.service1.AirQualResponse setAirQual(so.service1.AirQualRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetAirQualMethod(), getCallOptions(), request);
    }

    /**
     */
    public so.service1.AirQualResponse getAirQual(so.service1.AirQualRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAirQualMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Air Quality Control Service
   * </pre>
   */
  public static final class AirQualityControlFutureStub extends io.grpc.stub.AbstractStub<AirQualityControlFutureStub> {
    private AirQualityControlFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AirQualityControlFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirQualityControlFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AirQualityControlFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<so.service1.AirQualResponse> setAirQual(
        so.service1.AirQualRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetAirQualMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<so.service1.AirQualResponse> getAirQual(
        so.service1.AirQualRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAirQualMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_AIR_QUAL = 0;
  private static final int METHODID_GET_AIR_QUAL = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AirQualityControlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AirQualityControlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_AIR_QUAL:
          serviceImpl.setAirQual((so.service1.AirQualRequest) request,
              (io.grpc.stub.StreamObserver<so.service1.AirQualResponse>) responseObserver);
          break;
        case METHODID_GET_AIR_QUAL:
          serviceImpl.getAirQual((so.service1.AirQualRequest) request,
              (io.grpc.stub.StreamObserver<so.service1.AirQualResponse>) responseObserver);
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

  private static abstract class AirQualityControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AirQualityControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return so.service1.Service1Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AirQualityControl");
    }
  }

  private static final class AirQualityControlFileDescriptorSupplier
      extends AirQualityControlBaseDescriptorSupplier {
    AirQualityControlFileDescriptorSupplier() {}
  }

  private static final class AirQualityControlMethodDescriptorSupplier
      extends AirQualityControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AirQualityControlMethodDescriptorSupplier(String methodName) {
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
      synchronized (AirQualityControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AirQualityControlFileDescriptorSupplier())
              .addMethod(getSetAirQualMethod())
              .addMethod(getGetAirQualMethod())
              .build();
        }
      }
    }
    return result;
  }
}
