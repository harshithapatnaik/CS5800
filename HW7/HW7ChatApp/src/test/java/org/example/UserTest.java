package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private ChatServer chatServer;
    private User user1;
    private User user2;
    private User user3;
    private Message message;

    @BeforeEach
    public void setUp() {
        chatServer = new ChatServer();
        user1 = new User(chatServer, "Alice");
        user2 = new User(chatServer, "Bob");
        user3 = new User(chatServer, "Charlie");
    }

    @Test
    public void testSend() {
        ArrayList<User> recipients = new ArrayList<>(Arrays.asList(user2, user3));
        user1.send(recipients, "Hello everyone!");
    }

    @Test
    public void testReceiveMessage() {
        message = new Message(user2, new ArrayList<>(Arrays.asList(user1)), "Hello Alice!");
        user1.receiveMessage(message);

        assertEquals(1, user1.getChatHistory().getHistory().size());
        assertEquals("Hello Alice!", user1.getChatHistory().getHistory().get(0).getMessageContent());
    }

    @Test
    public void testUndoLastMessageSent() {
        ArrayList<User> recipients = new ArrayList<>(Arrays.asList(user2));
        user1.send(recipients, "First Message");
        user1.send(recipients, "Second Message");

        user1.undoLastMessageSent();
    }

    @Test
    public void testGetLastMessageSent() {
        ArrayList<User> recipients = new ArrayList<>(Arrays.asList(user2));
        user1.send(recipients, "Test Message");
    }
}
