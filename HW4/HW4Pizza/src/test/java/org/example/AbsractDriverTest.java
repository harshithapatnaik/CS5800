package org.example;

import org.example.enums.PizzaChainName;
import org.example.enums.PizzaSize;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AbsractDriverTest {

    @Test
    void testPizzaHutBuilder() {
        // Arrange
        AbsractDriver.PizzaHut pizzaHut = new AbsractDriver.PizzaHut();

        // Act
        Pizza.PizzaBuilder pizzaBuilder = pizzaHut.pizzaBuilder(PizzaSize.MEDIUM);
        Pizza pizza = pizzaBuilder.build();

        // Assert
        assertNotNull(pizza, "The pizza should not be null");
        assertEquals(PizzaSize.MEDIUM, pizza.getPizzaSize(), "The pizza size should be MEDIUM");
        assertEquals(PizzaChainName.PIZZA_HUT, pizza.getPizzaChain(), "The pizza chain should be Pizza Hut");
    }

    @Test
    void testDominosBuilder() {
        // Arrange
        AbsractDriver.Dominos dominos = new AbsractDriver.Dominos();

        // Act
        Pizza.PizzaBuilder pizzaBuilder = dominos.pizzaBuilder(PizzaSize.LARGE);
        Pizza pizza = pizzaBuilder.build();

        // Assert
        assertNotNull(pizza, "The pizza should not be null");
        assertEquals(PizzaSize.LARGE, pizza.getPizzaSize(), "The pizza size should be LARGE");
        assertEquals(PizzaChainName.DOMINOS, pizza.getPizzaChain(), "The pizza chain should be Dominos");
    }

    @Test
    void testLittleCaesarsBuilder() {
        // Arrange
        AbsractDriver.LittleCaesars littleCaesars = new AbsractDriver.LittleCaesars();

        // Act
        Pizza.PizzaBuilder pizzaBuilder = littleCaesars.pizzaBuilder(PizzaSize.SMALL);
        Pizza pizza = pizzaBuilder.build();

        // Assert
        assertNotNull(pizza, "The pizza should not be null");
        assertEquals(PizzaSize.SMALL, pizza.getPizzaSize(), "The pizza size should be SMALL");
        assertEquals(PizzaChainName.LITTLE_CAESARS, pizza.getPizzaChain(), "The pizza chain should be Little Caesars");
    }
}
