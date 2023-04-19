package edu.cuny.csi.s23.csc330.pizzeria;

import java.util.ArrayList;
import java.util.Date;

public class OrderService {
    private ArrayList storage = new ArrayList();

    public void save(Order order) {
        storage.add(order);
    }

    public ArrayList getOrders(Date date) {
        return new ArrayList(storage);
    }
}
