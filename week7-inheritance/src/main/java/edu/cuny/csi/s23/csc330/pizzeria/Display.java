package edu.cuny.csi.s23.csc330.pizzeria;

import static java.lang.System.out;

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

        out.println("1." + menu.getPepperoni());
        out.println("2." + menu.getHawaiian());
        out.println("3" + menu.getSpecialty());
        out.println("4" + menu.getBuildYourOwn());
    }
}
