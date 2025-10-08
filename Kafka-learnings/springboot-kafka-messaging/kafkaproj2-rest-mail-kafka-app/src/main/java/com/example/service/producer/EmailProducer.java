package com.example.service.producer;

import com.example.dto.EmailRequest;
import com.example.exception.EmailSendException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmailProducer {

    @Autowired
    private KafkaTemplate<String, EmailRequest> kafkaTemplate;

    @Value("${app.topic.name}")
    private String topicName;

    public String sendEmail(EmailRequest emailRequest) {

            kafkaTemplate.send(topicName, emailRequest);
            return "Email request sent to Kafka!";

    }

}
