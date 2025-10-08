package com.example.controller;

import com.example.dto.EmailRequest;
import com.example.service.producer.EmailProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController
{
    @Autowired
    private EmailProducer producer;

    @PostMapping("/send")
    public  String  sendEmail(@RequestBody EmailRequest request){
        return producer.sendEmail(request);
    }

}
