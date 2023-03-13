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
        ArrayList<OrderItem> orderItems = order.getOrderItems();
        for (var i = 0; i < orderItems.size(); i++) {
            OrderItem orderItem = orderItems.get(i);
            out.printf("%d. %s , $%.2f\n", i, orderItem.getDescription(), orderItem.getPrice());
        }

        out.printf("   Total: $%.2f", order.getTotal());
    }

    public void displayMenu(Menu menu, PriceCalculator priceCalculator) {
        ArrayList<PizzaMenuItem> pizzaMenuItems = menu.getMenuItems();
        for (var i = 0; i < pizzaMenuItems.size(); i++) {
            PizzaMenuItem pizzaMenuItem = pizzaMenuItems.get(i);
            out.printf("%d. %s\n", i, pizzaMenuItem.getPizzaType());
            for (int size : pizzaMenuItem.getSizes()) {
                Pizza pizza = new Pizza(pizzaMenuItem.getPizzaType());
                pizza.setSize(size);
                double price = priceCalculator.getPrice(pizza);
                out.printf("   %din - $%.2f\n", size, price);
            }
        }
    }
}
