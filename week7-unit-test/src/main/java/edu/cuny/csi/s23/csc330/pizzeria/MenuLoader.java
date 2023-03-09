package edu.cuny.csi.s23.csc330.pizzeria;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

public class MenuLoader {

    public Menu createMenu() throws IOException, URISyntaxException {
        Properties p = new Properties();

        /*
        1. use relative path to -cp
        2. use absolute path to the file
          */

        try (InputStream is =
                MenuLoader.class.getClassLoader().getResourceAsStream("menu.properties")) {
            p.load(is);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // System.out.println(p);
        int numberOfItmes = Integer.parseInt(p.getProperty("menu.total.size"));
        Menu menu = new Menu();
        for (var i = 0; i < numberOfItmes; i++) {
            menu.add(buildPizzaMenu(p, i));
        }
        return menu;
    }

    private static PizzaMenuItem buildPizzaMenu(Properties p, int i) {
        String property = p.getProperty(String.format("menu.pizza.%d.type", i));
        PizzaType pizzaType = PizzaType.valueOf(property.trim().toUpperCase());

        String sizeStr = p.getProperty(String.format("menu.pizza.%d.size", i));
        int size = Integer.parseInt(sizeStr);
        PizzaMenuItem pizzaMenuItem = new PizzaMenuItem();
        pizzaMenuItem.setPizzaType(pizzaType);
        pizzaMenuItem.addSize(size);
        //    System.out.println(pizzaMenuItem);
        return pizzaMenuItem;
    }
}
