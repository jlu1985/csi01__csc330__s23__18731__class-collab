package edu.cuny.csi.s23.csc330.pizzeria;

import edu.cuny.csi.s23.csc330.pizzeria.price.PriceCalculator;

public class ComboSaleItemConfigurer implements SaleItemConfigurer {

    private final ComboMenuItem comboMenuItem;

    public ComboSaleItemConfigurer(ComboMenuItem comboMenuItem) {
        this.comboMenuItem = comboMenuItem;
    }

    @Override
    public SaleOrderItem takeOrder(Display display, PriceCalculator priceCalculator) {

        SaleOrderItem saleOrderItem = new SaleOrderItem(comboMenuItem, priceCalculator);

        PriceCalculator discount =
                new PriceCalculator() {
                    @Override
                    public double getPrice(SaleItem pizza) {
                        return priceCalculator.getPrice(pizza) * comboMenuItem.getDiscount();
                    }
                };

        MenuLoader menuLoader = new MenuLoader();
        try {
            Menu menu = menuLoader.createMenu();

            display.displayMenu(menu, discount);

            int i = display.sayAndGetInt("select a pizza");
            SaleItemConfigurer configurer = menu.getConfigurer(i);

            saleOrderItem.addSubItem(configurer.takeOrder(display, discount));

            display.displayMenu(menu, discount);

            saleOrderItem.addSubItem(
                    menu.getConfigurer(display.sayAndGetInt("select a wing"))
                            .takeOrder(display, discount));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return saleOrderItem;
    }
}
