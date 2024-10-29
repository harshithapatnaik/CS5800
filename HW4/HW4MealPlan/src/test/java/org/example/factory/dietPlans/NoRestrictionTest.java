package org.example.factory.dietPlans;

import static org.junit.jupiter.api.Assertions.*;

import org.example.enums.Carbs;
import org.example.enums.Protein;
import org.example.enums.Fats;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NoRestrictionTest {

    @Test
    void testSingletonInstance() {
        // Arrange & Act
        NoRestriction instance1 = NoRestriction.getInstance();
        NoRestriction instance2 = NoRestriction.getInstance();

        // Assert: Verify that both references point to the same instance
        assertSame(instance1, instance2, "NoRestriction should implement the Singleton pattern");
    }

    @Test
    void testCreateCarbs() {
        // Arrange
        NoRestriction noRestriction = NoRestriction.getInstance();

        // Act
        List<Carbs> carbsList = noRestriction.createCarbs();

        // Assert: Verify the list contains all Carbs enum values
        assertNotNull(carbsList, "Carbs list should not be null");
        assertEquals(Carbs.values().length, carbsList.size(), "Carbs list should contain all enum values");
        for (Carbs carb : Carbs.values()) {
            assertTrue(carbsList.contains(carb), "Carbs list should contain: " + carb);
        }
    }

    @Test
    void testCreateProtein() {
        // Arrange
        NoRestriction noRestriction = NoRestriction.getInstance();

        // Act
        List<Protein> proteinList = noRestriction.createProtein();

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
        NoRestriction noRestriction = NoRestriction.getInstance();

        // Act
        List<Fats> fatsList = noRestriction.createFats();

        // Assert: Verify the list contains all Fats enum values
        assertNotNull(fatsList, "Fats list should not be null");
        assertEquals(Fats.values().length, fatsList.size(), "Fats list should contain all enum values");
        for (Fats fat : Fats.values()) {
            assertTrue(fatsList.contains(fat), "Fats list should contain: " + fat);
        }
    }
}
