package com.kafkamessaging.controller;

import com.kafkamessaging.producer.MessageProducer;
import com.kafkamessaging.store.MessageStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaMessagingOperationsController {

    @Autowired
    private MessageProducer producer;

    @Autowired
    private MessageStore store;

    @GetMapping("/send")
    public ResponseEntity<String> send(@RequestParam("message") String message) {
        //send the msg through producer
        String result = producer.sendMessage(message);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/show")
    public ResponseEntity<List<String>> showAllMessages() {
        //read all the message from list
        List<String> msgList = store.showAllMessages();
        return new ResponseEntity<List<String>>(msgList, HttpStatus.OK);
    }

}
