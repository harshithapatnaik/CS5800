package org.example.factory.dietPlans;

import org.example.enums.Carbs;
import org.example.enums.Fats;
import org.example.enums.Protein;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VeganTest {

    @Test
    void testGetInstanceIsSingleton() {
        // Act
        Vegan instance1 = Vegan.getInstance();
        Vegan instance2 = Vegan.getInstance();

        // Assert: Both instances should be the same
        assertSame(instance1, instance2, "Vegan.getInstance() should return the same instance each time (singleton pattern)");
    }

    @Test
    void testCreateCarbs() {
        // Arrange
        Vegan vegan = Vegan.getInstance();

        // Act
        List<Carbs> carbsList = vegan.createCarbs();

        // Assert: The carbs list should not contain Cheese
        assertFalse(carbsList.contains(Carbs.CHEESE), "Vegan diet should not allow Cheese as a carb source");
        assertEquals(Carbs.values().length - 1, carbsList.size(), "Vegan diet should allow all carbs except Cheese");
    }

    @Test
    void testCreateProtein() {
        // Arrange
        Vegan vegan = Vegan.getInstance();

        // Act
        List<Protein> proteinList = vegan.createProtein();

        // Assert: The protein list should not contain Fish, Chicken, or Beef
        assertFalse(proteinList.contains(Protein.FISH), "Vegan diet should not allow Fish as a protein source");
        assertFalse(proteinList.contains(Protein.CHICKEN), "Vegan diet should not allow Chicken as a protein source");
        assertFalse(proteinList.contains(Protein.BEEF), "Vegan diet should not allow Beef as a protein source");
        assertEquals(Protein.values().length - 3, proteinList.size(), "Vegan diet should allow all protein sources except Fish, Chicken, and Beef");
    }

    @Test
    void testCreateFats() {
        // Arrange
        Vegan vegan = Vegan.getInstance();

        // Act
        List<Fats> fatsList = vegan.createFats();

        // Assert: The fats list should not contain Sour Cream or Tuna
        assertFalse(fatsList.contains(Fats.SOUR_CREAM), "Vegan diet should not allow Sour Cream as a fat source");
        assertFalse(fatsList.contains(Fats.TUNA), "Vegan diet should not allow Tuna as a fat source");
        assertEquals(Fats.values().length - 2, fatsList.size(), "Vegan diet should allow all fat sources except Sour Cream and Tuna");
    }
}
