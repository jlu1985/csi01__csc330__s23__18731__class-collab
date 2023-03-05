package edu.cuny.csi.s23.csc330.pizzeria;

import java.util.ArrayList;

public class OrderItem {
    private String description;

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

    private double price;

    private ArrayList subItems;

    public OrderItem(String description, double price) {
        this.description = description;
        this.price = price;
        this.subItems = new ArrayList();
    }

    public void addSubItem(OrderItem subItem) {
        this.subItems.add(subItem);
    }
}
