package edu.cuny.csi.s23.csc330.pizzeria.price;

import edu.cuny.csi.s23.csc330.pizzeria.SaleItem;

public interface PriceCalculator {
    double getPrice(SaleItem pizza);

    double getSalesTax(SaleItem saleItem);
}
