package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CheeseTest {

    @Test
    public void testGetCostWithBaseItem() {
        FoodItem burger = new Burger();
        Cheese cheeseBurger = new Cheese(burger);

        // Verify the cost is the base item cost plus Cheese cost
        assertEquals(6.99, cheeseBurger.getCost(), 0.01);  // Expected: 6.00 + 0.99 = 6.99
    }

    @Test
    public void testGetDescriptionWithBaseItem() {
        FoodItem burger = new Burger();
        Cheese cheeseBurger = new Cheese(burger);

        // Verify the description is the base item description plus ", Cheese"
        assertEquals("Burger, Cheese", cheeseBurger.getDescription());
    }
}
