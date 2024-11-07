package org.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testRestaurantSystem() {
        // Capture System.out output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // Run the restaurant system setup and order display
            Main.restaurantSystem();

            // Convert captured output to a string for verification
            String output = outputStream.toString();

            // Check for expected output related to customer orders and discounts
            assertTrue(output.contains("Harry's Order"), "Expected 'Harry's Order' in output.");
            assertTrue(output.contains("Adi's Order"), "Expected 'Adi's Order' in output.");
            assertTrue(output.contains("Total cost before discount: $"), "Expected 'Total cost before discount' in output.");
            assertTrue(output.contains("Discounted total: $"), "Expected 'Discounted total' in output.");
            assertTrue(output.contains("Burger, Cheese, Bacon"), "Expected 'Burger, Cheese, Bacon' in output.");
            assertTrue(output.contains("Fries"), "Expected 'Fries' in output.");
            assertTrue(output.contains("Hot Dog, Cheese"), "Expected 'Hot Dog, Cheese' in output.");
        } finally {
            // Restore the original System.out
            System.setOut(originalOut);
        }
    }

    @Test
    public void testDisplayOrderDetails() {
        // Create a sample customer and add items to the order
        Customer customer = new Customer("TestCustomer", 0.20); // 20% discount
        customer.addItemToOrder(new Bacon(new Cheese(new Burger()))); // Burger with Cheese and Bacon
        customer.addItemToOrder(new Fries());                        // Plain Fries

        // Capture System.out output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // Display order details for the sample customer
            Main.displayOrderDetails(customer);

            // Convert captured output to a string for verification
            String output = outputStream.toString();

            // Verify the output contains expected details
            assertTrue(output.contains("Burger, Cheese, Bacon | Cost: $"), "Expected 'Burger, Cheese, Bacon' cost in output.");
            assertTrue(output.contains("Fries | Cost: $"), "Expected 'Fries' cost in output.");
            assertTrue(output.contains("Total cost before discount: $"), "Expected 'Total cost before discount' in output.");
            assertTrue(output.contains("Discounted total: $"), "Expected 'Discounted total' in output.");
        } finally {
            // Restore the original System.out
            System.setOut(originalOut);
        }
    }
}
