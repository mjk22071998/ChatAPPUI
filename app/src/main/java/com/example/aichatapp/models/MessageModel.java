package com.example.aichatapp.models;

public class MessageModel {
    private String Name;
    private String lastMessage;
    private String time;

    public MessageModel() {
    }

    public MessageModel(String name, String lastMessage, String time) {
        Name = name;
        this.lastMessage = lastMessage;
        this.time = time;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
