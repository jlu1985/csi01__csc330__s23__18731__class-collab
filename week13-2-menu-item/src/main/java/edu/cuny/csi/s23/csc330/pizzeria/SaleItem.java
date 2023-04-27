package edu.cuny.csi.s23.csc330.pizzeria;

import edu.cuny.csi.s23.csc330.pizzeria.price.PriceCalculator;

public interface SaleItem {

    int getSize();

    PriceCalculator getPriceCalculator();
}
