package com.kafkamessaging.store;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageStore
{
    private List<String> messagesList =new ArrayList<>();

    public  void addMessage(String msg){
      messagesList.add(msg);
    }

    public  List<String >showAllMessages(){
        return messagesList;
    }

}
