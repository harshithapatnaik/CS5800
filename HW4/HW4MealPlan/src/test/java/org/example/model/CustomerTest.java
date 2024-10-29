package org.example.model;

import org.example.enums.DietPlan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    void testCustomerConstructorAndGetters() {
        // Arrange
        String name = "Harshitha";
        DietPlan dietPlan = DietPlan.VEGAN;

        // Act
        Customer customer = new Customer(name, dietPlan);

        // Assert: Verify that the name and diet plan were set correctly via the constructor
        assertEquals(name, customer.getName(), "The name should match the input to the constructor");
        assertEquals(dietPlan, customer.getDietPlan(), "The diet plan should match the input to the constructor");
    }

    @Test
    void testSetName() {
        // Arrange
        Customer customer = new Customer("Old Name", DietPlan.PALEO);
        String newName = "New Name";

        // Act
        customer.setName(newName);

        // Assert: Verify that the name was set correctly
        assertEquals(newName, customer.getName(), "The name should match the value set by setName()");
    }

    @Test
    void testSetDietPlan() {
        // Arrange
        Customer customer = new Customer("Harshitha", DietPlan.NO_RESTRICTION);
        DietPlan newDietPlan = DietPlan.NUT_ALLERGY;

        // Act
        customer.setDietPlan(newDietPlan);

        // Assert: Verify that the diet plan was set correctly
        assertEquals(newDietPlan, customer.getDietPlan(), "The diet plan should match the value set by setDietPlan()");
    }

    @Test
    void testToString() {
        // Arrange
        String name = "Harshitha";
        DietPlan dietPlan = DietPlan.PALEO;
        Customer customer = new Customer(name, dietPlan);

        // Act
        String customerString = customer.toString();

        // Assert: Verify that the toString method includes the correct details
        assertTrue(customerString.contains("name='" + name + "'"), "The toString() method should include the customer's name");
        assertTrue(customerString.contains("dietPlan=" + dietPlan), "The toString() method should include the customer's diet plan");
    }
}
