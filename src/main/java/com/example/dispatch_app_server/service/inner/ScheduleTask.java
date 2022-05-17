package com.example.dispatch_app_server.service.inner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScheduleTask {
    @Scheduled(cron = "0 0/30 * * * ?")   //每半小时秒执行一次
    public void scheduleSend(){

    }
}
