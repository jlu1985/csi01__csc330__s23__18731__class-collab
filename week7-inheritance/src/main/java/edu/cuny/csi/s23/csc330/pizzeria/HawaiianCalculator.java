package edu.cuny.csi.s23.csc330.pizzeria;

import java.util.List;

public class HawaiianCalculator extends PriceCalculator {
    public static void main(String[] args) {
        HawaiianCalculator hawaiianCalculator = new HawaiianCalculator();

        for (int size : List.of(8, 10, 12)) {
            Pizza pizza = new Pizza(PizzaType.HAWAIIAN, Crust.THIN);
            pizza.setSize(size);
            double price = hawaiianCalculator.getPrice(pizza);
            System.out.printf("size %d  price %f\n", size, price);
        }
        ;
    }

    public double getPrice(Pizza pizza) {
        return switch (pizza.getSize()) {
            case 8 -> get8inch();
            case 10 -> get10inch();
            case 12 -> get12inch();
            default -> throw new UnsupportedOperationException("not ok");
        };
    }

    private double get8inch() {
        return PriceCalculator.BASE_PRICE * 1.5;
    }

    private double get10inch() {
        return get8inch() * 1.2;
    }

    private double get12inch() {
        return get8inch() * 1.4;
    }
}
