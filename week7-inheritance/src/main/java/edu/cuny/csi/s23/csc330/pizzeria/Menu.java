package edu.cuny.csi.s23.csc330.pizzeria;

import java.util.ArrayList;

public class Menu {

    private ArrayList<MenuItem> menuItems;

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    private PriceCalculator priceCalculator;

    public Menu() {
        menuItems = new ArrayList<>();
    }

    public MenuItem get(int choice) {
        if (menuItems.size() <= choice) {
            return null;
        }
        return menuItems.get(choice + 1);
    }

    public void add(MenuItem buildPizzaMenu) {
        menuItems.add(buildPizzaMenu);
    }

    public void setPriceCalculator(PriceCalculator priceCalculator1) {
        this.priceCalculator = priceCalculator1;
    }
}
