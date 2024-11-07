package org.example;

public class Bacon extends Topping {
    public Bacon(FoodItem foodItem) {
        super(foodItem);
    }
    
    @Override
    public double getCost() {
        return super.getCost() + 1.99;
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + ", Bacon";
    }
}
