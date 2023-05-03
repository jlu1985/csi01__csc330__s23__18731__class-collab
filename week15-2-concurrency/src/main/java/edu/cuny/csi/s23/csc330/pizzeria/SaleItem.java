package edu.cuny.csi.s23.csc330.pizzeria;

public interface SaleItem {
    enum TaxCategory {
        FOOD,
        NA,
        WING
    }

    int getSize();

    TaxCategory getTaxCategory();
}
