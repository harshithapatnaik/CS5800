package org.example.enums;

public enum Fats {
    AVOCADO("Avocado"),
    SOUR_CREAM("Sour Cream"),
    TUNA("Tuna"),
    PEANUTS("Peanuts");

    private final String displayName;

    Fats(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}