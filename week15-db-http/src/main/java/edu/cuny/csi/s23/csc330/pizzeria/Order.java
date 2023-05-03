package edu.cuny.csi.s23.csc330.pizzeria;

import edu.cuny.csi.s23.csc330.pizzeria.price.PriceUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Order {
    private String id;

    @Override
    public String toString() {
        return "Order{" + "id='" + id + '\'' + ", orderItems=" + saleOrderItems + '}';
    }

    private List<OrderItem> saleOrderItems;

    public Order(String id) {
        this.id = id;
        this.saleOrderItems = new ArrayList();
    }

    public String getId() {
        return id;
    }

    public void add(SaleOrderItem item) {
        this.saleOrderItems.add(item);
    }

    public List<OrderItem> getOrderItems() {
        return new ArrayList(saleOrderItems);
    }

    public Double getTotal() {
        return saleOrderItems.stream()
                .flatMap(x -> Stream.concat(Stream.of(x), x.getSubItems().stream()))
                .collect(
                        Collectors.summingDouble(
                                (i) -> PriceUtils.add(i.getPrice(), i.getSalesTax())));
    }
}
