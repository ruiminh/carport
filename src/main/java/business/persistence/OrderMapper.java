package business.persistence;

import business.entities.Order;
import business.entities.Product;
import business.entities.UserOrder;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    private Object Order;
    private Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }

    public int updateOrder(int idOrder, double price) throws SQLException, UserException {


        try (Connection connection = database.connect()) {

            String sql = "UPDATE orders SET Price =? WHERE idOrder = ?;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setDouble(1, price);
                ps.setInt(2, idOrder);
                int rowsInserted = ps.executeUpdate();
                return rowsInserted;

            }
            catch (SQLException ex)
            {
            throw new UserException("connection not established ");
        }


        }
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

    public UserOrder getOrderId(int idOrder) throws SQLException {


        try (Connection connection = database.connect()) {

            String sql = "SELECT * FROM orders WHERE idOrder = ?;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {


                ps.setInt(1, idOrder);
                ResultSet rs = ps.executeQuery();


                if (rs.next()) {

                    int id = rs.getInt("idOrder");
                    double price = rs.getDouble("price");

                    return new UserOrder(id, price);
                }
                throw new UserException("idorder findes ikke ");


            } catch (UserException e) {
                e.printStackTrace();
            }


        }
        return null;
    }




















    public int DBCreateOrder(int customerId, int length, int width, int incline, int roofTileType, int withShed, int shedLength, int shedWidth, int shedWallType, int shedFloorType, String comments) throws SQLException, UserException {
        int tempOrderId = 1;

        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO orders(`customerId`, `length`, `width`, `incline`, `roofTileType`, `withShed`, `shedLength`, `shedWidth`, `shedWallType`, `shedFloorType`, `comments`) values (?,?,?,?,?,?,?,?,?,?,?);";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, customerId);
                ps.setInt(2, length);
                ps.setInt(3, width);
                ps.setInt(4, incline);
                ps.setInt(5, roofTileType);
                ps.setInt(6, withShed);
                ps.setInt(7, shedLength);
                ps.setInt(8, shedWidth);
                ps.setInt(9, shedWallType);
                ps.setInt(10, shedFloorType);
                ps.setString(11, comments);
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                tempOrderId = ids.getInt(1);

            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException | UserException ex)
        {
            throw new UserException(ex.getMessage());
        }

        return tempOrderId;

    }

    public double DBGetPrice(int materialId) throws SQLException {
        double tempDBprice = 1;

        try (Connection connection = database.connect()) {
            String sql = "SELECT * from Materials WHERE idMaterial = ?;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, materialId);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    tempDBprice = rs.getDouble("`Price per unit/measurement`");


                }




                }


        }


        return tempDBprice;

        // sql statement: SELECT `Price per unit/measurement` from Materials WHERE idMaterial = "?";
    }




    public void DBInsertToBOM(int orderId, int idMaterial, int length, int quantity, double price){

        // sql statement: INSERT INTO BOM(`ìdOrder`,`idMaterial`,`length`,`quantity`,`price`) values (?,?,?,?,?)


    }


    public void dbInsertToBOMOther(int orderId, int idMaterial, int quantity, double price){

        // sql statement: INSERT INTO BOM(`ìdOrder`,`idMaterial`,`quantity`,`price`) values (?,?,?,?)


    }


}



