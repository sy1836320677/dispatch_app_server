package com.example.dispatch_app_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync(proxyTargetClass = true)
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DispatchAppServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DispatchAppServerApplication.class, args);
    }

}
