package edu.cuny.csi.s23.csc330.pizzeria;

import java.util.ArrayList;

public class Menu {

    private ArrayList<MenuItem> pizzaMenuItems;

    public ArrayList<MenuItem> getMenuItems() {
        return pizzaMenuItems;
    }

    public Menu() {
        pizzaMenuItems = new ArrayList<>();
    }

    public MenuItem get(int choice) {
        if (pizzaMenuItems.size() <= choice) {
            return null;
        }
        return pizzaMenuItems.get(choice);
    }

    public void add(MenuItem buildPizzaMenu) {
        pizzaMenuItems.add(buildPizzaMenu);
    }

    public PizzaSaleItemConfigurer getConfigurer(int v) {
        MenuItem pizzaMenuItem = get(v);
        if (pizzaMenuItem == null) {
            return null;
        }
        if (pizzaMenuItem instanceof PizzaMenuItem pmi) return new PizzaSaleItemConfigurer(pmi);
        if (pizzaMenuItem instanceof WingMenuItem wmi) {
            throw new NullPointerException();
        }
        return null;
    }
}
