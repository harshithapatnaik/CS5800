package org.example.enums;

/**
 *
 * @author harshitha
 */
public enum PizzaSize {

    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");
    public final String size;

    PizzaSize(String size) {
        this.size = size;
    }
}