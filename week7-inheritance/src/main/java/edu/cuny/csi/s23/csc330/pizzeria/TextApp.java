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

        PriceCalculator priceCalculator1 =
                new PriceCalculator(new PepperoniCalculator(), new HawaiianCalculator());

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
            MenuItem pizza = menu.get(v);

            if (pizza == null) {
                display.say("checkout ");
                display.displayOrder(order);
                System.exit(0);
            }
            order.add(
                    new OrderItem(
                            pizza.getType().toString(), priceCalculator.getPrice((Pizza) pizza)));
            display.displayOrder(order);
        }
    }
}
