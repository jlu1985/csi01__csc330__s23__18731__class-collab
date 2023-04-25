package edu.cuny.csi.s23.csc330.pizzeria.price;

import edu.cuny.csi.s23.csc330.pizzeria.SaleItem;

public class TaxCalculator {
    private TaxCalculator() {}

    private static TaxCalculator singleton;

    public static synchronized TaxCalculator getInstance() {
        if (singleton == null) {
            singleton = new TaxCalculator();
        }
        return singleton;
    }

    public double getSalesTax(SaleItem.TaxCategory taxCategory) {
        return switch (taxCategory) {
            case FOOD -> 0.085;
            case WING -> 0.2;
            default -> throw new NullPointerException(String.valueOf(taxCategory));
        };
    }
}
