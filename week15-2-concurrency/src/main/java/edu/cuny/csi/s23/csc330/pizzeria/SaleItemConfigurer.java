package edu.cuny.csi.s23.csc330.pizzeria;

import edu.cuny.csi.s23.csc330.pizzeria.price.PriceCalculator;

public interface SaleItemConfigurer {

    SaleOrderItem takeOrder(Display display, PriceCalculator priceCalculator);
}
