package edu.cuny.csi.s23.csc330.pizzeria;

import edu.cuny.csi.s23.csc330.pizzeria.price.PriceUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private String id;

    @Override
    public String toString() {
        return "Order{" + "id='" + id + '\'' + ", orderItems=" + saleOrderItems + '}';
    }

    private List<OrderItem> saleOrderItems;

    public Order(String id) {
        this.saleOrderItems = new ArrayList();
    }

    public void add(SaleOrderItem item) {
        this.saleOrderItems.add(item);
    }

    public List<OrderItem> getOrderItems() {
        return new ArrayList(saleOrderItems);
    }

    public Double getTotal() {
        return saleOrderItems.stream()
                .collect(
                        Collectors.summingDouble(
                                (i) -> PriceUtils.add(i.getPrice(), i.getSalesTax())));
    }
}
