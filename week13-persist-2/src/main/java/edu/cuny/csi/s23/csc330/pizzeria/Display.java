package edu.cuny.csi.s23.csc330.pizzeria;

import static java.lang.System.out;

import edu.cuny.csi.s23.csc330.pizzeria.price.PriceCalculator;

import java.util.ArrayList;
import java.util.List;

public class Display {
    public void say(String word) {
        out.println(word);
    }

    public void displayOrder(Order order) {
        out.println("Your order:");

        out.println();
        List<OrderItem> saleOrderItems = order.getOrderItems();
        for (var i = 0; i < saleOrderItems.size(); i++) {
            OrderItem saleOrderItem = saleOrderItems.get(i);
            out.printf(
                    "%d. %s , $%.2f\n",
                    i, saleOrderItem.getDescription(), saleOrderItem.getPrice());

            List<OrderItem> subItems = saleOrderItem.getSubItems();
            for (OrderItem orderItem : subItems) {
                out.printf("  - %s, $%.2f%n", orderItem.getDescription(), orderItem.getPrice());
            }

            out.printf("  - tax: $%.2f%n", saleOrderItem.getSalesTax());
        }

        out.printf("   Total: $%.2f", order.getTotal());
    }

    public void displayMenu(Menu menu, PriceCalculator abstractPriceCalculator) {
        ArrayList<PizzaMenuItem> pizzaMenuItems = menu.getMenuItems();
        for (var i = 0; i < pizzaMenuItems.size(); i++) {
            PizzaMenuItem pizzaMenuItem = pizzaMenuItems.get(i);
            out.printf("%d. %s\n", i, pizzaMenuItem.getPizzaType());
            for (int size : pizzaMenuItem.getSizes()) {
                Pizza pizza = new Pizza(pizzaMenuItem.getPizzaType());
                pizza.setSize(size);
                double price = abstractPriceCalculator.getPrice(pizza);
                out.printf("   %din - $%.2f\n", size, price);
            }
        }
    }
}
