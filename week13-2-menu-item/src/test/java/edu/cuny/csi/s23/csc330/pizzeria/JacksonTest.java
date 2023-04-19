package edu.cuny.csi.s23.csc330.pizzeria;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.cuny.csi.s23.csc330.pizzeria.price.PriceRouterCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JacksonTest {

    @Test
    void testJackson() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        PriceRouterCalculator priceRouterCalculator = new PriceRouterCalculator();
        Pizza pizza = new Pizza(PizzaType.PEPPERONI);
        pizza.setSize(12);
        SaleOrderItem saleOrderItem = new SaleOrderItem(pizza, priceRouterCalculator);

        String output = objectMapper.writeValueAsString(saleOrderItem);
        Assertions.assertTrue(!output.isEmpty(), output);
    }
}
