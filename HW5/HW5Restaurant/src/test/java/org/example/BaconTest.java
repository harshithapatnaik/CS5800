package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaconTest {

    @Test
    public void testGetCostWithBaseItem() {
        FoodItem burger = new Burger();
        Bacon baconBurger = new Bacon(burger);

        // Verify the cost is the base item cost plus Bacon cost
        assertEquals(7.99, baconBurger.getCost(), 0.01);  // Expected: 6.00 + 1.99 = 7.99
    }

    @Test
    public void testGetDescriptionWithBaseItem() {
        FoodItem burger = new Burger();
        Bacon baconBurger = new Bacon(burger);

        // Verify the description is the base item description plus ", Bacon"
        assertEquals("Burger, Bacon", baconBurger.getDescription());
    }
}
