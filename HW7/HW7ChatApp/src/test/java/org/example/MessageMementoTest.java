package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

public class MessageMementoTest {

    private MessageMemento messageMemento;
    private Timestamp timestamp;

    @BeforeEach
    public void setUp() {
        timestamp = Timestamp.valueOf("2023-11-18 10:00:00");
        messageMemento = new MessageMemento(timestamp, "Initial message");
    }

    @Test
    public void testMessageMementoConstructor() {
        assertEquals(timestamp, messageMemento.getTimestamp());
        assertEquals("Initial message", messageMemento.getMessageContent());
    }

    @Test
    public void testSetTimestamp() {
        Timestamp newTimestamp = Timestamp.valueOf("2023-11-19 12:00:00");
        messageMemento.setTimestamp(newTimestamp);
        assertEquals(newTimestamp, messageMemento.getTimestamp());
    }

    @Test
    public void testSetMessageContent() {
        messageMemento.setMessageContent("Updated message");
        assertEquals("Updated message", messageMemento.getMessageContent());
    }

    @Test
    public void testSetState() {
        Timestamp newTimestamp = Timestamp.valueOf("2023-11-20 14:00:00");
        messageMemento.setState(newTimestamp, "New state message");
        assertEquals(newTimestamp, messageMemento.getTimestamp());
        assertEquals("New state message", messageMemento.getMessageContent());
    }

    @Test
    public void testGetState() {
        String expectedOutput = "(" + timestamp + ")       Initial message";
        assertEquals(expectedOutput, messageMemento.getState());
    }
}
