package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class SearchMessagesByUserTest {

    private User user1;
    private User user2;
    private User user3;
    private Message message1;
    private Message message2;
    private Message message3;
    private ArrayList<Message> chatHistory;
    private SearchMessagesByUser searchMessagesByUser;

    @BeforeEach
    public void setUp() {
        ChatServer chatServer = new ChatServer();
        user1 = new User(chatServer, "Alice");
        user2 = new User(chatServer, "Bob");
        user3 = new User(chatServer, "Charlie");

        message1 = new Message(user1, new ArrayList<>(Arrays.asList(user2)), "Hello Bob!");
        message2 = new Message(user2, new ArrayList<>(Arrays.asList(user1)), "Hi Alice!");
        message3 = new Message(user1, new ArrayList<>(Arrays.asList(user2, user3)), "Hello everyone!");

        chatHistory = new ArrayList<>(Arrays.asList(message1, message2, message3));
        user1.getChatHistory().getHistory().addAll(chatHistory);

        searchMessagesByUser = new SearchMessagesByUser(user1);
    }

    @Test
    public void testHasNext() {
        assertTrue(searchMessagesByUser.hasNext());
        searchMessagesByUser.next(); // Move to the next message
        assertTrue(searchMessagesByUser.hasNext());
    }

    @Test
    public void testNext() {
        Message nextMessage = searchMessagesByUser.next();
        assertEquals(message1, nextMessage);

    }

    @Test
    public void testNoNextMessage() {
        searchMessagesByUser.next(); // message1
        searchMessagesByUser.next(); // message3
    }

    @Test
    public void testRemoveUnsupportedOperation() {
        assertThrows(UnsupportedOperationException.class, () -> searchMessagesByUser.remove());
    }
}
