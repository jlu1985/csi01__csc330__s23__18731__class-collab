package edu.cuny.csi.s23.csc330.pizzeria;

public class WingSaleItemConfigurer implements SaleItemConfigurer {
    private final WingMenuItem wmi;

    public WingSaleItemConfigurer(WingMenuItem wmi) {
        this.wmi = wmi;
    }

    @Override
    public SaleItem takeOrder(Display display) {

        int i = display.sayAndGetInt("Select pieces:" + wmi.getSizes());

        return new Wing(i);
    }
}
