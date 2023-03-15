package edu.cuny.csi.s23.csc330.pizzeria.price;

import edu.cuny.csi.s23.csc330.pizzeria.Crust;
import edu.cuny.csi.s23.csc330.pizzeria.Pizza;
import edu.cuny.csi.s23.csc330.pizzeria.PizzaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PepperoniCalculatorAbstract extends AbstractPriceCalculator {

    public static void main(String[] args) {
        PepperoniCalculatorAbstract pepperoniCalculator = new PepperoniCalculatorAbstract();
        for (int size : List.of(8, 10, 12, 14)) {
            Pizza pizza = new Pizza(PizzaType.HAWAIIAN, Crust.THIN);
            pizza.setSize(size);
            double price = pepperoniCalculator.getPrice(pizza);
            System.out.printf("size %d  price %f\n", size, price);
        }
    }

    private final Map<Integer, Double> prices;

    public PepperoniCalculatorAbstract() {
        prices = new HashMap<>();
        prices.put(10, 1.2);
        prices.put(12, 1.4);
        prices.put(14, 1.6);
    }

    @Override
    protected double getPrice(int size) {
        if (size == 8) {
            return AbstractPriceCalculator.BASE_PRICE * 1.1;
        }
        return getPrice(8) * prices.get(size);
    }
}
