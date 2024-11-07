package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FriesTest {

    @Test
    public void testGetCost() {
        FoodItem fries = new Fries();

        // Verify the cost of fries
        assertEquals(2.59, fries.getCost(), 0.01);
    }

    @Test
    public void testGetDescription() {
        FoodItem fries = new Fries();

        // Verify the description
        assertEquals("Fries", fries.getDescription());
    }
}
