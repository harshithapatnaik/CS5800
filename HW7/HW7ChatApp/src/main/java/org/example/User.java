package org.example;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class User implements IterableByUser{

    private ChatServer mediator;
    private String userName;
    private ChatHistory chatHistory;
    private MessageMemento memento;
    private String lastMessageSent;

    public User(ChatServer mediator, String userName){
        this.mediator = mediator;
        this.userName = userName;
        this.chatHistory = new ChatHistory();
        this.memento = new MessageMemento(null, null);
        this.lastMessageSent = "";
    }

    public String getUserName(){
        return this.userName;
    }

    public ChatHistory getChatHistory(){
        return this.chatHistory;
    }

    public String getLastMessageSent(){
        return this.lastMessageSent;
    }

    public void setLastMessageSent(String message){
        this.lastMessageSent = message;
    }

    public void send(ArrayList<User> recipients, String content){
        // Sent messages are automatically saved to the chat history
        Message message = new Message(this, recipients, content);
        this.saveLastMessageSent(message);
        if(this.mediator.sendMessage(message)){
            this.chatHistory.addMessageToHistory(message);
            this.lastMessageSent = "(" + message.getTimestamp()
                    + ") " + "       " + message.getMessageContent();
        }
    }

    public void receiveMessage(Message message){
        // Received messages are automatically saved to the chat history
        System.out.println(
                "(" + message.getTimestamp() + ") "
                        + this.userName + " received a message from "
                        + message.getSender().getUserName() + ": "
                        + message.getMessageContent()
        );
        this.chatHistory.addMessageToHistory(message);
    }

    public void saveLastMessageSent(Message message){
        this.memento.setState(Timestamp.valueOf(message.getTimestamp()), message.getMessageContent());
    }

    public void undoLastMessageSent(){
        this.lastMessageSent = this.memento.getState();
        this.chatHistory.removeLastSentMessageFromHistory(this);
    }

    public void blockUser(User blockedUser){
        System.out.println(this.userName + " blocked " + blockedUser.getUserName() + ".");
    }

    public Iterator iterator(User userToSearchWith){
        return this.chatHistory.iterator(userToSearchWith);
    }

}