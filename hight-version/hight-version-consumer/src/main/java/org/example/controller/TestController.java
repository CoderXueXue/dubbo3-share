package org.example.controller;

import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboReference;
import org.example.Demo1Service;
import org.example.Demo2StreamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huchai
 * @date 2023/2/12
 */
@RestController
public class TestController {

    @DubboReference(check = false)
    private Demo1Service demo1Service;

    @DubboReference(check = false)
    private Demo2StreamService demo2StreamService;

    @GetMapping
    public String test() {

        demo1Service.test();

        return demo1Service.test2();
    }


    @GetMapping("/stream")
    public String stream() {
        demo2StreamService.sayHello("huchai", new StreamObserver<String>() {
            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        });
        return "stream";
    }

    @GetMapping("/stream2")
    public String stream2() {
        StreamObserver<String> onCompleted = demo2StreamService.sayHello2(new StreamObserver<String>() {
            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        });

        onCompleted.onNext("huchai");
        onCompleted.onNext("huchai");
        onCompleted.onCompleted();
        System.out.println("onCompleted");

        return "stream";
    }
}
