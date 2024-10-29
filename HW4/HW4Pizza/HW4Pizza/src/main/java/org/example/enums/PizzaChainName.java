package org.example.enums;

/**
 *
 * @author harshitha
 */
public enum PizzaChainName {
    
    PIZZA_HUT("Pizza Hut"),
    LITTLE_CAESARS("Little Caesars"),
    DOMINOS("Dominos");
    public final String name;

    PizzaChainName(String name) {
        this.name = name;
    }
}