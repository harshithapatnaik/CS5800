package org.example;

public class Fries implements FoodItem {
    @Override
    public double getCost() {
        return 2.59;
    }
    
    @Override
    public String getDescription() {
        return "Fries";
    }
}
