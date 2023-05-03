package edu.cuny.csi.s23.csc330.pizzeria;

import java.util.ArrayList;

public class Menu {

    private final ArrayList<MenuItem> pizzaMenuItems;

    public Menu() {
        pizzaMenuItems = new ArrayList<>();
    }

    public ArrayList<MenuItem> getMenuItems() {
        return pizzaMenuItems;
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

    public SaleItemConfigurer getConfigurer(int v) {
        MenuItem pizzaMenuItem = get(v);
        if (pizzaMenuItem == null) {
            return null;
        }
        if (pizzaMenuItem instanceof PizzaMenuItem pmi) return new PizzaSaleItemConfigurer(pmi);
        if (pizzaMenuItem instanceof WingMenuItem wmi) {
            return new WingSaleItemConfigurer(wmi);
        }

        if (pizzaMenuItem instanceof ComboMenuItem combo) {
            return new ComboMenuItemConfigurer(combo, new MenuLoader());
        }
        return null;
    }
}
