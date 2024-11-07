package org.example;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrder {
    private final List<FoodItem> foodItems = new ArrayList<>();

    public void addItem(FoodItem item) {
        foodItems.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (FoodItem item : foodItems) {
            total += item.getCost();
        }
        return total;
    }

    // Getter method to retrieve items
    public List<FoodItem> getItems() {
        return foodItems;
    }
}
