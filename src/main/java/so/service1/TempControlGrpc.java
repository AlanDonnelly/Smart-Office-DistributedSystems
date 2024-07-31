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
 * Temperature Control Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service1.proto")
public final class TempControlGrpc {

  private TempControlGrpc() {}

  public static final String SERVICE_NAME = "service1.TempControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<so.service1.TempRequest,
      so.service1.TempResponse> getSetTempMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetTemp",
      requestType = so.service1.TempRequest.class,
      responseType = so.service1.TempResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<so.service1.TempRequest,
      so.service1.TempResponse> getSetTempMethod() {
    io.grpc.MethodDescriptor<so.service1.TempRequest, so.service1.TempResponse> getSetTempMethod;
    if ((getSetTempMethod = TempControlGrpc.getSetTempMethod) == null) {
      synchronized (TempControlGrpc.class) {
        if ((getSetTempMethod = TempControlGrpc.getSetTempMethod) == null) {
          TempControlGrpc.getSetTempMethod = getSetTempMethod = 
              io.grpc.MethodDescriptor.<so.service1.TempRequest, so.service1.TempResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service1.TempControl", "SetTemp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service1.TempRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service1.TempResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TempControlMethodDescriptorSupplier("SetTemp"))
                  .build();
          }
        }
     }
     return getSetTempMethod;
  }

  private static volatile io.grpc.MethodDescriptor<so.service1.TempRequest,
      so.service1.TempResponse> getGetTempMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTemp",
      requestType = so.service1.TempRequest.class,
      responseType = so.service1.TempResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<so.service1.TempRequest,
      so.service1.TempResponse> getGetTempMethod() {
    io.grpc.MethodDescriptor<so.service1.TempRequest, so.service1.TempResponse> getGetTempMethod;
    if ((getGetTempMethod = TempControlGrpc.getGetTempMethod) == null) {
      synchronized (TempControlGrpc.class) {
        if ((getGetTempMethod = TempControlGrpc.getGetTempMethod) == null) {
          TempControlGrpc.getGetTempMethod = getGetTempMethod = 
              io.grpc.MethodDescriptor.<so.service1.TempRequest, so.service1.TempResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service1.TempControl", "GetTemp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service1.TempRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service1.TempResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TempControlMethodDescriptorSupplier("GetTemp"))
                  .build();
          }
        }
     }
     return getGetTempMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TempControlStub newStub(io.grpc.Channel channel) {
    return new TempControlStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TempControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TempControlBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TempControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TempControlFutureStub(channel);
  }

  /**
   * <pre>
   * Temperature Control Service
   * </pre>
   */
  public static abstract class TempControlImplBase implements io.grpc.BindableService {

    /**
     */
    public void setTemp(so.service1.TempRequest request,
        io.grpc.stub.StreamObserver<so.service1.TempResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetTempMethod(), responseObserver);
    }

    /**
     */
    public void getTemp(so.service1.TempRequest request,
        io.grpc.stub.StreamObserver<so.service1.TempResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTempMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetTempMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                so.service1.TempRequest,
                so.service1.TempResponse>(
                  this, METHODID_SET_TEMP)))
          .addMethod(
            getGetTempMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                so.service1.TempRequest,
                so.service1.TempResponse>(
                  this, METHODID_GET_TEMP)))
          .build();
    }
  }

  /**
   * <pre>
   * Temperature Control Service
   * </pre>
   */
  public static final class TempControlStub extends io.grpc.stub.AbstractStub<TempControlStub> {
    private TempControlStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TempControlStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TempControlStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TempControlStub(channel, callOptions);
    }

    /**
     */
    public void setTemp(so.service1.TempRequest request,
        io.grpc.stub.StreamObserver<so.service1.TempResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetTempMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTemp(so.service1.TempRequest request,
        io.grpc.stub.StreamObserver<so.service1.TempResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTempMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Temperature Control Service
   * </pre>
   */
  public static final class TempControlBlockingStub extends io.grpc.stub.AbstractStub<TempControlBlockingStub> {
    private TempControlBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TempControlBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TempControlBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TempControlBlockingStub(channel, callOptions);
    }

    /**
     */
    public so.service1.TempResponse setTemp(so.service1.TempRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetTempMethod(), getCallOptions(), request);
    }

    /**
     */
    public so.service1.TempResponse getTemp(so.service1.TempRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTempMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Temperature Control Service
   * </pre>
   */
  public static final class TempControlFutureStub extends io.grpc.stub.AbstractStub<TempControlFutureStub> {
    private TempControlFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TempControlFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TempControlFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TempControlFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<so.service1.TempResponse> setTemp(
        so.service1.TempRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetTempMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<so.service1.TempResponse> getTemp(
        so.service1.TempRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTempMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_TEMP = 0;
  private static final int METHODID_GET_TEMP = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TempControlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TempControlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_TEMP:
          serviceImpl.setTemp((so.service1.TempRequest) request,
              (io.grpc.stub.StreamObserver<so.service1.TempResponse>) responseObserver);
          break;
        case METHODID_GET_TEMP:
          serviceImpl.getTemp((so.service1.TempRequest) request,
              (io.grpc.stub.StreamObserver<so.service1.TempResponse>) responseObserver);
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

  private static abstract class TempControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TempControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return so.service1.Service1Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TempControl");
    }
  }

  private static final class TempControlFileDescriptorSupplier
      extends TempControlBaseDescriptorSupplier {
    TempControlFileDescriptorSupplier() {}
  }

  private static final class TempControlMethodDescriptorSupplier
      extends TempControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TempControlMethodDescriptorSupplier(String methodName) {
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
      synchronized (TempControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TempControlFileDescriptorSupplier())
              .addMethod(getSetTempMethod())
              .addMethod(getGetTempMethod())
              .build();
        }
      }
    }
    return result;
  }
}
