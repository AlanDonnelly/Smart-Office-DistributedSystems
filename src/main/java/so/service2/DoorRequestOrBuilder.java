// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service2.proto

package so.service2;

public interface DoorRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:service2.DoorRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *"lockDoor" or "unlockDoor"
   * </pre>
   *
   * <code>string operationType = 1;</code>
   */
  java.lang.String getOperationType();
  /**
   * <pre>
   *"lockDoor" or "unlockDoor"
   * </pre>
   *
   * <code>string operationType = 1;</code>
   */
  com.google.protobuf.ByteString
      getOperationTypeBytes();

  /**
   * <pre>
   *Door number to lock or unlock
   * </pre>
   *
   * <code>int32 doorNumber = 2;</code>
   */
  int getDoorNumber();
}
