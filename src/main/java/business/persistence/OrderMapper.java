package business.persistence;

import business.entities.Order;
import business.entities.Product;
import business.entities.UserOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }


    public List<Order> getAllOrders() throws SQLException {


        try (Connection connection = database.connect()) {
            String sql = "SELECT users.id, users.email, Orders.idOrder, Orders.price\n" +
                    "FROM users\n" +
                    "JOIN Orders ON users.id=Orders.idOrder\n" +
                    "where users.id =?;";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                List<Order> orderlist = new ArrayList<>();
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int orderId = rs.getInt("orderId");
                    int customerId = rs.getInt("customerId");
                    int employeeId = rs.getInt("employeeId");
                    int carportlength = rs.getInt("carportlength");
                    int carportwidth = rs.getInt("carportwidth");
                    int withShed = rs.getInt("withShed");
                    int shedlenght = rs.getInt("shedlenght");
                    int shedHight = rs.getInt("shedhight");
                    double price = rs.getDouble("price");
                    boolean isAccepted = rs.getBoolean("isaccepted");


                    orderlist.add(new Order(orderId, customerId, employeeId, carportlength, carportwidth, withShed, shedlenght, shedHight, price, isAccepted));


                }
                return orderlist;

            }


        }
    }

    public List<UserOrder> getUserOrder() throws SQLException {

        List<UserOrder> userOrderList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT users.id, users.email, Orders.idOrder, Orders.price\n" +
                    "FROM users\n" +
                    "JOIN Orders ON users.id=Orders.idOrder\n" +
                    "ORDER BY users.id;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int id = rs.getInt("id");
                    String email = rs.getString("email");
                    int idOrder = rs.getInt("idOrder");
                    double price = rs.getDouble("price");

                    userOrderList.add(new UserOrder(id, email, idOrder, price));

                }
            }
        }

        return userOrderList;
    }

    public int getOrderId(int idOrder) throws SQLException {


        try (Connection connection = database.connect()) {

            String sql = "SELECT * FROM orders WHERE idOrder = ?;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    idOrder = rs.getInt("idOrder");


                }


                return idOrder;
            }


        }
    }
}