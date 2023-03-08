package edu.cuny.csi.s23.csc330.pizzeria;

import java.util.Scanner;

public class TextApp {
    private final Display display;
    private final PriceCalculator priceCalculator;
    private final Menu menu;
    private final OrderService orderService;

    private final Scanner scanner = new Scanner(System.in);

    public TextApp(
            Display display,
            PriceCalculator priceCalculator,
            Menu menu,
            OrderService orderService) {
        this.display = display;
        this.priceCalculator = priceCalculator;
        this.menu = menu;
        this.orderService = orderService;
    }

    public static void main(String[] args) throws Exception {
        MenuLoader menuLoader = new MenuLoader();
        Menu menu = menuLoader.createMenu();

        PriceCalculator priceCalculator1 = new PriceCalculator();

        menu.setPriceCalculator(priceCalculator1);

        TextApp textApp = new TextApp(new Display(), priceCalculator1, menu, new OrderService());

        textApp.startBusiness();
    }

    private void startBusiness() {
        Order order = new Order("1");
        while (true) {
            display.displayMenu(menu);
            display.say("Choose item (exit use invalid choice)");
            int v = scanner.nextInt();
            PizzaMenuItem selectedItem = this.menu.get(v);

            if (selectedItem == null) {
                display.say("checkout ");
                display.displayOrder(order);
                System.exit(0);
            }

            PizzaType type = selectedItem.getPizzaType();
            Pizza pizza1 = new Pizza(type, Crust.REGULAR);
            int size;
            boolean valid = false;
            do {
                display.say("Choose a size " + selectedItem.getSizes());
                size = scanner.nextInt();
                valid = selectedItem.hasSize(size);
                if (!valid) {
                    display.say("invalid size " + size);
                }
            } while (!valid);

            pizza1.setSize(size);
            order.add(new OrderItem(pizza1.toString(), priceCalculator.getPrice(pizza1)));
            display.displayOrder(order);
        }
    }
}
