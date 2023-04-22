package edu.cuny.csi.s23.csc330.pizzeria;

import edu.cuny.csi.s23.csc330.pizzeria.price.TaxCalculator;

public class ComboMenuItem implements MenuItem, SaleItem {
    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public TaxCalculator.TaxCategory getTaxCategory() {
        return TaxCalculator.TaxCategory.NOT_APPLIED;
    }

    @Override
    public String toString() {
        return "ComboMenuItem{"
                + "discount="
                + discount
                + ", description='"
                + description
                + '\''
                + ", wings="
                + wings
                + ", pizza="
                + pizza
                + '}';
    }

    private final double discount = 0.5;
    private final String description = "";

    private final int wings = 1;
    private final int pizza = 1;

    public String getDescription() {
        return description;
    }

    public double getDiscount() {
        return discount;
    }

    public int getPizza() {
        return pizza;
    }

    public int getWings() {
        return wings;
    }
}
