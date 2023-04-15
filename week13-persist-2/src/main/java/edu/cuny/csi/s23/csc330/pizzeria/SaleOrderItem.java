package edu.cuny.csi.s23.csc330.pizzeria;

import edu.cuny.csi.s23.csc330.pizzeria.price.PriceCalculator;
import java.util.ArrayList;
import java.util.List;

public class SaleOrderItem implements OrderItem {

    private final PriceCalculator priceCalculator;
    private SaleItem saleItem;
    private final List<OrderItem> subItems;

    public SaleOrderItem(SaleItem item, PriceCalculator priceCalculator) {
        this.saleItem = item;
        this.priceCalculator = priceCalculator;
        this.subItems = new ArrayList();
    }

    @Override
    public String getDescription() {
        return saleItem.toString();
    }

    @Override
    public double getPrice() {
        return priceCalculator.getPrice(this.saleItem);
    }

    public double getSalesTax() {
        return priceCalculator.getSalesTax(this.saleItem);
    }

    public void addSubItem(SaleOrderItem subItem) {
        this.subItems.add(subItem);
    }

    public List<OrderItem> getSubItems() {
        return subItems;
    }
}
