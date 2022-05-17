package com.example.dispatch_app_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ThreadPoolConfig {
    @Bean(value = "ThreadPool2")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        //线程池维护线程的最少数量
        threadPoolTaskExecutor.setCorePoolSize(20);
        //线程池维护线程的最大数量
        threadPoolTaskExecutor.setMaxPoolSize(40);
        //线程池队列容量
        threadPoolTaskExecutor.setQueueCapacity(20);
        //线程池拒绝策略
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //线程空闲时间
        threadPoolTaskExecutor.setKeepAliveSeconds(300);

        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}
