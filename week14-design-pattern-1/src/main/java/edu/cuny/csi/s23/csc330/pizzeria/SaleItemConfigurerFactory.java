package edu.cuny.csi.s23.csc330.pizzeria;

public interface SaleItemConfigurerFactory {
    SaleItemConfigurer getConfigurer(MenuItem menuItem);
}
