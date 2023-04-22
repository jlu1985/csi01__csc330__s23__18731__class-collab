package edu.cuny.csi.s23.csc330.pizzeria;

import edu.cuny.csi.s23.csc330.pizzeria.price.TaxCalculator;

public class Wing implements SaleItem {
    private final int size;

    public Wing(int size) {
        this.size = size;
    }

    @Override
    public TaxCalculator.TaxCategory getTaxCategory() {
        return TaxCalculator.TaxCategory.WING;
    }

    @Override
    public String toString() {
        return "Wing{" + "size=" + size + '}';
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
