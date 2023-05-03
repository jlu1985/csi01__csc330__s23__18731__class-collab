package edu.cuny.csi.s23.csc330.pizzeria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class OrderService {
    private final ArrayList storage = new ArrayList();

    public static void main(String[] args) throws SQLException {
        try (Connection connection =
                DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9001/csc330")) {

            try (PreparedStatement psmt =
                    connection.prepareStatement(
                            """
                    insert into orders (orderid, description, total) values (?,?,?)
                    """)) {
                psmt.setString(1, UUID.randomUUID().toString());
                psmt.setString(2, "pizza from java");
                psmt.setDouble(3, 9.99);
                System.out.println(psmt.execute());
            }

            try (PreparedStatement psmt =
                    connection.prepareStatement("select orderid, description,total from orders")) {

                try (ResultSet resultSet = psmt.executeQuery()) {

                    while (resultSet.next()) {

                        System.out.printf(
                                """
                                        orderid:%s,  description:%s, price:%f
                                        %n""",
                                resultSet.getString("orderid"),
                                resultSet.getString("description"),
                                resultSet.getDouble("total"));
                    }
                }
            }
        }
    }

    public void save(Order order) {
        storage.add(order);
    }

    public ArrayList getOrders(Date date) {
        return new ArrayList(storage);
    }
}
