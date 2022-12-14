package org.example;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@DubboComponentScan
@SpringBootApplication
public class DubboService2Application {

    public static void main(String[] args) {
        SpringApplication.run(DubboService2Application.class, args);
    }

}
