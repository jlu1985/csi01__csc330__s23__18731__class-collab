package edu.cuny.csi.s23.csc330.pizzeria.price;

import org.junit.jupiter.api.Test;

class PriceCalculatorTest {
    @Test
    void testPricing() {

        // (x)-> discountCalculator.getPrice(null)* 1.2;

    }

    public static void main(String[] args) {
        PriceCalculator priceCalculator = (x) -> 10;

        PriceCalculator discount = applyDiscount(priceCalculator);
    }

    private static PriceCalculator applyDiscount(PriceCalculator priceCalculator) {
        PriceCalculator discountCalculator = (x) -> priceCalculator.getPrice(null) * 0.9;

        return discountCalculator;
    }
}
