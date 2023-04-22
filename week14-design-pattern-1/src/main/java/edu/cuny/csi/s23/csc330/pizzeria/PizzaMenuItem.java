package edu.cuny.csi.s23.csc330.pizzeria;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PizzaMenuItem implements MenuItem {
    private PizzaType pizzaType;
    private HashSet<Integer> sizes = new HashSet<>();

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

    public void addSize(int size) {
        sizes.add(size);
    }

    public boolean hasSize(int size) {
        return sizes.contains(size);
    }

    public Set<Integer> getSizes() {
        return Collections.unmodifiableSet(this.sizes);
    }

    @Override
    public String toString() {
        return "PizzaMenuItem{" + "pizzaType=" + pizzaType + ", sizes=" + sizes + '}';
    }
}
