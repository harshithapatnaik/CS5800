package org.example.enums;

public enum Carbs {
    CHEESE("Cheese"),
    BREAD("Bread"),
    LENTILS("Lentils"),
    PISTACHIO("Pistachio");

    private final String displayName;

    Carbs(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}