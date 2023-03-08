package edu.cuny.csi.s23.csc330.pizzeria;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PepperoniCalculator extends PriceCalculator {

    public static void main(String[] args) {
        PepperoniCalculator pepperoniCalculator = new PepperoniCalculator();
        for (int size : List.of(8, 10, 12, 14)) {
            Pizza pizza = new Pizza(PizzaType.HAWAIIAN, Crust.THIN);
            pizza.setSize(size);
            double price = pepperoniCalculator.getPrice(pizza);
            System.out.printf("size %d  price %f\n", size, price);
        }
    }

    private final Map<Integer, Double> prices;

    public PepperoniCalculator() {
        super(null, null);
        prices = new HashMap<>();
        prices.put(10, 1.2);
        prices.put(12, 1.4);
        prices.put(14, 1.6);
    }

    public double getPrice(Pizza pizza) {
        return getPrice(pizza.getSize());
    }

    private double getPrice(int size) {
        if (size == 8) {
            return PriceCalculator.BASE_PRICE * 1.1;
        }
        return getPrice(8) * prices.get(size);
    }
}
