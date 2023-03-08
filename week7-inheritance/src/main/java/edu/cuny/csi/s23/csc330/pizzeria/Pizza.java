package edu.cuny.csi.s23.csc330.pizzeria;

import java.util.ArrayList;

public class Pizza extends PizzaMenuItem {
    private int size;
    private final ArrayList toppings;
    private final ArrayList sizes;
    private final PizzaType type;
    private final Crust crust;

    public Pizza(PizzaType type, Crust crust) {
        this.toppings = new ArrayList();
        this.sizes = new ArrayList();
        this.type = type;
        this.crust = crust;
    }

    public Pizza(PizzaType type) {
        this(type, Crust.REGULAR);
    }

    public ArrayList getToppings() {
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
                + "toppings="
                + toppings
                + ", sizes="
                + sizes
                + ", type="
                + type
                + ", crust="
                + crust
                + '}';
    }
}
