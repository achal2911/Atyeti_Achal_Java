package com.scheduling.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PTPSenderAppWithScheduling {
    @Autowired
    private JmsTemplate template;

    @Scheduled(cron = "*/10 * * * * *")
    public void sendMessage(){
        template.send("testmq1",session -> session.createTextMessage("from the sender::"+new Date()));
        System.out.println("message sent");
    }
}
