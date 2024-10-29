package org.example;

import org.example.enums.PizzaSize;

/**
 *
 * @author harshitha
 */
public interface PizzaChain {
    public Pizza.PizzaBuilder pizzaBuilder(PizzaSize size);
}