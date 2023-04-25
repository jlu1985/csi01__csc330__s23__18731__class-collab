package edu.cuny.csi.s23.csc330.pizzeria;

import java.util.ArrayList;
import java.util.List;

public class Pizza implements SaleItem {

    private int size;
    private List<String> toppings;
    private PizzaType type;
    private Crust crust;

    public Pizza() {}

    public Pizza(PizzaType type, int size, Crust crust, List<String> toppings) {
        this.toppings = toppings;
        this.crust = crust;
        this.size = size;
        this.type = type;
    }

    public Pizza(PizzaType type, Crust crust) {
        this.toppings = new ArrayList();

        this.type = type;
        this.crust = crust;
    }

    public Pizza(PizzaType type) {
        this(type, Crust.REGULAR);
    }

    public List<String> getToppings() {
        return toppings;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public PizzaType getType() {
        return type;
    }

    public Crust getCrust() {
        return crust;
    }

    @Override
    public String toString() {
        return "Pizza{"
                + "size="
                + size
                + ", toppings="
                + toppings
                + ", type="
                + type
                + ", crust="
                + crust
                + '}';
    }

    public static class PizzaBuilder {
        Pizza pizza;

        public PizzaBuilder() {
            pizza = new Pizza();
            pizza.toppings = new ArrayList<>();
            pizza.crust = Crust.REGULAR;
        }

        public PizzaBuilder type(PizzaType type) {
            pizza.type = type;
            return this;
        }

        public PizzaBuilder size(int size) {
            pizza.size = size;
            return this;
        }

        public PizzaBuilder crust(Crust crust) {
            pizza.crust = crust;
            return this;
        }

        public PizzaBuilder toppings(String topping) {
            pizza.toppings.add(topping);
            return this;
        }

        public Pizza build() {
            return this.pizza;
        }
    }
}
