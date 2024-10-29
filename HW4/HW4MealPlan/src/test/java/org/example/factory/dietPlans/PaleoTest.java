package org.example.factory.dietPlans;

import org.example.enums.Carbs;
import org.example.enums.Fats;
import org.example.enums.Protein;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PaleoTest {

    @Test
    void testGetInstanceIsSingleton() {
        // Act
        Paleo instance1 = Paleo.getInstance();
        Paleo instance2 = Paleo.getInstance();

        // Assert: Both instances should be the same
        assertSame(instance1, instance2, "Paleo.getInstance() should return the same instance each time (singleton pattern)");
    }

    @Test
    void testCreateCarbs() {
        // Arrange
        Paleo paleo = Paleo.getInstance();

        // Act
        List<Carbs> carbsList = paleo.createCarbs();

        // Assert: The carbs list should only contain Pistachio
        assertEquals(1, carbsList.size(), "Paleo diet should have exactly one carb");
        assertTrue(carbsList.contains(Carbs.PISTACHIO), "Paleo diet should allow only Pistachio as a carb source");
    }

    @Test
    void testCreateProtein() {
        // Arrange
        Paleo paleo = Paleo.getInstance();

        // Act
        List<Protein> proteinList = paleo.createProtein();

        // Assert: All proteins except Tofu should be present
        assertFalse(proteinList.contains(Protein.TOFU), "Paleo diet should not allow Tofu as a protein source");
        assertEquals(Protein.values().length - 1, proteinList.size(), "Paleo diet should allow all protein sources except Tofu");
    }

    @Test
    void testCreateFats() {
        // Arrange
        Paleo paleo = Paleo.getInstance();

        // Act
        List<Fats> fatsList = paleo.createFats();

        // Assert: All fats except Sour Cream should be present
        assertFalse(fatsList.contains(Fats.SOUR_CREAM), "Paleo diet should not allow Sour Cream as a fat source");
        assertEquals(Fats.values().length - 1, fatsList.size(), "Paleo diet should allow all fat sources except Sour Cream");
    }
}
