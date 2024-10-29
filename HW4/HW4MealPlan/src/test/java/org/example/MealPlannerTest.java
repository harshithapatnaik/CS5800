package org.example;

import org.example.enums.DietPlan;
import org.example.factory.Macronutrients;
import org.example.model.Customer;
import org.example.model.Meal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MealPlannerTest {

    private MealPlanner mealPlanner;

    @BeforeEach
    void setUp() {
        mealPlanner = new MealPlanner();
    }

    @Test
    void testGenerateMealForCustomer() {
        Customer veganCustomer = new Customer("Dinesh", DietPlan.VEGAN);
        Meal veganMeal = mealPlanner.generateMealForCustomer(veganCustomer);

        assertNotNull(veganMeal, "Generated meal should not be null");
        assertFalse(veganMeal.getCarbs().isEmpty(), "Carbs should be present in the meal");
        assertFalse(veganMeal.getProtein().isEmpty(), "Protein should be present in the meal");
        assertFalse(veganMeal.getFats().isEmpty(), "Fats should be present in the meal");
    }

    @Test
    void testGetFactoryForNullDietPlan() {
        Macronutrients result = mealPlanner.getFactoryForDiet(null);
        assertNull(result, "Factory should be null when diet plan is null");
    }

    @Test
    void testGenerateMealWithEmptyFoodLists() {
        Customer nutAllergyCustomer = new Customer("Anusha", DietPlan.NUT_ALLERGY);
        Macronutrients mockFactory = Mockito.mock(Macronutrients.class);
        when(mockFactory.createCarbs()).thenReturn(Collections.emptyList());
        when(mockFactory.createProtein()).thenReturn(Collections.emptyList());
        when(mockFactory.createFats()).thenReturn(Collections.emptyList());

        MealPlanner spyMealPlanner = Mockito.spy(mealPlanner);
        doReturn(mockFactory).when(spyMealPlanner).getFactoryForDiet(DietPlan.NUT_ALLERGY);

        Meal meal = spyMealPlanner.generateMealForCustomer(nutAllergyCustomer);
        assertNull(meal, "Meal should be null when no food items are available");
    }

    @Test
    void testDisplayMealOutput() {
        Customer customer = new Customer("Locharla", DietPlan.PALEO);
        Meal meal = mealPlanner.generateMealForCustomer(customer);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        mealPlanner.generateAndDisplayMeal(customer);

        String output = outputStream.toString();
        assertTrue(output.contains("Meal for Locharla"), "Output should include the customer's name");
        assertTrue(output.contains("Meal type: PALEO"), "Output should include the diet plan");
        assertTrue(output.contains("Carbs:"), "Output should include carbs information");
        assertTrue(output.contains("Protein:"), "Output should include protein information");
        assertTrue(output.contains("Fats:"), "Output should include fats information");

        System.setOut(System.out);
    }
}
