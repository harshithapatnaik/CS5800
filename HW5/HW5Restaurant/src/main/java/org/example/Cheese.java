package org.example;

public class Cheese extends Topping {
    public Cheese(FoodItem foodItem) {
        super(foodItem);
    }
    
    @Override
    public double getCost() {
        return super.getCost() + 0.99;
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + ", Cheese";
    }
}
