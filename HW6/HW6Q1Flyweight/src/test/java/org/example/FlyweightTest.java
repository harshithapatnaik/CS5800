package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class FlyweightTest {
    @Test
    public void testGetCharacterProperties() {
        CharacterProperties property1 = Flyweight.getCharacterProperties("Arial", "Red", 12);
        CharacterProperties property2 = Flyweight.getCharacterProperties("Arial", "Red", 12);
        assertEquals(property1, property2);
        assertSame(property1, property2);
    }
}