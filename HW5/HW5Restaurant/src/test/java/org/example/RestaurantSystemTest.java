package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantSystemTest {

    @Test
    public void testAddCustomer() {
        // Create a RestaurantSystem instance and add a customer
        RestaurantSystem restaurantSystem = new RestaurantSystem();
        restaurantSystem.addCustomer("Harry", 0.10);  // 10% discount

        // Verify that the customer was added
        assertEquals(1, restaurantSystem.getAllCustomers().size());
        assertTrue(restaurantSystem.getAllCustomers().stream()
                .anyMatch(customer -> "Harry".equals(customer.getName())));
    }

    @Test
    public void testAddItemToCustomerOrder() {
        // Create a RestaurantSystem instance and add a customer
        RestaurantSystem restaurantSystem = new RestaurantSystem();
        restaurantSystem.addCustomer("Adi", 0.15);  // 15% discount

        // Add items to Adi's order
        FoodItem burger = new Burger();
        restaurantSystem.addItemToCustomerOrder("Adi", burger);

        // Verify the item was added to Adi's order
        Customer Adi = restaurantSystem.getAllCustomers().stream()
                .filter(customer -> "Adi".equals(customer.getName()))
                .findFirst()
                .orElse(null);
        assertNotNull(Adi);
        assertEquals(1, Adi.getOrder().getItems().size());
        assertEquals("Burger", Adi.getOrder().getItems().get(0).getDescription());
    }

    @Test
    public void testGetAllCustomers() {
        // Create a RestaurantSystem instance and add multiple customers
        RestaurantSystem restaurantSystem = new RestaurantSystem();
        restaurantSystem.addCustomer("Harry", 0.10);
        restaurantSystem.addCustomer("Adi", 0.15);

        // Verify all customers are retrieved
        assertEquals(2, restaurantSystem.getAllCustomers().size());
        assertTrue(restaurantSystem.getAllCustomers().stream()
                .anyMatch(customer -> "Harry".equals(customer.getName())));
        assertTrue(restaurantSystem.getAllCustomers().stream()
                .anyMatch(customer -> "Adi".equals(customer.getName())));
    }
}
