package edu.cuny.csi.s23.csc330.pizzeria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PizzaTest {

    @Test
    void pizzaBuilder() {
        Pizza pi =
                new Pizza.PizzaBuilder()
                        .type(PizzaType.PLAIN_CHEESE)
                        .size(8)
                        .crust(Crust.THICK)
                        .toppings("mushroom")
                        .build();

        System.out.println(pi);
    }
}
