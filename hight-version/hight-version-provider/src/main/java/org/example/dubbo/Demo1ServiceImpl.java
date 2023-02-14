package org.example.dubbo;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.Demo1Service;
import org.springframework.stereotype.Component;

/**
 * @author huchai
 * @date 2023/2/12
 */
//@Service
@DubboService
@Component
public class Demo1ServiceImpl implements Demo1Service {
    @Override
    public void test() {
        System.out.println("test");
    }

    @Override
    public String test2() {
        return "hight-version-test2";
    }
}
