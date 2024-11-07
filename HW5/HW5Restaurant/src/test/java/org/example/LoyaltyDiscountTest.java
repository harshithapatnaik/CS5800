package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoyaltyDiscountTest {

    @Test
    // Test with 10% discount
    public void testApplyDiscount() {
        LoyaltyDiscount loyaltyDiscount = new LoyaltyDiscount(0.10);
        double discountedTotal = loyaltyDiscount.applyDiscount(100.0);
        assertEquals(90.0, discountedTotal, 0.01);  // Expected: 100 - (100 * 0.10) = 90.0
    }

    @Test
    // Test with 0% discount
    public void testApplyDiscountWithZeroDiscountRate() {
        LoyaltyDiscount loyaltyDiscount = new LoyaltyDiscount(0.0);
        double discountedTotal = loyaltyDiscount.applyDiscount(100.0);
        assertEquals(100.0, discountedTotal, 0.01);
    }

    @Test
    // Test with 100% discount
    public void testApplyDiscountWithFullDiscountRate() {
        LoyaltyDiscount loyaltyDiscount = new LoyaltyDiscount(1.0);
        double discountedTotal = loyaltyDiscount.applyDiscount(100.0);
        assertEquals(0.0, discountedTotal, 0.01);
    }
}
