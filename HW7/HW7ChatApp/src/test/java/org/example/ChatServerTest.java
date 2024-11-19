package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ChatServerTest {

    private ChatServer chatServer;
    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    public void setUp() {
        chatServer = new ChatServer();
        user1 = new User(chatServer, "Alice");
        user2 = new User(chatServer, "Bob");
        user3 = new User(chatServer, "Charlie");
    }

    @Test
    public void testRegisterUser() {
        chatServer.registerUser(user1);
    }

    @Test
    public void testUnregisterUser() {
        chatServer.registerUser(user1);
        chatServer.unregisterUser(user1);
    }

    @Test
    public void testSendMessage() {
        Message message = new Message(user1, new ArrayList<>(Arrays.asList(user2)), "Hello Bob!");
        chatServer.registerUser(user1);
        chatServer.registerUser(user2);

        boolean success = chatServer.sendMessage(message);
        assertTrue(success);
        assertTrue(user2.getChatHistory().getHistory().contains(message));
    }

    @Test
    public void testSendMessageToUnregisteredUser() {
        Message message = new Message(user1, new ArrayList<>(Arrays.asList(user2)), "Hello Bob!");
        chatServer.registerUser(user1);

        boolean success = chatServer.sendMessage(message);
        assertFalse(success);
    }

    @Test
    public void testBlockUser() {
        chatServer.registerUser(user1);
        chatServer.registerUser(user2);
        chatServer.blockUser(user1, user2);

    }

    @Test
    public void testSendMessageToBlockedUser() {
        chatServer.registerUser(user1);
        chatServer.registerUser(user2);
        chatServer.blockUser(user2, user1);

        Message message = new Message(user1, new ArrayList<>(Arrays.asList(user2)), "Hello Bob!");
        boolean success = chatServer.sendMessage(message);
    }
}
