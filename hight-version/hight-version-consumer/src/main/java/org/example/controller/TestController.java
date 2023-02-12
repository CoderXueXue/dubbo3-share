package org.example.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.example.Demo1Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huchai
 * @date 2023/2/12
 */
@RestController
public class TestController {

    @Reference(check = false)
    Demo1Service demo1Service;

    @GetMapping("/test")
    public String test() {

        demo1Service.test();

        return demo1Service.test2();
    }
}
