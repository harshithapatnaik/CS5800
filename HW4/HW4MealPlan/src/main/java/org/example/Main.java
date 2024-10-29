package org.example;

import org.example.enums.DietPlan;
import org.example.model.*;

import java.util.List;

/**
 *
 * @author harshitha
 */
public class Main {
    public static void main(String[] args) {
        // 6 customers with various diet plans
        List<Customer> customers = List.of(
                new Customer("Harshitha", DietPlan.PALEO),
                new Customer("Divya", DietPlan.NO_RESTRICTION),
                new Customer("Aditya", DietPlan.NUT_ALLERGY),
                new Customer("Dinesh", DietPlan.VEGAN),
                new Customer("Anusha", DietPlan.NUT_ALLERGY),
                new Customer("Locharla", DietPlan.PALEO)
        );

        // Instance of the MealPlanner
        MealPlanner mealPlanner = new MealPlanner();

        // Generate and display meals for each customer
        generateAndDisplayMeals(mealPlanner, customers);
    }

    // Extracted method for generating and displaying meals
    public static void generateAndDisplayMeals(MealPlanner mealPlanner, List<Customer> customers) {
        for (Customer customer : customers) {
            mealPlanner.generateAndDisplayMeal(customer);
        }
    }
}
