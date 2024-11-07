package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        restaurantSystem(); // writing this in separate method for unit test case coverage
    }

    // Take orders from customers and generate total cost
    public static void restaurantSystem() {
        RestaurantSystem restaurant = new RestaurantSystem();

        // Add customers with loyalty discounts
        restaurant.addCustomer("Harry", 0.10); // 10% loyalty discount
        restaurant.addCustomer("Adi", 0.15);   // 15% loyalty discount

        // Add items to Harry's order
        restaurant.addItemToCustomerOrder("Harry", new Bacon(new Cheese(new Burger())));
        restaurant.addItemToCustomerOrder("Harry", new Bacon(new Fries()));

        // Add items to Adi's order
        restaurant.addItemToCustomerOrder("Adi", new Cheese(new HotDog()));

        // Display order details for all customers
        for (Customer customer : restaurant.getAllCustomers()) {
            System.out.println("\n=== " + customer.getName() + "'s Order ===");
            displayOrderDetails(customer);
        }
    }

    // Display customer & order details
    protected static void displayOrderDetails(Customer customer) {
        List<FoodItem> items = customer.getOrder().getItems();
        double totalCostBeforeDiscount = 0.0;

        for (FoodItem item : items) {
            System.out.println(" - " + item.getDescription() + " | Cost: $" + String.format("%.2f", item.getCost()));
            totalCostBeforeDiscount += item.getCost();
        }
        System.out.println("Total cost before discount: $" + String.format("%.2f", totalCostBeforeDiscount));

        // Calculate and display total with discount
        double totalWithDiscount = customer.calculateTotalWithDiscount();
        System.out.println("Discounted total: $" + String.format("%.2f", totalWithDiscount));
    }
}
