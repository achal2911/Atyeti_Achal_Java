package com.smssender.controller;

import com.smssender.dto.SMSRequest;
import com.smssender.producer.SMSProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SMSController {
    @Autowired
    private SMSProducer smsProducer;

    @PostMapping("/sendingsms")
    public ResponseEntity<String> sendSMS(@RequestBody SMSRequest request) {
        return new ResponseEntity<>(smsProducer.sendSMSRequest(request), HttpStatus.OK);


    }
}
