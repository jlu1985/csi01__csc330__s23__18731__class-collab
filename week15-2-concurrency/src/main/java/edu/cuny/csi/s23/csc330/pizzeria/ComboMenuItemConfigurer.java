package edu.cuny.csi.s23.csc330.pizzeria;

import edu.cuny.csi.s23.csc330.pizzeria.price.PriceCalculator;

public class ComboMenuItemConfigurer implements SaleItemConfigurer {
    private final ComboMenuItem combo;
    private final MenuLoader menuFactory;

    public ComboMenuItemConfigurer(ComboMenuItem combo, MenuLoader menuLoader) {
        this.combo = combo;
        this.menuFactory = menuLoader;
    }

    @Override
    public SaleOrderItem takeOrder(Display display, PriceCalculator priceCalculator) {
        PriceCalculator discount =
                selectedItem -> priceCalculator.getPrice(selectedItem) * combo.getDiscount();
        SaleOrderItem comboSale = new SaleOrderItem(combo, discount);
        for (Integer select : combo.getSelections()) {
            Menu subMenu =
                    switch (select) {
                        case 1 -> menuFactory.createPizzaMenu();
                        case 2 -> menuFactory.createWingMenu();
                        default -> throw new RuntimeException("Invalid selection " + select);
                    };

            display.displayMenu(subMenu, discount);
            int i = display.sayAndGetInt("Select a sub item #" + select);
            SaleOrderItem saleOrderItem = subMenu.getConfigurer(i).takeOrder(display, discount);
            comboSale.addSubItem(saleOrderItem);
        }

        return comboSale;
    }
}
