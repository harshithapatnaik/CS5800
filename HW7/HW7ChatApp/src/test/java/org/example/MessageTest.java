package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    private User sender;
    private User recipient1;
    private User recipient2;
    private ArrayList<User> recipients;
    private Message message;

    @BeforeEach
    public void setUp() {
        ChatServer chatServer = new ChatServer();
        sender = new User(chatServer, "Alice");
        recipient1 = new User(chatServer, "Bob");
        recipient2 = new User(chatServer, "Charlie");
        recipients = new ArrayList<>(Arrays.asList(recipient1, recipient2));
        message = new Message(sender, recipients, "Hello everyone!");
    }

    @Test
    public void testMessageConstructor() {
        assertEquals(sender, message.getSender());
        assertEquals(recipients, message.getRecipients());
        assertEquals("Hello everyone!", message.getMessageContent());
        assertNotNull(message.getTimestamp());
    }

    @Test
    public void testSetSender() {
        User newSender = new User(new ChatServer(), "David");
        message.setSender(newSender);
        assertEquals(newSender, message.getSender());
    }

    @Test
    public void testSetRecipients() {
        ArrayList<User> newRecipients = new ArrayList<>(Arrays.asList(new User(new ChatServer(), "Eve")));
        message.setRecipients(newRecipients);
        assertEquals(newRecipients, message.getRecipients());
    }

    @Test
    public void testSetMessageContent() {
        message.setMessageContent("New message content");
        assertEquals("New message content", message.getMessageContent());
    }

    @Test
    public void testSetTimestamp() {
        LocalDateTime newTimestamp = LocalDateTime.of(2022, 1, 1, 12, 0);
        message.setTimestamp(newTimestamp);
        assertEquals(newTimestamp, message.getTimestamp());
    }

    @Test
    public void testToString() {
        String expectedOutput = "(" + message.getTimestamp() + ") Message from Alice to Bob, Charlie: Hello everyone!";
        assertEquals(expectedOutput, message.toString());
    }
}
