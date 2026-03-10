package com.smssender.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SMSService
{
//    public static final String ACCOUNT_SID="AC28cabee3238fe7b7f332082efd96af54";
//    public static final String AUTH_TOKEN="b21a707790352b3244d740431d841895";
//    public static final String FROM_NUMBER="+19297346035";

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromNumber;

    public void sendSMS(String toNumber,String textMessage){

        Twilio.init(accountSid,authToken);
        Message message=Message.creator(new PhoneNumber(toNumber),new PhoneNumber(fromNumber),
                textMessage).create();
        System.out.println("SMS sent successfully with SID!");
    }
}
