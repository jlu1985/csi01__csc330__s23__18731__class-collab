package edu.cuny.csi.s23.csc330.pizzeria.price;

import edu.cuny.csi.s23.csc330.pizzeria.SaleItem;

public class WingPriceCalculator extends AbstractPriceCalculator {

    @Override
    protected double getPrice(int size) {

        return switch (size) {
            case 5 -> 10;
            case 10 -> 19;
            case 20 -> 19 * 1.8;
            default -> 10;
        };
    }

    @Override
    public double getSalesTax(SaleItem saleItem) {
        return getPrice(saleItem) * 0.085;
    }
}
