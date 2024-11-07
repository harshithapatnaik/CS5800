package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HotDogTest {

    @Test
    public void testGetCost() {
        FoodItem hotDog = new HotDog();

        // Verify the cost of the hot dog
        assertEquals(3.49, hotDog.getCost(), 0.01);
    }

    @Test
    public void testGetDescription() {
        FoodItem hotDog = new HotDog();

        // Verify the description
        assertEquals("Hot Dog", hotDog.getDescription());
    }
}
