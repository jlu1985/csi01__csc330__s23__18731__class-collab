package edu.cuny.csi.s23.csc330.pizzeria;

import java.util.ArrayList;

public class Order {
    private String id;

    @Override
    public String toString() {
        return "Order{" + "id='" + id + '\'' + ", orderItems=" + orderItems + '}';
    }

    private ArrayList orderItems;

    public Order(String id) {
        this.orderItems = new ArrayList();
    }

    public void add(OrderItem item) {
        this.orderItems.add(item);
    }

    public ArrayList getOrderItems() {
        return new ArrayList(orderItems);
    }
}
