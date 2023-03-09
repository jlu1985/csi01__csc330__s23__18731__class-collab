package edu.cuny.csi.s23.csc330.pizzeria;

public class PlainCheeseCalculator extends HawaiianCalculator {

    @Override
    public double getPrice(Pizza pizza) {
        return switch (pizza.getSize()) {
            case 10 -> times1p2(PriceCalculator.BASE_PRICE);
            case 12 -> times1p4(PriceCalculator.BASE_PRICE);
            case 14 -> times1p6(PriceCalculator.BASE_PRICE);
            default -> throw new IllegalStateException("Unexpected value: " + pizza.getSize());
        };
    }

    protected double times1p6(double basePrice) {
        return multiply(basePrice, 1.6);
    }
}
