package business.persistence;

import business.entities.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {


    Database database;

    public OrderMapper(Database database) {

        this.database = database;


    }


    public List<Order> getStandardOrder(){
    List<Order> StandardOrderList =new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM Orders";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int customerId = rs.getInt("CustomerId");
                    int quantity = rs.getInt("Quantity");
                    double price = rs.getDouble("price");
                    StandardOrderList.add(new Order(customerId,quantity,price));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return StandardOrderList;
    }










    public void insertOrder(int customerID, int quantity, double price) throws SQLException {
        try (Connection connection = database.connect()) {

            String sql = "INSERT INTO Orders (CustomerId,Quantity,Price) VALUES (?,?,?);";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {

        ps.setInt(1,customerID);
        ps.setInt(2,quantity);
        ps.setDouble(3,price);


            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}