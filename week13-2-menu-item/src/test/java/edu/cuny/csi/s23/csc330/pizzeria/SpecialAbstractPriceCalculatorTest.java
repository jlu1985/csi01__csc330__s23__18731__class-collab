package edu.cuny.csi.s23.csc330.pizzeria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.cuny.csi.s23.csc330.pizzeria.price.SpecialAbstractPriceCalculator;

import org.junit.jupiter.api.Test;

class SpecialAbstractPriceCalculatorTest {
    SpecialAbstractPriceCalculator specialPriceCalculator = new SpecialAbstractPriceCalculator();

    private Pizza newPizza(int i) {
        Pizza pizza = new Pizza(PizzaType.SPECIAL);
        pizza.setSize(i);
        return pizza;
    }

    @Test
    void getPrice8() {
        assertEquals(4.99, specialPriceCalculator.getPrice(newPizza(8)));
    }

    @Test
    void getPrice10() {
        assertEquals(12.49, specialPriceCalculator.getPrice(newPizza(10)));
    }

    @Test
    void getPrice14() {
        assertEquals(16.49, specialPriceCalculator.getPrice(newPizza(14)));
    }
}
