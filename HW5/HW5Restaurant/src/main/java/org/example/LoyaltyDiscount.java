package org.example;

public class LoyaltyDiscount {
    private final double discountRate;
    
    public LoyaltyDiscount(double discountRate) {
        this.discountRate = discountRate;
    }
    
    public double applyDiscount(double totalAmount) {
        return totalAmount * (1 - discountRate);
    }
}
