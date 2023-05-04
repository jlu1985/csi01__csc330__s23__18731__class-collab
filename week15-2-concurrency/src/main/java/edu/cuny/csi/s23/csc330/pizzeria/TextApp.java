package edu.cuny.csi.s23.csc330.pizzeria;

import edu.cuny.csi.s23.csc330.pizzeria.food_service.FoodServiceEndpoint;
import edu.cuny.csi.s23.csc330.pizzeria.price.PriceCalculator;
import edu.cuny.csi.s23.csc330.pizzeria.price.PriceRouterCalculator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class TextApp {
    private final Display display;
    private final PriceCalculator priceCalculator;
    private final Menu menu;
    private final OrderService orderService;

    private final Scanner scanner = new Scanner(System.in);
    private final FoodServiceEndpoint foodServiceEndpoint;

    public TextApp(
            Display display,
            PriceCalculator priceCalculator,
            Menu menu,
            OrderService orderService,
            FoodServiceEndpoint foodServiceEndpoint) {
        this.display = display;
        this.priceCalculator = priceCalculator;
        this.menu = menu;
        this.orderService = orderService;
        this.foodServiceEndpoint = foodServiceEndpoint;
    }

    public static void main(String[] args) throws Exception {
        MenuLoader menuLoader = new MenuLoader();
        Menu menu = menuLoader.createMenu();

        PriceCalculator abstractPriceCalculator1 = new PriceRouterCalculator();

        FoodServiceEndpoint foodService =
                new FoodServiceEndpoint(
                        () -> {
                            ByteArrayOutputStream output = new ByteArrayOutputStream();
                            Display display =
                                    new Display(
                                            new ByteArrayInputStream("".getBytes()),
                                            new PrintStream(output));
                            display.displayMenu(
                                    menu, (x) -> abstractPriceCalculator1.getPrice(x) * 1.5);
                            return output.toString(StandardCharsets.UTF_8);
                        });
        TextApp textApp =
                new TextApp(
                        new Display(),
                        abstractPriceCalculator1,
                        menu,
                        new OrderService(),
                        foodService);

        textApp.startBusiness();
    }

    private void startBusiness() {

        CompletableFuture.runAsync(
                () -> {
                    try {
                        System.out.println("trying to connect food service");
                        foodServiceEndpoint.connect();
                        Thread.sleep(10000);
                        System.out.println("connected");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        // because this is reading from stdin, we have to connect food service before kiosk
        startLocalKiosk();
    }

    private void startLocalKiosk() {

        Order order = new Order("1");
        while (true) {
            display.displayMenu(menu, priceCalculator);
            display.say("Choose item (exit use invalid choice)");
            String nextInput = scanner.next();

            if (nextInput.startsWith("v")) {
                try {
                    foodServiceEndpoint.viewOrder(nextInput.substring(1));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (nextInput.startsWith("a")) {
                try {
                    foodServiceEndpoint.acceptOrder(nextInput.substring(1));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                int v = Integer.parseInt(nextInput);
                SaleItemConfigurer configurer = this.menu.getConfigurer(v);
                if (configurer == null) {
                    display.say("checkout ");
                    display.displayOrder(order);
                    System.exit(0);
                }

                order.add(configurer.takeOrder(display, priceCalculator));
                //            display.displayOrder(order);
            }
        }
    }
}
