package edu.cuny.csi.s23.csc330.pizzeria.price;

import edu.cuny.csi.s23.csc330.pizzeria.Pizza;
import edu.cuny.csi.s23.csc330.pizzeria.SaleItem;

public class PriceRouterCalculator implements PriceCalculator {
    @Override
    public double getPrice(SaleItem saleItem) {
        return getPriceCalculator(saleItem).getPrice(saleItem);
    }

    @Override
    public double getSalesTax(SaleItem saleItem) {
        return getPriceCalculator(saleItem).getSalesTax(saleItem);
    }

    private PriceCalculator getPriceCalculator(SaleItem saleItem) {
        Pizza pizza = (Pizza) saleItem;
        return switch (pizza.getType()) {
            case PEPPERONI -> new PepperoniCalculatorAbstract();
            case HAWAIIAN -> new HawaiianCalculatorAbstract();
            case SPECIAL -> new SpecialAbstractPriceCalculator();
            case PLAIN_CHEESE -> new PlainCheeseCalculatorAbstract();
            default -> throw new UnsupportedOperationException(
                    "pizza type not found " + pizza.getType());
        };
    }
}
