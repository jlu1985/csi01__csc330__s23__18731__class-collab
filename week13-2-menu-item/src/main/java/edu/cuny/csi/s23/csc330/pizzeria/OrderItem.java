package edu.cuny.csi.s23.csc330.pizzeria;

import java.util.List;

public interface OrderItem {
    String getDescription();

    double getPrice();

    List<OrderItem> getSubItems();

    double getSalesTax();
}
