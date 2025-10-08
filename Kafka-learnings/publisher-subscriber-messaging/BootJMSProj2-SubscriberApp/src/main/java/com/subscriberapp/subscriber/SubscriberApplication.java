package com.subscriberapp.subscriber;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class SubscriberApplication {

    @JmsListener(destination = "tpc1")
    public  void readMessage(String msg){
        System.out.println("Receiver::message::"+msg);
    }

}
