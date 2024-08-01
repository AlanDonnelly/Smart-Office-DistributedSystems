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
 *Whiteboard Content Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service3.proto")
public final class WhiteboardContentGrpc {

  private WhiteboardContentGrpc() {}

  public static final String SERVICE_NAME = "service3.WhiteboardContent";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<so.service3.AddContentRequest,
      so.service3.AddContentResponse> getAddContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddContent",
      requestType = so.service3.AddContentRequest.class,
      responseType = so.service3.AddContentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<so.service3.AddContentRequest,
      so.service3.AddContentResponse> getAddContentMethod() {
    io.grpc.MethodDescriptor<so.service3.AddContentRequest, so.service3.AddContentResponse> getAddContentMethod;
    if ((getAddContentMethod = WhiteboardContentGrpc.getAddContentMethod) == null) {
      synchronized (WhiteboardContentGrpc.class) {
        if ((getAddContentMethod = WhiteboardContentGrpc.getAddContentMethod) == null) {
          WhiteboardContentGrpc.getAddContentMethod = getAddContentMethod = 
              io.grpc.MethodDescriptor.<so.service3.AddContentRequest, so.service3.AddContentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service3.WhiteboardContent", "AddContent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service3.AddContentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  so.service3.AddContentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new WhiteboardContentMethodDescriptorSupplier("AddContent"))
                  .build();
          }
        }
     }
     return getAddContentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WhiteboardContentStub newStub(io.grpc.Channel channel) {
    return new WhiteboardContentStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WhiteboardContentBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WhiteboardContentBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WhiteboardContentFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WhiteboardContentFutureStub(channel);
  }

  /**
   * <pre>
   *Whiteboard Content Service
   * </pre>
   */
  public static abstract class WhiteboardContentImplBase implements io.grpc.BindableService {

    /**
     */
    public void addContent(so.service3.AddContentRequest request,
        io.grpc.stub.StreamObserver<so.service3.AddContentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddContentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddContentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                so.service3.AddContentRequest,
                so.service3.AddContentResponse>(
                  this, METHODID_ADD_CONTENT)))
          .build();
    }
  }

  /**
   * <pre>
   *Whiteboard Content Service
   * </pre>
   */
  public static final class WhiteboardContentStub extends io.grpc.stub.AbstractStub<WhiteboardContentStub> {
    private WhiteboardContentStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WhiteboardContentStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WhiteboardContentStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WhiteboardContentStub(channel, callOptions);
    }

    /**
     */
    public void addContent(so.service3.AddContentRequest request,
        io.grpc.stub.StreamObserver<so.service3.AddContentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddContentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *Whiteboard Content Service
   * </pre>
   */
  public static final class WhiteboardContentBlockingStub extends io.grpc.stub.AbstractStub<WhiteboardContentBlockingStub> {
    private WhiteboardContentBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WhiteboardContentBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WhiteboardContentBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WhiteboardContentBlockingStub(channel, callOptions);
    }

    /**
     */
    public so.service3.AddContentResponse addContent(so.service3.AddContentRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddContentMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Whiteboard Content Service
   * </pre>
   */
  public static final class WhiteboardContentFutureStub extends io.grpc.stub.AbstractStub<WhiteboardContentFutureStub> {
    private WhiteboardContentFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WhiteboardContentFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WhiteboardContentFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WhiteboardContentFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<so.service3.AddContentResponse> addContent(
        so.service3.AddContentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddContentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_CONTENT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WhiteboardContentImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WhiteboardContentImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_CONTENT:
          serviceImpl.addContent((so.service3.AddContentRequest) request,
              (io.grpc.stub.StreamObserver<so.service3.AddContentResponse>) responseObserver);
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

  private static abstract class WhiteboardContentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WhiteboardContentBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return so.service3.Service3Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WhiteboardContent");
    }
  }

  private static final class WhiteboardContentFileDescriptorSupplier
      extends WhiteboardContentBaseDescriptorSupplier {
    WhiteboardContentFileDescriptorSupplier() {}
  }

  private static final class WhiteboardContentMethodDescriptorSupplier
      extends WhiteboardContentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WhiteboardContentMethodDescriptorSupplier(String methodName) {
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
      synchronized (WhiteboardContentGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WhiteboardContentFileDescriptorSupplier())
              .addMethod(getAddContentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
