package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args){

        ChatServer mediator = new ChatServer();
        User User1 = new User(mediator, "Adi");
        User User2 = new User(mediator, "Divya");
        User User3 = new User(mediator, "Harshitha");
        mediator.registerUser(User1);
        mediator.registerUser(User2);
        mediator.registerUser(User3);

        System.out.println();
        System.out.println("<<<<<<<<<<--------------MESSAGING------------->>>>>>>>>>");
        // 1 Users can send messages to one or more other users through the chat server.
        User1.send(new ArrayList<User>(List.of(User2)), "Hello Divya!");

        User1.send(new ArrayList<User>(List.of(User3)), "Hello Harshitha!");

        System.out.println("\n<<<<<<<<<<--------------MESSAGING MULTIPLE------------->>>>>>>>>>");
        User2.send(new ArrayList<User>(Arrays.asList(User1, User3)), "Hello Adi and Harshitha it's Divya!");

        System.out.println("\n<<<<<<<<<<--------------ADDED CONVERSATION------------->>>>>>>>>>");
        User3.send(new ArrayList<User>(List.of(User1)), "Hello Adi, How are you doing ?");

        User1.send(new ArrayList<User>(List.of(User3)), "I am doing great!");

        System.out.println("\n<<<<<<<<<<<------------UNDO------------->>>>>>>>>>>");

        // 2  Users can undo the last message they sent using the Memento design pattern.
        System.out.println("Current last message for Adi is :-");
        System.out.println(User1.getLastMessageSent());
        System.out.println("After deleting last message, Current last message for Adi is :-");
        User1.undoLastMessageSent();
        System.out.println(User1.getLastMessageSent());
        System.out.println("------------------------------BLOCK--------------------------------------------------");
        // 3 Users can block messages from specific users using the Mediator design pattern.
        User1.blockUser(User3);
        User3.send(new ArrayList<>(Arrays.asList(User1)), "Did you just block me ?");
        System.out.println("-----------------------------CHAT HISTORY------------------------------------------------------");

        // 4  Users can receive messages from other users and view the chat history for a specific user.
        Iterator searchAHistoryForC = User1.iterator(User2);
        while(searchAHistoryForC.hasNext()){
            System.out.println(searchAHistoryForC.next());
        }

    }

}