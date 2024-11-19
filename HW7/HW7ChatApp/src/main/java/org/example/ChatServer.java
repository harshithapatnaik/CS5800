package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class ChatServer {

    private ArrayList<User> registeredUsers;
    private HashMap<User, ArrayList<User>> blockedUsers;

    public ChatServer(){
        this.registeredUsers = new ArrayList<User>();
        this.blockedUsers = new HashMap<User, ArrayList<User>>();
    }

    public void registerUser(User user){
        this.registeredUsers.add(user);
        if(!blockedUsers.containsKey(user)){
            blockedUsers.put(user, new ArrayList<User>());
        }
        System.out.println(user.getUserName() + " registered.");
    }

    public void unregisterUser(User user){
        this.registeredUsers.remove(user);
        if(blockedUsers.containsKey(user)){
            blockedUsers.remove(user);
        }
    }

    public boolean sendMessage(Message message){
        User sender = message.getSender();
        boolean success = true;
        boolean sent = false;
        ArrayList<User> recipients = message.getRecipients();
        StringBuilder recipientNames = new StringBuilder();
        for(User recipient: recipients){
            if (recipientNames.toString().isEmpty()){
                recipientNames.append(recipient.getUserName());
            }
            else {
                recipientNames.append(", ").append(recipient.getUserName());
            }
        }
        for(User recipient: recipients){
            if(registeredUsers.contains(recipient)){
                if(!this.blockedUsers.get(recipient).contains(sender)){
                    if(!sent) {
                        System.out.println(
                                "\n(" + message.getTimestamp() + ") "
                                        + sender.getUserName() + " sent a message to "
                                        + recipientNames + ": "
                                        + message.getMessageContent()
                        );
                        sent = true;
                    }
                    recipient.receiveMessage(message);
                }
                else{
                    System.out.println(
                            "Mediator blocked messages from "
                                    + sender.getUserName() + " to "
                                    + recipient.getUserName() + "."
                    );
                    success =  false;
                }
            }
            else{
                System.out.println(
                        "\nMediator has not registered users to send messages from "
                                + sender.getUserName() + " to "
                                + recipient.getUserName() + "."
                );
                success =  false;
            }
        }
        return success;

    }

    public void blockUser(User blocker, User blocked){
        ArrayList<User> blockedByBlocker = this.blockedUsers.get(blocker);
    }

}