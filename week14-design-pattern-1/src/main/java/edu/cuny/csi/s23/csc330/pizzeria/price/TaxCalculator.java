package edu.cuny.csi.s23.csc330.pizzeria.price;

public class TaxCalculator {
    // private state
    public static enum TaxCategory {
        FOOD,
        DRINK,
        WING,
        NOT_APPLIED
    }

    public double getSalesTax(double amount, TaxCategory taxCategory) {
        return switch (taxCategory) {
            case FOOD -> 0.2;
            case DRINK -> 0.1;
            case WING -> 0.15;
            case NOT_APPLIED -> 0;
            default -> throw new NullPointerException("not tax category " + taxCategory);
        };
    }
}
