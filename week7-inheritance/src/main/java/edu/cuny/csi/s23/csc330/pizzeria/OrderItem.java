package edu.cuny.csi.s23.csc330.pizzeria;

import java.util.ArrayList;

public class OrderItem {
    private final String description;
    private final double price;
    private final ArrayList subItems;

    public OrderItem(String description, double price) {
        this.description = description;
        this.price = price;
        this.subItems = new ArrayList();
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "OrderItem{"
                + "description='"
                + description
                + '\''
                + ", price="
                + price
                + ", subItems="
                + subItems
                + '}';
    }

    public void addSubItem(OrderItem subItem) {
        this.subItems.add(subItem);
    }
}
