package edu.cuny.csi.s23.csc330.pizzeria;

import java.math.BigDecimal;

public class PriceCalculator {
    public static double BASE_PRICE = 10.0;
    private PepperoniCalculator pepperoniCalculator;
    private HawaiianCalculator hawaiianCalculator;

    public PriceCalculator(
            PepperoniCalculator pepperoniCalculator, HawaiianCalculator hawaiianCalculator) {

        this.pepperoniCalculator = pepperoniCalculator;
        this.hawaiianCalculator = hawaiianCalculator;
    }

    public double getPrice(Pizza pizza) {

        return switch (pizza.getType()) {
            case PEPPERONI -> pepperoniCalculator.getPrice(pizza);
            case HAWAIIAN -> hawaiianCalculator.getPrice(pizza);
            default -> throw new UnsupportedOperationException(
                    "pizza type not found " + pizza.getType());
        };
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
}
