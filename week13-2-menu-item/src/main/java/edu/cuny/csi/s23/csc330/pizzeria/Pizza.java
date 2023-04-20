package edu.cuny.csi.s23.csc330.pizzeria;

import edu.cuny.csi.s23.csc330.pizzeria.price.HawaiianCalculatorAbstract;
import edu.cuny.csi.s23.csc330.pizzeria.price.PepperoniCalculatorAbstract;
import edu.cuny.csi.s23.csc330.pizzeria.price.PlainCheeseCalculatorAbstract;
import edu.cuny.csi.s23.csc330.pizzeria.price.PriceCalculator;
import edu.cuny.csi.s23.csc330.pizzeria.price.SpecialAbstractPriceCalculator;

import java.util.ArrayList;

public class Pizza implements SaleItem {
    private int size;
    private final ArrayList toppings;

    private final PizzaType type;
    private final Crust crust;

    public Pizza(PizzaType type, Crust crust) {
        this.toppings = new ArrayList();

        this.type = type;
        this.crust = crust;
    }

    public Pizza(PizzaType type) {
        this(type, Crust.REGULAR);
    }

    public ArrayList getToppings() {
        return toppings;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public PizzaType getType() {
        return type;
    }

    public Crust getCrust() {
        return crust;
    }

    @Override
    public String toString() {
        return "Pizza{"
                + "size="
                + size
                + ", toppings="
                + toppings
                + ", type="
                + type
                + ", crust="
                + crust
                + '}';
    }

    @Override
    public PriceCalculator getPriceCalculator() {

        return switch (getType()) {
            case PEPPERONI -> new PepperoniCalculatorAbstract();
            case HAWAIIAN -> new HawaiianCalculatorAbstract();
            case SPECIAL -> new SpecialAbstractPriceCalculator();
            case PLAIN_CHEESE -> new PlainCheeseCalculatorAbstract();
            default -> throw new UnsupportedOperationException("pizza type not found " + getType());
        };
    }
}
