package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class ChatHistoryTest {

    private ChatHistory chatHistory;
    private User user1;
    private User user2;

    @BeforeEach
    public void setUp() {
        chatHistory = new ChatHistory();
        user1 = new User(new ChatServer(), "Alice");
        user2 = new User(new ChatServer(), "Bob");
    }

    @Test
    public void testAddMessageToHistory() {
        Message message = new Message(user1, new ArrayList<>(Arrays.asList(user2)), "Hello Bob!");
        chatHistory.addMessageToHistory(message);

        assertEquals(1, chatHistory.getHistory().size());
        assertEquals("Hello Bob!", chatHistory.getHistory().get(0).getMessageContent());
    }

    @Test
    public void testRemoveLastSentMessageFromHistory() {
        Message message1 = new Message(user1, new ArrayList<>(Arrays.asList(user2)), "Hello Bob!");
        Message message2 = new Message(user1, new ArrayList<>(Arrays.asList(user2)), "How are you?");
        chatHistory.addMessageToHistory(message1);
        chatHistory.addMessageToHistory(message2);

        chatHistory.removeLastSentMessageFromHistory(user1);

        assertEquals(1, chatHistory.getHistory().size());
        assertEquals("Hello Bob!", chatHistory.getHistory().get(0).getMessageContent());
    }

    @Test
    public void testIteratorByUser() {
        Message message1 = new Message(user1, new ArrayList<>(Arrays.asList(user2)), "Hello Bob!");
        Message message2 = new Message(user2, new ArrayList<>(Arrays.asList(user1)), "Hi Alice!");
        Message message3 = new Message(user1, new ArrayList<>(Arrays.asList(user2)), "How are you?");
        chatHistory.addMessageToHistory(message1);
        chatHistory.addMessageToHistory(message2);
        chatHistory.addMessageToHistory(message3);
    }

    @Test
    public void testUpdateLastSentMessage() {
        Message message1 = new Message(user1, new ArrayList<>(Arrays.asList(user2)), "Hello Bob!");
        Message message2 = new Message(user1, new ArrayList<>(Arrays.asList(user2)), "How are you?");
        chatHistory.addMessageToHistory(message1);
        chatHistory.addMessageToHistory(message2);

        chatHistory.updateLastSentMessage(user1);
    }
}
