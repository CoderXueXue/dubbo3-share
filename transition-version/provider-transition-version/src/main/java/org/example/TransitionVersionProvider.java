package org.example;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ${USER}
 * @date ${DATE}
 */
@EnableDubbo
@SpringBootApplication
public class TransitionVersionProvider {
    public static void main(String[] args) {
        SpringApplication.run(TransitionVersionProvider.class, args);
    }
}