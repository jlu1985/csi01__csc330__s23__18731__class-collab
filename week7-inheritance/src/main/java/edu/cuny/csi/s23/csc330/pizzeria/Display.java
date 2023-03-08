package edu.cuny.csi.s23.csc330.pizzeria;

import static java.lang.System.out;

import java.util.ArrayList;

public class Display {
    public void say(String word) {
        out.println(word);
    }

    public void displayOrder(Order order) {
        out.println("Your order:");

        out.println();
        out.println(order.getOrderItems());
    }

    public void displayMenu(Menu menu) {
        ArrayList<PizzaMenuItem> pizzaMenuItems = menu.getMenuItems();
        for (var i = 0; i < pizzaMenuItems.size(); i++) {
            out.printf("%d %s\n", i, pizzaMenuItems.get(i));
        }
    }
}
