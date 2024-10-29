package org.example;

import org.example.enums.PizzaChainName;
import org.example.enums.PizzaSize;
import org.example.enums.PizzaTopping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PizzaTest {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        // Set up to capture console output for `eat()` method testing
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testPizzaBuilderAndGetters() {
        // Arrange
        Pizza.PizzaBuilder builder = new Pizza.PizzaBuilder(PizzaSize.LARGE, PizzaChainName.PIZZA_HUT);

        // Act
        builder.addTopping(PizzaTopping.PEPPERONI).addTopping(PizzaTopping.MUSHROOMS);
        Pizza pizza = builder.build();

        // Assert: Verify that the pizza was constructed with the correct properties
        assertEquals(PizzaSize.LARGE, pizza.pizzaSize, "The pizza size should be LARGE");
        assertEquals(PizzaChainName.PIZZA_HUT, pizza.pizzaChain, "The pizza chain should be PIZZA_HUT");
        assertEquals(2, pizza.pizzaToppings.size(), "The pizza should have 2 toppings");
        assertTrue(pizza.pizzaToppings.contains(PizzaTopping.PEPPERONI), "The pizza should contain PEPPERONI topping");
        assertTrue(pizza.pizzaToppings.contains(PizzaTopping.MUSHROOMS), "The pizza should contain MUSHROOMS topping");
    }

    @Test
    void testPizzaWithNoToppings() {
        // Arrange
        Pizza.PizzaBuilder builder = new Pizza.PizzaBuilder(PizzaSize.MEDIUM, PizzaChainName.DOMINOS);

        // Act
        Pizza pizza = builder.build();

        // Assert: Verify that the pizza has no toppings
        assertEquals(0, pizza.pizzaToppings.size(), "The pizza should have no toppings");
    }

    @Test
    void testAddNullTopping() {
        // Arrange
        Pizza.PizzaBuilder builder = new Pizza.PizzaBuilder(PizzaSize.SMALL, PizzaChainName.LITTLE_CAESARS);

        // Act
        builder.addTopping(null);
        Pizza pizza = builder.build();

        // Assert: Verify that adding a null topping does not add any toppings to the pizza
        assertEquals(0, pizza.pizzaToppings.size(), "The pizza should have no toppings since null topping was added");
    }

    @Test
    void testEatMethod() {
        // Arrange
        Pizza.PizzaBuilder builder = new Pizza.PizzaBuilder(PizzaSize.LARGE, PizzaChainName.PIZZA_HUT);
        builder.addTopping(PizzaTopping.PEPPERONI).addTopping(PizzaTopping.EXTRA_CHEESE);
        Pizza pizza = builder.build();

        // Act
        pizza.eat();

        // Assert: Verify the output contains the expected details
        String output = outputStream.toString();
        assertTrue(output.contains("Pizza Chain : PIZZA_HUT"), "The output should contain 'Pizza Chain : PIZZA_HUT'");
        assertTrue(output.contains("Pizza Size  : LARGE"), "The output should contain 'Pizza Size  : LARGE'");
        assertTrue(output.contains("Pizza Topping 1 : PEPPERONI"), "The output should contain 'Pizza Topping 1 : PEPPERONI'");
        assertTrue(output.contains("Pizza Topping 2 : EXTRA_CHEESE"), "The output should contain 'Pizza Topping 2 : EXTRA_CHEESE'");
    }
}
