package com.smssender.dto;

public class SMSRequest {
    private  String phoneNo;
    private String message;

    public SMSRequest(){}

    public SMSRequest(String phoneNo, String message) {
        this.phoneNo = phoneNo;
        this.message = message;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
