package org.example.enums;

public enum Protein {
    FISH("Fish"),
    CHICKEN("Chicken"),
    BEEF("Beef"),
    TOFU("Tofu");

    private final String displayName;

    Protein(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}