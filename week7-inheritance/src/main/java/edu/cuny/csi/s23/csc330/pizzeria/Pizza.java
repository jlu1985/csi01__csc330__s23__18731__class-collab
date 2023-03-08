package edu.cuny.csi.s23.csc330.pizzeria;

import java.util.ArrayList;

public class Pizza extends MenuItem {
    public ArrayList getToppings() {
        return toppings;
    }

    private int size = 8;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList getSizes() {
        return sizes;
    }

    @Override
    public PizzaType getType() {
        return type;
    }

    public Crust getCrust() {
        return crust;
    }

    private ArrayList toppings;
    private ArrayList sizes;

    private PizzaType type;
    private Crust crust;

    public Pizza(PizzaType type, Crust crust) {
        this.toppings = new ArrayList();
        this.sizes = new ArrayList();
        this.type = type;
        this.crust = crust;
    }

    public Pizza(PizzaType type) {
        this(type, Crust.REGULAR);
    }

    public void addSize(int size) {
        sizes.add(size);
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
