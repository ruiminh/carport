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


    public List<Order> getStandardCarport(){
    List<Order> StandardCarportList =new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM Orders";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int carportId = rs.getInt("carportId");
                    int quantity = rs.getInt("Quantity");
                    double price = rs.getDouble("price");
                    StandardCarportList.add(new Order(carportId,quantity,price));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return StandardCarportList;
    }










    public void insertStandardOrder(int carportId, int quantity, double price) throws SQLException {
        try (Connection connection = database.connect()) {

            String sql = "INSERT INTO Orders (carportId,Quantity,Price) VALUES (?,?,?);";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {

        ps.setInt(1,carportId);
        ps.setInt(2,quantity);
        ps.setDouble(3,price);


            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


}