package org.example.model;

import org.example.enums.Carbs;
import org.example.enums.Protein;
import org.example.enums.Fats;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MealTest {

    @Test
    void testMealConstructorAndGetters() {
        // Arrange
        List<Carbs> carbsList = Collections.singletonList(Carbs.BREAD);
        List<Protein> proteinList = Collections.singletonList(Protein.CHICKEN);
        List<Fats> fatsList = Collections.singletonList(Fats.AVOCADO);

        // Act
        Meal meal = new Meal(carbsList, proteinList, fatsList);

        // Assert: Verify that the lists were set correctly via the constructor
        assertEquals(carbsList, meal.getCarbs(), "The carbs list should match the input to the constructor");
        assertEquals(proteinList, meal.getProtein(), "The protein list should match the input to the constructor");
        assertEquals(fatsList, meal.getFats(), "The fats list should match the input to the constructor");
    }

    @Test
    void testSetCarbs() {
        // Arrange
        Meal meal = new Meal(Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
        List<Carbs> carbsList = Arrays.asList(Carbs.BREAD, Carbs.LENTILS);

        // Act
        meal.setCarbs(carbsList);

        // Assert: Verify that the carbs list was set correctly
        assertEquals(carbsList, meal.getCarbs(), "The carbs list should match the value set by setCarbs()");
    }

    @Test
    void testSetProtein() {
        // Arrange
        Meal meal = new Meal(Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
        List<Protein> proteinList = Arrays.asList(Protein.CHICKEN, Protein.BEEF);

        // Act
        meal.setProtein(proteinList);

        // Assert: Verify that the protein list was set correctly
        assertEquals(proteinList, meal.getProtein(), "The protein list should match the value set by setProtein()");
    }

    @Test
    void testSetFats() {
        // Arrange
        Meal meal = new Meal(Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
        List<Fats> fatsList = Arrays.asList(Fats.AVOCADO, Fats.TUNA);

        // Act
        meal.setFats(fatsList);

        // Assert: Verify that the fats list was set correctly
        assertEquals(fatsList, meal.getFats(), "The fats list should match the value set by setFats()");
    }

    @Test
    void testToString() {
        // Arrange
        List<Carbs> carbsList = Collections.singletonList(Carbs.BREAD);
        List<Protein> proteinList = Collections.singletonList(Protein.CHICKEN);
        List<Fats> fatsList = Collections.singletonList(Fats.AVOCADO);
        Meal meal = new Meal(carbsList, proteinList, fatsList);

        // Act
        String mealString = meal.toString();

        // Assert: Verify that the toString method includes the correct details
        assertTrue(mealString.contains("carbs=" + carbsList.toString()), "The toString() method should include the carbs list");
        assertTrue(mealString.contains("protein=" + proteinList.toString()), "The toString() method should include the protein list");
        assertTrue(mealString.contains("fats=" + fatsList.toString()), "The toString() method should include the fats list");
    }
}
