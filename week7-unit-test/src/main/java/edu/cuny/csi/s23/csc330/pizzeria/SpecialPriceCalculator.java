package edu.cuny.csi.s23.csc330.pizzeria;

public class SpecialPriceCalculator extends PriceCalculator {

    @Override
    public double getPrice(Pizza pizza) {
        return switch (pizza.getSize()) {
            case 8 -> 4.99;
            case 10 -> times1p2(PriceCalculator.BASE_PRICE);
            case 12 -> times1p4(PriceCalculator.BASE_PRICE);
                // case 14 -> times1p6(PriceCalculator.BASE_PRICE);
            default -> throw new IllegalStateException("Unexpected value: " + pizza.getSize());
        };
    }
}
