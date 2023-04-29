package edu.cuny.csi.s23.csc330.pizzeria;

import edu.cuny.csi.s23.csc330.pizzeria.price.PriceRouterCalculator;
import org.hsqldb.jdbc.JDBCDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class OrderService {
    static {
        try {
            DriverManager.registerDriver(new JDBCDriver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final ArrayList storage = new ArrayList();

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.testInsert();
    }

    public void save(Order order) {

    }

    public void testInsert() {
        Order order = new Order(
                UUID.randomUUID().toString()
        );

        order.add(new SaleOrderItem(new Wing(8), new PriceRouterCalculator()));
        try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9001/csc330")) {
            try (PreparedStatement pstm = connection.prepareStatement("insert into orders (orderid, description, total) values (?,?,?)")) {
                pstm.setString(1, order.getId());
                pstm.setString(2, order.toString());
                pstm.setDouble(3, order.getTotal());
                pstm.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void testGet() {
        try {
            try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9001/csc330")) {
                try (PreparedStatement pstm = connection.prepareStatement("select * from orders");
                     ResultSet rs = pstm.executeQuery()
                ) {
                    while (rs.next()) {
                        String description = rs.getString("description");
                        System.out.println(description);
                    }
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList getOrders(Date date) {
        return new ArrayList(storage);
    }
}
