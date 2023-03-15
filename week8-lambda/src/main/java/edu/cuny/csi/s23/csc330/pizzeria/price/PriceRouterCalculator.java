package edu.cuny.csi.s23.csc330.pizzeria.price;

import edu.cuny.csi.s23.csc330.pizzeria.Pizza;

public class PriceRouterCalculator implements PriceCalculator {
    @Override
    public double getPrice(Pizza pizza) {
        return switch (pizza.getType()) {
            case PEPPERONI -> new PepperoniCalculatorAbstract().getPrice(pizza);
            case HAWAIIAN -> new HawaiianCalculatorAbstract().getPrice(pizza);
            case SPECIAL -> new SpecialAbstractPriceCalculator().getPrice(pizza);
            case PLAIN_CHEESE -> new PlainCheeseCalculatorAbstract().getPrice(pizza);
            default -> throw new UnsupportedOperationException(
                    "pizza type not found " + pizza.getType());
        };
    }
}
