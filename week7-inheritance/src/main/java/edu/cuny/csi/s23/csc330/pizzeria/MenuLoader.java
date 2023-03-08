package edu.cuny.csi.s23.csc330.pizzeria;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class MenuLoader {

    public Menu createMenu() throws IOException, URISyntaxException {
        Properties p = new Properties();

        /*
        1. use relative path to -cp
        2. use absolute path to the file
          */
        URL resource = MenuLoader.class.getClassLoader().getResource("menu.properties");
        Path path = Paths.get(resource.toURI());
        System.out.println(path.toAbsolutePath());

        try (FileInputStream fis = new FileInputStream(path.toFile())) {
            p.load(fis);
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println(p);
        int numberOfItmes = Integer.parseInt(p.getProperty("menu.total.size"));
        Menu menu = new Menu();
        for (var i = 0; i < numberOfItmes; i++) {
            menu.add(buildPizzaMenu(p, i));
        }
        return menu;
    }

    private static Pizza buildPizzaMenu(Properties p, int i) {
        String property = p.getProperty(String.format("menu.pizza.%d.type", i));
        PizzaType pizzaType = PizzaType.valueOf(property.trim().toUpperCase());

        String sizeStr = p.getProperty(String.format("menu.pizza.%d.size", i));
        int size = Integer.parseInt(sizeStr);
        Pizza pizza = new Pizza(pizzaType, Crust.REGULAR);
        pizza.addSize(size);
        System.out.println(pizzaType + " property " + property);
        System.out.println(pizza);
        return pizza;
    }
}
