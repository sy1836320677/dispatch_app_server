package com.example.dispatch_app_server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {
    @Bean(value = "ThreadPool1")
    @Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public ThreadPoolTaskExecutor sendThreadPool(
            @Value("${sendThreadPool.corePoolSize}") int corePoolSize,
            @Value("${sendThreadPool.maxPoolSize}") int maxPoolSize,
            @Value("${sendThreadPool.queueCapacity}") int queueCapacity,
            @Value("${sendThreadPool.keepAliveSeconds}") int keepAliveSeconds) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        executor.initialize();
        return executor;
    }

}
