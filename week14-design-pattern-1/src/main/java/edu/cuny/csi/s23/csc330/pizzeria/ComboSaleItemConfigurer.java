package edu.cuny.csi.s23.csc330.pizzeria;

import edu.cuny.csi.s23.csc330.pizzeria.price.PriceCalculator;

public class ComboSaleItemConfigurer implements SaleItemConfigurer {

    private final ComboMenuItem comboMenuItem;

    public ComboSaleItemConfigurer(ComboMenuItem comboMenuItem) {
        this.comboMenuItem = comboMenuItem;
    }

    @Override
    public SaleOrderItem takeOrder(Display display, PriceCalculator priceCalculator) {

        SaleOrderItem saleOrderItem = new SaleOrderItem(comboMenuItem, priceCalculator);

        PriceCalculator discount =
                new PriceCalculator() {
                    @Override
                    public double getPrice(SaleItem pizza) {
                        return priceCalculator.getPrice(pizza) * comboMenuItem.getDiscount();
                    }
                };
        Pizza s = new Pizza(PizzaType.PEPPERONI);
        s.setSize(10);
        saleOrderItem.addSubItem(new SaleOrderItem(s, discount));
        saleOrderItem.addSubItem(new SaleOrderItem(new Wing(10), discount));

        return saleOrderItem;
    }
}
