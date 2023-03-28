package edu.cuny.csi.s23.csc330.pizzeria.price;

import edu.cuny.csi.s23.csc330.pizzeria.SaleItem;

public class PlainCheeseCalculatorAbstract extends HawaiianCalculatorAbstract {

    @Override
    public double getPrice(SaleItem pizza) {
        return switch (pizza.getSize()) {
            case 10 -> times1p2(AbstractPriceCalculator.BASE_PRICE);
            case 12 -> times1p4(AbstractPriceCalculator.BASE_PRICE);
            case 14 -> times1p6(AbstractPriceCalculator.BASE_PRICE);
            default -> throw new IllegalStateException("Unexpected value: " + pizza.getSize());
        };
    }
}
