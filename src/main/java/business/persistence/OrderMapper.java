package business.persistence;

import business.entities.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderMapper {

    Database database;

    public OrderMapper(Database database) {

        this.database = database;


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