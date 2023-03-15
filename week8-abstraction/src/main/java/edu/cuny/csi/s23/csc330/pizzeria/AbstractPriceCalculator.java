package edu.cuny.csi.s23.csc330.pizzeria;

import java.math.BigDecimal;

public abstract class AbstractPriceCalculator implements PriceCalculator {
    public static double BASE_PRICE = 10.0;

    protected abstract double getPrice(int size);

    @Override
    public double getPrice(Pizza pizza) {
        return getPrice(pizza.getSize());
    }

    protected double times1p2(double price) {
        return multiply(price, 1.2);
    }

    protected double times1p4(double price) {
        return multiply(price, 1.4);
    }

    protected double multiply(double price, double percent) {
        return new BigDecimal(price).multiply(new BigDecimal(percent)).doubleValue();
    }

    protected double times1p6(double basePrice) {
        return multiply(basePrice, 1.6);
    }
}
