package com.example.aichatapp.models;

public class ChatModel {
    String time;
    String message;
    boolean sent;

    public ChatModel() {
    }

    public ChatModel(String time, String message, boolean sent) {
        this.time = time;
        this.message = message;
        this.sent = sent;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }
}
