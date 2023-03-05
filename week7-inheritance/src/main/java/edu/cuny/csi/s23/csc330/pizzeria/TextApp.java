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

    public static void main(String[] args) {

        TextApp textApp =
                new TextApp(new Display(), new PriceCalculator(), createMenu(), new OrderService());

        textApp.startBusiness();
    }

    private static Menu createMenu() {
        Pizza pizza = new Pizza(PizzaType.PEPPERONI);
        pizza.addSize(8);
        pizza.addSize(10);
        pizza.addSize(12);

        Pizza hawaiian = new Pizza(PizzaType.HAWAIIAN);
        hawaiian.addSize(8);
        hawaiian.addSize(10);
        hawaiian.addSize(12);

        Pizza speical = new Pizza(PizzaType.SPECIAL);
        speical.addSize(8);
        speical.addSize(10);
        speical.addSize(12);

        Pizza byop = new Pizza(PizzaType.BUILD_YOUR_OWN);
        byop.addSize(8);
        byop.addSize(10);
        byop.addSize(12);
        Menu menu = new Menu(pizza, hawaiian, speical, byop);

        return menu;
    }

    private void startBusiness() {
        Order order = new Order("1");
        while (true) {
            display.displayMenu(menu);
            display.say("Choose item (exit use invalid choice)");
            double v = scanner.nextDouble();
            Pizza pizza = menu.get(v);

            if (pizza == null) {
                display.say("checkout ");
                display.displayOrder(order);
                System.exit(0);
            }
            order.add(new OrderItem(pizza.getType().toString(), priceCalculator.getPrice(pizza)));
            display.displayOrder(order);
        }
    }
}
