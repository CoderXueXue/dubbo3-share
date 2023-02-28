    package org.example.api;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

public final class UserServiceDubbo {
private static final AtomicBoolean registered = new AtomicBoolean();

public static boolean init() {
    if (registered.compareAndSet(false, true)) {
            org.apache.dubbo.rpc.protocol.tri.SingleProtobufUtils.marshaller(
            org.example.api.UserRequest.getDefaultInstance());
            org.apache.dubbo.rpc.protocol.tri.SingleProtobufUtils.marshaller(
            org.example.api.User.getDefaultInstance());
    }
    return true;
}

private UserServiceDubbo() {}

}
