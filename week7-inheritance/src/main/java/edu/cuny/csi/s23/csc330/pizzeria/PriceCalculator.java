package edu.cuny.csi.s23.csc330.pizzeria;

public class PriceCalculator {
    public static double BASE_PRICE = 10.0;
    private PepperoniCalculator pepperoniCalculator;
    private HawaiianCalculator hawaiianCalculator;

    public PriceCalculator() {
        pepperoniCalculator = new PepperoniCalculator();
        hawaiianCalculator = new HawaiianCalculator();
    }

    public double getPrice(Pizza pizza) {

        return switch (pizza.getType()) {
            case PEPPERONI -> pepperoniCalculator.getPrice(pizza);
            case HAWAIIAN -> hawaiianCalculator.getPrice(pizza);
            default -> throw new UnsupportedOperationException(
                    "pizza type not found " + pizza.getType());
        };
    }
}
