package org.example.factory.dietPlans;

import org.example.enums.Carbs;
import org.example.enums.Protein;
import org.example.enums.Fats;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NutAllergyTest {

    @Test
    void testSingletonInstance() {
        // Arrange & Act
        NutAllergy instance1 = NutAllergy.getInstance();
        NutAllergy instance2 = NutAllergy.getInstance();

        // Assert: Verify that both references point to the same instance
        assertSame(instance1, instance2, "NutAllergy should implement the Singleton pattern");
    }

    @Test
    void testCreateCarbs() {
        // Arrange
        NutAllergy nutAllergy = NutAllergy.getInstance();

        // Act
        List<Carbs> carbsList = nutAllergy.createCarbs();

        // Assert: Verify the list contains all Carbs enum values except PISTACHIO
        assertNotNull(carbsList, "Carbs list should not be null");
        assertFalse(carbsList.contains(Carbs.PISTACHIO), "Carbs list should not contain Pistachio");
        assertEquals(Carbs.values().length - 1, carbsList.size(), "Carbs list should exclude Pistachio");
        for (Carbs carb : Carbs.values()) {
            if (carb != Carbs.PISTACHIO) {
                assertTrue(carbsList.contains(carb), "Carbs list should contain: " + carb);
            }
        }
    }

    @Test
    void testCreateProtein() {
        // Arrange
        NutAllergy nutAllergy = NutAllergy.getInstance();

        // Act
        List<Protein> proteinList = nutAllergy.createProtein();

        // Assert: Verify the list contains all Protein enum values
        assertNotNull(proteinList, "Protein list should not be null");
        assertEquals(Protein.values().length, proteinList.size(), "Protein list should contain all enum values");
        for (Protein protein : Protein.values()) {
            assertTrue(proteinList.contains(protein), "Protein list should contain: " + protein);
        }
    }

    @Test
    void testCreateFats() {
        // Arrange
        NutAllergy nutAllergy = NutAllergy.getInstance();

        // Act
        List<Fats> fatsList = nutAllergy.createFats();

        // Assert: Verify the list contains all Fats enum values except PEANUTS
        assertNotNull(fatsList, "Fats list should not be null");
        assertFalse(fatsList.contains(Fats.PEANUTS), "Fats list should not contain Peanuts");
        assertEquals(Fats.values().length - 1, fatsList.size(), "Fats list should exclude Peanuts");
        for (Fats fat : Fats.values()) {
            if (fat != Fats.PEANUTS) {
                assertTrue(fatsList.contains(fat), "Fats list should contain: " + fat);
            }
        }
    }
}
