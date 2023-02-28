package org.example;

import org.apache.dubbo.common.stream.StreamObserver;

/**
 * @author huchai
 * @date 2023/2/14
 */
public interface Demo2StreamService {
    void sayHello(String name, StreamObserver<String> responseObserver);

    StreamObserver<String> sayHello2(StreamObserver<String> responseObserver);
}
