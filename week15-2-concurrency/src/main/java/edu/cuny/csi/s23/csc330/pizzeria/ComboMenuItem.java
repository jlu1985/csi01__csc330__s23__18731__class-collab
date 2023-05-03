package edu.cuny.csi.s23.csc330.pizzeria;

import java.util.List;

public class ComboMenuItem implements MenuItem, SaleItem {
    @Override
    public String toString() {
        return "ComboMenuItem{"
                + "discount="
                + discount
                + ", description='"
                + description
                + '\''
                + ", selections="
                + selections
                + '}';
    }

    private final double discount;
    private final String description;
    private final List<Integer> selections;

    public ComboMenuItem(double v, String pizzaAndWingCombo, List<Integer> es) {
        this.description = pizzaAndWingCombo;
        this.discount = v;
        this.selections = es;
    }

    public List<Integer> getSelections() {
        return selections;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public TaxCategory getTaxCategory() {
        return TaxCategory.NA;
    }
}
