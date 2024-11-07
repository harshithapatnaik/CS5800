package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    public void testAddItemToOrder() {
        Customer customer = new Customer("Harry", 0.10); // 10% discount

        // Add items to the customer's order
        FoodItem burger = new Burger();    // Burger costs $6.00
        FoodItem cheeseBurger = new Cheese(new Burger()); // Cheese adds $0.99
        customer.addItemToOrder(burger);
        customer.addItemToOrder(cheeseBurger);

        // Verify the order contains two items
        assertEquals(2, customer.getOrder().getItems().size());
    }

    @Test
    public void testCalculateTotalWithDiscount() {
        // Create a customer with a 10% discount
        Customer customer = new Customer("Harry", 0.10); // 10% discount

        // Add items to the customer's order
        FoodItem burger = new Burger();    // Cost: $6.00
        FoodItem cheeseBurger = new Cheese(new Burger()); // Cost: $6.99
        customer.addItemToOrder(burger);
        customer.addItemToOrder(cheeseBurger);

        // Calculate total with discount: (6.00 + 6.99) * 0.90 = 11.691
        double totalWithDiscount = customer.calculateTotalWithDiscount();
        assertEquals(11.69, totalWithDiscount, 0.01);
    }

    @Test
    public void testGetName() {
        Customer customer = new Customer("Harry", 0.10);
        assertEquals("Harry", customer.getName());
    }
}
