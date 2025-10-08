package com.smssender.consumer;

import com.smssender.dto.SMSRequest;
import com.smssender.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SMSConsumer
{
    @Autowired
    private SMSService service;

    @KafkaListener(topics="${app.topic.name}",groupId ="smsGroup")
    public void consume(SMSRequest smsRequest){
        service.sendSMS(smsRequest.getPhoneNo(),smsRequest.getMessage());
        System.out.println("sms  sent to "+smsRequest.getPhoneNo());
    }
}
