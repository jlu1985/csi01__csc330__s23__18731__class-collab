package edu.cuny.csi.s23.csc330.pizzeria;

import edu.cuny.csi.s23.csc330.pizzeria.price.PriceCalculator;
import edu.cuny.csi.s23.csc330.pizzeria.price.WingPriceCalculator;

public class Wing implements SaleItem {
    private final int size;

    public Wing(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Wing{" + "size=" + size + '}';
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public PriceCalculator getPriceCalculator() {
        return new WingPriceCalculator();
    }
}
