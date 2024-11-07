package org.example;

public abstract class Topping implements FoodItem {
    protected FoodItem foodItem;
    
    public Topping(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
    
    @Override
    public double getCost() {
        return foodItem.getCost();
    }
    
    @Override
    public String getDescription() {
        return foodItem.getDescription();
    }
}
