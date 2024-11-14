package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterPropertiesTest {
    @Test
    public void testGetFont() {
        CharacterProperties properties = new CharacterProperties("Arial", "Red", 12);
        assertEquals("Arial", properties.getFont());
    }

    @Test
    public void testGetColor() {
        CharacterProperties properties = new CharacterProperties("Arial", "Red", 12);
        assertEquals("Red", properties.getColor());
    }

    @Test
    public void testGetSize() {
        CharacterProperties properties = new CharacterProperties("Arial", "Red", 12);
        assertEquals(12, properties.getSize());
    }
}