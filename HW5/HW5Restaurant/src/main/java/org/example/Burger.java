package org.example;

public class Burger implements FoodItem {

    @Override
    public double getCost() {
        return 6.00;
    }
    
    @Override
    public String getDescription() {
        return "Burger";
    }
}
