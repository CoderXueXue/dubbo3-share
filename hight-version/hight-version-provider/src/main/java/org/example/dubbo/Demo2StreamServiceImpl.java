package org.example.dubbo;

import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboService;
import org.example.Demo2StreamService;

/**
 * @author huchai
 * @date 2023/2/14
 */
@DubboService
public class Demo2StreamServiceImpl implements Demo2StreamService {
    @Override
    public void sayHello(String name, StreamObserver<String> responseObserver) {
        responseObserver.onNext("Hello " + name);

        responseObserver.onNext("Hello " + name);

        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<String> sayHello2(StreamObserver<String> responseObserver) {
        return new StreamObserver<String>() {
            @Override
            public void onNext(String s) {
                responseObserver.onNext("Hello " + s);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
