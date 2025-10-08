package com.example.service.consumer;

import com.example.dto.EmailRequest;
import com.example.exception.EmailSendException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {
    @Autowired
    private JavaMailSender mailSender;

    @KafkaListener(topics = "${app.topic.name}", groupId = "email-group")
    public void consume(EmailRequest request) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(request.getTo());
            mailMessage.setSubject(request.getSubject());
            mailMessage.setText(request.getBody());

            mailSender.send(mailMessage);
            System.out.println("Email sent to: " + request.getTo());
        } catch (Exception e) {
            throw new EmailSendException("Failed to send email to " + request.getTo());
        }

    }
}
