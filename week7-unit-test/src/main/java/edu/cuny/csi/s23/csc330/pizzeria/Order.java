package edu.cuny.csi.s23.csc330.pizzeria;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Order {
    private String id;

    @Override
    public String toString() {
        return "Order{" + "id='" + id + '\'' + ", orderItems=" + orderItems + '}';
    }

    private ArrayList<OrderItem> orderItems;

    public Order(String id) {
        this.orderItems = new ArrayList();
    }

    public void add(OrderItem item) {
        this.orderItems.add(item);
    }

    public ArrayList getOrderItems() {
        return new ArrayList(orderItems);
    }

    public Double getTotal() {
        return orderItems.stream().collect(Collectors.summingDouble(OrderItem::getPrice));
    }
}
