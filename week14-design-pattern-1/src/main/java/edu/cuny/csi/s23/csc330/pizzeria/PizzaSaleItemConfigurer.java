package edu.cuny.csi.s23.csc330.pizzeria;

import edu.cuny.csi.s23.csc330.pizzeria.price.PriceCalculator;

public class PizzaSaleItemConfigurer implements SaleItemConfigurer {
    private final PizzaMenuItem selectedItem;

    public PizzaSaleItemConfigurer(PizzaMenuItem pizzaMenuItem) {
        this.selectedItem = pizzaMenuItem;
    }

    @Override
    public SaleOrderItem takeOrder(Display display, PriceCalculator priceCalculator) {
        Pizza pizza1 = new Pizza(selectedItem.getPizzaType(), Crust.REGULAR);
        int size;
        boolean valid = false;
        do {
            size = display.sayAndGetInt("Choose a size " + selectedItem.getSizes());
            valid = selectedItem.hasSize(size);
            if (!valid) {
                display.say("invalid size " + size);
            }
        } while (!valid);

        pizza1.setSize(size);
        return new SaleOrderItem(pizza1, priceCalculator);
    }
}
