// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: userservice.proto

package org.example.api;

public final class UserServiceProto {
  private UserServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_UserRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_UserRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_User_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_User_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021userservice.proto\022\003api\"\032\n\013UserRequest\022" +
      "\013\n\003uid\030\001 \001(\t\"%\n\004User\022\013\n\003uid\030\001 \001(\t\022\020\n\010use" +
      "rname\030\002 \001(\t27\n\013UserService\022(\n\007GetUser\022\020." +
      "api.UserRequest\032\t.api.User\"\000B-\n\017org.exam" +
      "ple.apiB\020UserServiceProtoP\001Z\006./;apib\006pro" +
      "to3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_api_UserRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_api_UserRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_UserRequest_descriptor,
        new java.lang.String[] { "Uid", });
    internal_static_api_User_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_api_User_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_User_descriptor,
        new java.lang.String[] { "Uid", "Username", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}