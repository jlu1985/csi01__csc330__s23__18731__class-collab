package edu.cuny.csi.s23.csc330.pizzeria.price;

import edu.cuny.csi.s23.csc330.pizzeria.ComboMenuItem;
import edu.cuny.csi.s23.csc330.pizzeria.Pizza;
import edu.cuny.csi.s23.csc330.pizzeria.SaleItem;
import edu.cuny.csi.s23.csc330.pizzeria.Wing;

public class PriceRouterCalculator implements PriceCalculator {
    @Override
    public double getPrice(SaleItem saleItem) {
        return getPriceCalculator(saleItem).getPrice(saleItem);
    }

    private PriceCalculator getPriceCalculator(SaleItem saleItem) {
        if (saleItem instanceof Pizza pizza) {
            return switch (pizza.getType()) {
                case PEPPERONI -> new PepperoniCalculatorAbstract();
                case HAWAIIAN -> new HawaiianCalculatorAbstract();
                case SPECIAL -> new SpecialAbstractPriceCalculator();
                case PLAIN_CHEESE -> new PlainCheeseCalculatorAbstract();
                default -> throw new UnsupportedOperationException(
                        "pizza type not found " + pizza.getType());
            };
        }

        if (saleItem instanceof Wing wing) {
            return new WingPriceCalculator();
        }

        if (saleItem instanceof ComboMenuItem) {
            return (x) -> 0;
        }
        return null;
    }
}
