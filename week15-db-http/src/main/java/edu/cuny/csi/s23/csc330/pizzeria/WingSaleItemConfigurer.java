package edu.cuny.csi.s23.csc330.pizzeria;

import edu.cuny.csi.s23.csc330.pizzeria.price.PriceCalculator;

public class WingSaleItemConfigurer implements SaleItemConfigurer {
    private final WingMenuItem wmi;

    public WingSaleItemConfigurer(WingMenuItem wmi) {
        this.wmi = wmi;
    }

    @Override
    public SaleOrderItem takeOrder(Display display, PriceCalculator priceCalculator) {

        int i = display.sayAndGetInt("Select pieces:" + wmi.getSizes());

        return new SaleOrderItem(new Wing(i), priceCalculator);
    }
}
