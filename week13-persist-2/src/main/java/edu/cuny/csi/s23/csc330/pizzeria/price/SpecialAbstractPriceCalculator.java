package edu.cuny.csi.s23.csc330.pizzeria.price;

import edu.cuny.csi.s23.csc330.pizzeria.Pizza;
import edu.cuny.csi.s23.csc330.pizzeria.PizzaType;

import java.util.List;
import java.util.stream.Stream;

public class SpecialAbstractPriceCalculator extends AbstractPriceCalculator {

    public static void main(String[] args) {
        SpecialAbstractPriceCalculator specialPriceCalculator =
                new SpecialAbstractPriceCalculator();
        for (int i : List.of(8, 10, 12, 14)) {
            Pizza pizza = new Pizza(PizzaType.SPECIAL);
            pizza.setSize(i);
            System.out.println(specialPriceCalculator.getPrice(pizza));
        }

        Stream.of(8, 10, 12, 14)
                .map(
                        i -> {
                            Pizza pizza = new Pizza(PizzaType.SPECIAL);
                            pizza.setSize(i);
                            return pizza;
                        })
                .map(specialPriceCalculator::getPrice)
                .forEach(System.out::println);
    }

    @Override
    public double getPrice(int size) {
        // case 14 -> times1p6(PriceCalculator.BASE_PRICE);
        return switch (size) {
            case 8 -> 4.99;
            case 10 -> times1p2(AbstractPriceCalculator.BASE_PRICE);
            case 12 -> times1p4(AbstractPriceCalculator.BASE_PRICE);
            case 14 -> times1p6(AbstractPriceCalculator.BASE_PRICE);
            default -> throw new IllegalStateException("Unexpected value: " + size);
        };
    }
}
