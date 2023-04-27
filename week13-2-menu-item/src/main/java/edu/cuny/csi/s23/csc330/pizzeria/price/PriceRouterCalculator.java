package edu.cuny.csi.s23.csc330.pizzeria.price;

import edu.cuny.csi.s23.csc330.pizzeria.SaleItem;

public class PriceRouterCalculator implements PriceCalculator {
    @Override
    public double getPrice(SaleItem saleItem) {
        return getPriceCalculator(saleItem).getPrice(saleItem);
    }

    @Override
    public double getSalesTax(SaleItem saleItem) {
        return getPriceCalculator(saleItem).getSalesTax(saleItem);
    }

    private PriceCalculator getPriceCalculator(SaleItem saleItem) {

        return saleItem.getPriceCalculator();
    }
}
