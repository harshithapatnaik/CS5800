package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BurgerTest {

    @Test
    public void testGetCost() {
        FoodItem burger = new Burger();

        // Verify the cost of the burger
        assertEquals(6.00, burger.getCost(), 0.01);
    }

    @Test
    public void testGetDescription() {
        FoodItem burger = new Burger();

        // Verify the description of the burger
        assertEquals("Burger", burger.getDescription());
    }
}
