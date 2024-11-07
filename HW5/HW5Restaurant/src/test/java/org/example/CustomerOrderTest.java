package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class CustomerOrderTest {

    @Test
    public void testAddItem() {
        CustomerOrder order = new CustomerOrder();

        // Add items to the order
        FoodItem burger = new Burger();    // Burger costs $6.00
        FoodItem cheeseBurger = new Cheese(new Burger()); // Cheese $0.99
        order.addItem(burger);
        order.addItem(cheeseBurger);

        // Verify the order contains two items
        List<FoodItem> items = order.getItems();
        assertEquals(2, items.size());
        assertTrue(items.contains(burger));
        assertTrue(items.contains(cheeseBurger));
    }

    @Test
    public void testCalculateTotal() {
        CustomerOrder order = new CustomerOrder();

        // Add items to the order
        FoodItem burger = new Burger();    // Cost: $6.00
        FoodItem cheeseBurger = new Cheese(new Burger()); // Cost: $6.99
        order.addItem(burger);
        order.addItem(cheeseBurger);

        double total = order.calculateTotal();

        // Verify the total cost
        assertEquals(12.99, total, 0.01);  // Expected: 6.00 + 6.99 = 12.99
    }
}
