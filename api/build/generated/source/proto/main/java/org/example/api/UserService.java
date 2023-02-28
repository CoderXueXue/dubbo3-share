package org.example.api;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

public interface UserService {

    static final String JAVA_SERVICE_NAME = "org.example.api.UserService";
    static final String SERVICE_NAME = "api.UserService";

    // FIXME, initialize Dubbo3 stub when interface loaded, thinking of new ways doing this.
    static final boolean inited = UserServiceDubbo.init();

    org.example.api.User getUser(org.example.api.UserRequest request);

    default CompletableFuture<org.example.api.User> getUserAsync(org.example.api.UserRequest request){
        return CompletableFuture.supplyAsync(() -> getUser(request));
    }




}
