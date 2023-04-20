package edu.cuny.csi.s23.csc330.pizzeria;

import java.util.ArrayList;

public class Menu {

    private ArrayList<PizzaMenuItem> pizzaMenuItems;

    public ArrayList<PizzaMenuItem> getMenuItems() {
        return pizzaMenuItems;
    }

    public Menu() {
        pizzaMenuItems = new ArrayList<>();
    }

    public PizzaMenuItem get(int choice) {
        if (pizzaMenuItems.size() <= choice) {
            return null;
        }
        return pizzaMenuItems.get(choice);
    }

    public void add(PizzaMenuItem buildPizzaMenu) {
        pizzaMenuItems.add(buildPizzaMenu);
    }

    public PizzaSaleItemConfigurer getConfigurer(int v) {
        PizzaMenuItem pizzaMenuItem = get(v);
        if (pizzaMenuItem == null) {
            return null;
        }
        return new PizzaSaleItemConfigurer(pizzaMenuItem);
    }
}
