package org.example;

public class Customer {

    private final String name;
    private final CustomerOrder order;
    private final LoyaltyDiscount loyaltyDiscount;
    
    public Customer(String name, double discountRate) {
        this.name = name;
        this.order = new CustomerOrder();
        this.loyaltyDiscount = new LoyaltyDiscount(discountRate);
    }

    public void addItemToOrder(FoodItem item) {
        order.addItem(item);
    }
    
    public double calculateTotalWithDiscount() {
        double total = order.calculateTotal();
        return loyaltyDiscount.applyDiscount(total);
    }

    public String getName() {
        return name;
    }

    public CustomerOrder getOrder() {
        return order;
    }
}
