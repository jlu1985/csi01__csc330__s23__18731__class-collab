package edu.cuny.csi.s23.csc330.pizzeria;

import edu.cuny.csi.s23.csc330.pizzeria.price.PriceUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Order {
    private String id;
    private final List<OrderItem> saleOrderItems;

    public Order(String id) {
        this.saleOrderItems = new ArrayList();
    }

    @Override
    public String toString() {
        return "Order{" + "id='" + id + '\'' + ", orderItems=" + saleOrderItems + '}';
    }

    public void add(SaleOrderItem item) {
        this.saleOrderItems.add(item);
    }

    public List<OrderItem> getOrderItems() {
        return new ArrayList(saleOrderItems);
    }

    public Double getTotal() {
        return saleOrderItems.stream()
                .flatMap(
                        item ->
                                Stream.concat(
                                        Stream.of(item),
                                        Stream.ofNullable(item.getSubItems())
                                                .flatMap(List::stream)))
                .collect(
                        Collectors.summingDouble(
                                (i) -> PriceUtils.add(i.getPrice(), i.getSalesTax())));
    }
}
