package com.jmsreceiver.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class PTPReceiverApp {


    @JmsListener(destination = "testmq1")
    public  void readMessage(String msg){
        System.out.println("Receiver::message::"+msg);
    }
}
