package com.smssender.producer;

import com.smssender.dto.SMSRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SMSProducer {

    @Autowired
private KafkaTemplate<String, SMSRequest>template;

    @Value("${app.topic.name}")
    private String topic;

    public String sendSMSRequest(SMSRequest request){
        template.send(topic,request);
        return"SMS sent successfully!!";
    }
}
