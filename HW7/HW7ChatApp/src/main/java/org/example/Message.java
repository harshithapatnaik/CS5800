package org.example;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class Message{

    private User sender;
    private ArrayList<User> recipients;
    private LocalDateTime timestamp;
    private String messageContent;

    public Message(User sender, ArrayList<User> recipients, String messageContent){
        this.sender = sender;
        this.recipients = recipients;
        this.timestamp = LocalDateTime.now();
        this.messageContent = messageContent;
    }

    public User getSender(){
        return sender;
    }

    public void setSender(User sender){
        this.sender = sender;
    }

    public ArrayList<User> getRecipients(){
        return recipients;
    }

    public void setRecipients(ArrayList<User> recipients){
        this.recipients = recipients;
    }

    public LocalDateTime getTimestamp(){
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp){
        this.timestamp = timestamp;
    }

    public String getMessageContent(){
        return messageContent;
    }

    public void setMessageContent(String messageContent){
        this.messageContent = messageContent;
    }

    public String toString(){
        StringBuilder recipientNames = new StringBuilder();
        for(User recipient: recipients){
            if (recipientNames.toString().isEmpty()){
                recipientNames.append(recipient.getUserName());
            }
            else {
                recipientNames.append(", ").append(recipient.getUserName());
            }
        }
        return "(" + this.timestamp + ") "
                + "Message from " + sender.getUserName()
                + " to " + recipientNames
                + ": " + this.messageContent;
    }

}