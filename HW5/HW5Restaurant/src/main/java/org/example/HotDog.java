package org.example;

public class HotDog implements FoodItem {
    @Override
    public double getCost() {
        return 3.49;
    }
    
    @Override
    public String getDescription() {
        return "Hot Dog";
    }
}
