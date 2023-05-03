package edu.cuny.csi.s23.csc330.pizzeria;

import static java.lang.System.out;

import edu.cuny.csi.s23.csc330.pizzeria.price.PriceCalculator;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Display {
    private final Scanner in;
    private final PrintStream out;

    public Display() {
        // could remove or keep
        // scaffold code making the code still compile

        this(System.in, System.out);
    }

    public Display(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public void say(String word) {
        out.println(word);
    }

    public int sayAndGetInt(String word) {
        say(word);
        return in.nextInt();
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
        ArrayList<MenuItem> pizzaMenuItems = menu.getMenuItems();
        for (var i = 0; i < pizzaMenuItems.size(); i++) {
            MenuItem menuItem = pizzaMenuItems.get(i);
            if (menuItem instanceof PizzaMenuItem pizzaMenuItem) {
                out.printf("%d. %s\n", i, pizzaMenuItem.getPizzaType());
                for (int size : pizzaMenuItem.getSizes()) {
                    Pizza pizza = new Pizza(pizzaMenuItem.getPizzaType());
                    pizza.setSize(size);
                    double price = abstractPriceCalculator.getPrice(pizza);
                    out.printf("   %din - $%.2f\n", size, price);
                }
            }

            if (menuItem instanceof WingMenuItem wingMenuItem) {
                out.printf("%d, Wings %s\n", i, wingMenuItem.getSizes());
                for (Integer size : wingMenuItem.getSizes()) {
                    out.printf(
                            "   %din - $%.2f\n",
                            size, abstractPriceCalculator.getPrice(new Wing(size)));
                }
            }
            if (menuItem instanceof ComboMenuItem combo) {
                out.printf("%d, Combo %s\n", i, combo);
            }
        }
    }
}
