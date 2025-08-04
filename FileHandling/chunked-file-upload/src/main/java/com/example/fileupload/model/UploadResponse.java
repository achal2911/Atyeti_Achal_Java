package com.example.fileupload.model;

import java.util.HashMap;
import java.util.Map;

public class UploadResponse {
    private String message;
    private boolean success;
    private Map<String, Object> data;

    public UploadResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
        this.data = new HashMap<>();
        ;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public static UploadResponse success(String message) {
        return new UploadResponse(message, true);
    }

    public static UploadResponse error(String message) {
        return new UploadResponse(message, false);
    }

    public UploadResponse addData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }
}
