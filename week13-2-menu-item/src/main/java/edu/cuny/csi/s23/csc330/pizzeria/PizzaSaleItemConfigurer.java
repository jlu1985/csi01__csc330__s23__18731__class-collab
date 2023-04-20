package edu.cuny.csi.s23.csc330.pizzeria;

public class PizzaSaleItemConfigurer {
    public PizzaSaleItemConfigurer(PizzaMenuItem pizzaMenuItem) {
        this.selectedItem = pizzaMenuItem;
    }

    private PizzaMenuItem selectedItem;

    public SaleItem takeOrder(Display display) {
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
        return pizza1;
    }
}
