package org.example;

import org.example.enums.PizzaSize;
import org.example.enums.PizzaTopping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        // Set up to capture console output for `eat()` method testing
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testPizzaHutWithAllSizes() {
        // Arrange
        PizzaChain pizzaHut = new AbsractDriver.PizzaHut();

        // Act
        Main.pizzaHutWithAllSizes(pizzaHut);

        // Assert: Verify the console output contains information for three pizzas of different sizes
        String output = outputStream.toString();
        assertTrue(output.contains("Pizza Chain : PIZZA_HUT"), "The output should contain 'Pizza Chain : PIZZA_HUT'");
        assertTrue(output.contains("Pizza Size  : SMALL"), "The output should contain 'Pizza Size  : SMALL'");
        assertTrue(output.contains("Pizza Size  : MEDIUM"), "The output should contain 'Pizza Size  : MEDIUM'");
        assertTrue(output.contains("Pizza Size  : LARGE"), "The output should contain 'Pizza Size  : LARGE'");
    }

    @Test
    void testPizzaHutWithSmallAndLargeSizes() {
        // Arrange
        PizzaChain pizzaHut = new AbsractDriver.PizzaHut();

        // Act
        Main.pizzaHutWithSmallAndLargeSizes(pizzaHut);

        // Assert: Verify the console output contains information for small and large pizzas
        String output = outputStream.toString();
        assertTrue(output.contains("Pizza Chain : PIZZA_HUT"), "The output should contain 'Pizza Chain : PIZZA_HUT'");
        assertTrue(output.contains("Pizza Size  : SMALL"), "The output should contain 'Pizza Size  : SMALL'");
        assertTrue(output.contains("Pizza Size  : LARGE"), "The output should contain 'Pizza Size  : LARGE'");
    }

    @Test
    void testLittleCaesarsWithSmallAndMediumSizes() {
        // Arrange
        PizzaChain littleCaesars = new AbsractDriver.LittleCaesars();

        // Act
        Main.littleCaesarsWithSmallAndMediumSizes(littleCaesars);

        // Assert: Verify the console output contains information for small and medium pizzas
        String output = outputStream.toString();
        assertTrue(output.contains("Pizza Chain : LITTLE_CAESARS"), "The output should contain 'Pizza Chain : LITTLE_CAESARS'");
        assertTrue(output.contains("Pizza Size  : SMALL"), "The output should contain 'Pizza Size  : SMALL'");
        assertTrue(output.contains("Pizza Size  : MEDIUM"), "The output should contain 'Pizza Size  : MEDIUM'");
    }

    @Test
    void testDominosWithSmallAndLarge() {
        // Arrange
        PizzaChain dominos = new AbsractDriver.Dominos();

        // Act
        Main.dominosWithSmallAndLarge(dominos);

        // Assert: Verify the console output contains information for small and large pizzas
        String output = outputStream.toString();
        assertTrue(output.contains("Pizza Chain : DOMINOS"), "The output should contain 'Pizza Chain : DOMINOS'");
        assertTrue(output.contains("Pizza Size  : SMALL"), "The output should contain 'Pizza Size  : SMALL'");
        assertTrue(output.contains("Pizza Size  : LARGE"), "The output should contain 'Pizza Size  : LARGE'");
    }
}
