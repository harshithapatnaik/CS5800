package org.example;

import org.example.enums.DietPlan;
import org.example.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class MainTest {

    private MealPlanner mockMealPlanner;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        mockMealPlanner = Mockito.mock(MealPlanner.class);

        // Set up to capture console output
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testGenerateAndDisplayMeals() {
        // Arrange: Create a list of customers
        List<Customer> customers = List.of(
                new Customer("Harshitha", DietPlan.PALEO),
                new Customer("Divya", DietPlan.NO_RESTRICTION),
                new Customer("Aditya", DietPlan.NUT_ALLERGY),
                new Customer("Dinesh", DietPlan.VEGAN)
        );

        // Act: Call generateAndDisplayMeals with the mocked MealPlanner and customers list
        Main.generateAndDisplayMeals(mockMealPlanner, customers);

        // Assert: Verify that generateAndDisplayMeal was called for each customer
        for (Customer customer : customers) {
            verify(mockMealPlanner, times(1)).generateAndDisplayMeal(customer);
        }
    }

    @Test
    void testGenerateAndDisplayMealsOutput() {
        // Arrange: Create a real MealPlanner and a list of customers
        MealPlanner realMealPlanner = new MealPlanner();
        List<Customer> customers = List.of(
                new Customer("Harshitha", DietPlan.PALEO)
        );

        // Act: Generate and display meals for the customers
        Main.generateAndDisplayMeals(realMealPlanner, customers);

        // Assert: Check that the console output contains expected information for each customer
        String output = outputStream.toString();
        assertTrue(output.contains("Meal for Harshitha"), "The output should contain 'Meal for Harshitha'");
    }
}
