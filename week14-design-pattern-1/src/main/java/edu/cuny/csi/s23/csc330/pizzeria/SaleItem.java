package edu.cuny.csi.s23.csc330.pizzeria;

import edu.cuny.csi.s23.csc330.pizzeria.price.TaxCalculator;

public interface SaleItem {

    int getSize();

    default TaxCalculator.TaxCategory getTaxCategory() {
        return TaxCalculator.TaxCategory.FOOD;
    }
}
