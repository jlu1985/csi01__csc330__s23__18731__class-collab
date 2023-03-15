package edu.cuny.csi.s23.csc330.pizzeria.price;

import edu.cuny.csi.s23.csc330.pizzeria.Pizza;

public interface PriceCalculator {
    double getPrice(Pizza pizza);
}
