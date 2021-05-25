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




















    public int DBCreateOrder(int customerId, int length, int width, int incline, int roofTileType, int withShed, int shedLength, int shedWidth, int shedWallType, int shedFloorType, String comments) throws UserException {

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
                int tempOrderId = ids.getInt(1);
                    //System.out.println(ids);            testet, og det virker den sender det nye orderId tilbage i temporderId

                double totalprice = calcCarportFlatRoof(tempOrderId,length,width,withShed,shedLength,shedWidth);
                System.out.println("totalprice "+totalprice);
                DBUpdatePrice(tempOrderId,totalprice);

                return tempOrderId;




            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }

    }

    public double DBGetPrice(int materialId) throws SQLException {
        double tempDBprice = 1;

        try (Connection connection = database.connect()) {
            String sql = "SELECT * from `Carport`.`Materials` WHERE idMaterial = ?;";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                ps.setInt(1, materialId);
                ps.executeQuery();

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    tempDBprice = rs.getDouble("Price per unit/measurement");


                }

            }


        }


        return tempDBprice;
    }




    public void DBInsertToBOM(int orderId, int idMaterial, int length, int quantity, double price) throws UserException {

        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO BOM(`idOrder`,`idMaterial`,`length`,`quantity`,`price`) values (?,?,?,?,?);";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, orderId);
                ps.setInt(2, idMaterial);
                ps.setInt(3, length);
                ps.setInt(4, quantity);
                ps.setDouble(5, price);
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();

            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public void DBInsertToBOMOther(int orderId, int idMaterial, int quantity, double price){    //for metals


        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO BOM(`idOrder`,`idMaterial`,`quantity`,`price`) values (?,?,?,?);";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, orderId);
                ps.setInt(2, idMaterial);
                ps.setInt(3, quantity);
                ps.setDouble(4, price);
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();

            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException | UserException throwables)
        {
            throwables.printStackTrace();
        }

    }

    public void DBUpdatePrice(int orderId, double totalPrice) throws SQLException {

    try (Connection connection = database.connect()) {
        String sql = "UPDATE orders SET `price` = ? WHERE idOrder = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setDouble(1, totalPrice);
            ps.setInt(2, orderId);
            ps.executeUpdate();
            }
        }
    }


    public double calcCarportFlatRoof(int orderID, int length, int width, int withShed, int shedLength, int shedWidth) throws UserException, SQLException {
        int tempValue;
        int tempQuantity;
        int tempValue2 = 0;     //bruges til at gemme totalt antal af løsholtere, til antal af vinkelbeslag
        double totalPrice = 0;
        double tempPrice;
        int orderId = orderID;

        //1. material (understern front)  - DONE
        tempValue = width / 2 + 1;
        tempQuantity = 4;
        while (tempValue % 30 != 0)
            tempValue = tempValue + 1;
        tempPrice = DBGetPrice(1);
        tempPrice = (tempPrice * tempValue * tempQuantity) / 100;
        DBInsertToBOM(orderId, 1, tempValue, tempQuantity, tempPrice);
        totalPrice = totalPrice + tempPrice;


        //2. material (understern siderne) - DONE
        tempValue = length / 2 + 1;
        tempQuantity = 4;
        while (tempValue % 30 != 0)
            tempValue = tempValue + 1;
        tempPrice = DBGetPrice(2);
        tempPrice = (tempPrice * tempValue * tempQuantity) / 100;
        DBInsertToBOM(orderId, 2, tempValue, tempQuantity, tempPrice);
        totalPrice = totalPrice + tempPrice;


        //3. material (overstern forenden) - DONE
        tempValue = width / 2 + 1;
        tempQuantity = 2;
        while (tempValue % 30 != 0)
            tempValue = tempValue + 1;
        tempPrice = DBGetPrice(3);
        tempPrice = (tempPrice * tempValue * tempQuantity) / 100;
        DBInsertToBOM(orderId, 3, tempValue, tempQuantity, tempPrice);
        totalPrice = totalPrice + tempPrice;

        //4. material (overstern siderne) - DONE
        tempValue = length / 2 + 1;
        tempQuantity = 4;
        while (tempValue % 30 != 0)
            tempValue = tempValue + 1;
        tempPrice = DBGetPrice(4);
        tempPrice = (tempPrice * tempValue * tempQuantity) / 100;
        DBInsertToBOM(orderId, 4, tempValue, 4, tempPrice);
        totalPrice = totalPrice + tempPrice;


        //5. material (Til z på bagside af dør) - DONE
        if (withShed == 1) {
            tempValue = 420;
            tempQuantity = 1;
            tempPrice = DBGetPrice(5);
            tempPrice = (tempPrice * tempValue * tempQuantity) / 100;
            DBInsertToBOM(orderId, 5, tempValue, tempQuantity, tempPrice);
            totalPrice = totalPrice + tempPrice;

        }

        //6. material (løsholder til skur gavle)  - DONE

        if (withShed == 1) {
            tempQuantity = 6;
            if (shedWidth > 330) {
                tempQuantity = 12;
                tempValue = shedWidth / 2 + 1;
                while (tempValue % 30 != 0)
                    tempValue = tempValue + 1;
            }
            tempPrice = DBGetPrice(6);
            tempPrice = (tempPrice * tempValue * tempQuantity) / 100;
            DBInsertToBOM(orderId, 6, tempValue, tempQuantity, tempPrice);
            totalPrice = totalPrice + tempPrice;
            tempValue2 = tempQuantity;

        }

        //7. material (løsholder til skur sider) - DONE

        if (withShed == 1) {
            tempQuantity = 4;
            tempValue = shedLength;
            tempPrice = DBGetPrice(7);
            tempPrice = (tempPrice * tempValue * tempQuantity) / 100;
            DBInsertToBOM(orderId, 7, tempValue, tempQuantity, tempPrice);
            totalPrice = totalPrice + tempPrice;
            tempValue2 = tempValue2 + tempQuantity;

        }

        //8. material (Remme i sider) - DONE

        tempValue = length;
        if (length > 720) {
            tempValue = 600;
        }
        tempQuantity = 2;
        tempPrice = DBGetPrice(8);
        tempPrice = (tempPrice * tempValue * tempQuantity) / 100;
        totalPrice = totalPrice + tempPrice;
        DBInsertToBOM(orderId, 8, tempValue, tempQuantity, tempPrice);


        //9. material (Remme i sider) skal med hvis den er over 720 lang. - DONE

        if (length > 720) {
            tempValue = 390;
            tempQuantity = 1;
            tempPrice = DBGetPrice(9);
            tempPrice = (tempPrice * tempValue * tempQuantity) / 100;
            totalPrice = totalPrice + tempPrice;
            DBInsertToBOM(orderId, 9, tempValue, tempQuantity, tempPrice);

        }


        //10. material (spær) - DONE

        tempValue = width;
        tempQuantity = (length - 5) / 55;          //runder ned, så vi plusser 1
        tempQuantity = tempQuantity + 1;
        tempPrice = DBGetPrice(10);
        tempPrice = (tempPrice * tempValue * tempQuantity) / 100;
        totalPrice = totalPrice + tempPrice;
        DBInsertToBOM(orderId, 10, tempValue, tempQuantity, tempPrice);


        //11. material (stolper) - DONE

        tempQuantity = 4;
        if (length > 550) {
            tempQuantity = 6;
        }
        if (withShed == 1) {
            tempQuantity = 11;
        }
        if (withShed == 1 && width < 330) {
            tempQuantity = 9;
        }
        tempPrice = DBGetPrice(11);
        tempPrice = (tempPrice * 3 * tempQuantity);
        totalPrice = totalPrice + tempPrice;
        DBInsertToBOM(orderId, 11, 300, tempQuantity, tempPrice);


        //12. material (beklædning af skur) - DONE

        if (withShed == 1) {
            tempValue = (shedLength * 2 + shedWidth * 2) / 100;
            tempValue = tempValue * 13;
            tempPrice = DBGetPrice(12);
            tempPrice = (tempPrice * 210 * tempValue) / 100;
            totalPrice = totalPrice + tempPrice;
            DBInsertToBOM(orderId, 12, 210, tempValue, tempPrice);
        }


        //13. material (vandbræt på stern i sider)

        tempValue = width / 2 + 1;
        tempQuantity = 4;
        while (tempValue % 30 != 0)
            tempValue = tempValue + 1;
        tempPrice = DBGetPrice(13);
        tempPrice = (tempPrice * tempValue * tempQuantity) / 100;
        DBInsertToBOM(orderId, 13, tempValue, tempQuantity, tempPrice);
        totalPrice = totalPrice + tempPrice;


        //14. material (vandbræt på stern i forende)

        tempValue = length / 2 + 1;
        tempQuantity = 2;
        while (tempValue % 30 != 0)
            tempValue = tempValue + 1;
        tempPrice = DBGetPrice(14);
        tempPrice = (tempPrice * tempValue * tempQuantity) / 100;
        DBInsertToBOM(orderId, 14, tempValue, tempQuantity, tempPrice);
        totalPrice = totalPrice + tempPrice;


        //15. material (tagplader på spær)  der sender jeg 1 ekstra afsted, er det godt?


        tempValue = length;
        while (tempValue % 30 != 0)
            tempValue = tempValue + 1;
        if (length > 600) {
            tempValue = 600;
        }
        tempQuantity = width / 100;
        tempQuantity = tempQuantity + 1;
        tempPrice = DBGetPrice(15);
        tempPrice = (tempPrice * tempQuantity);
        DBInsertToBOM(orderId, 15, tempValue, tempQuantity, tempPrice);
        totalPrice = totalPrice + tempPrice;


        //16. material (tagplader på spær)   der sender jeg 1 ekstra afsted, er det godt?

        if (length > 600 && length < 720) {
            tempValue = 240;
        } else {
            tempValue = 360;
        }
        tempQuantity = width / 100;
        tempQuantity = tempQuantity + 1;
        tempPrice = DBGetPrice(16);
        tempPrice = (tempPrice * tempQuantity);
        DBInsertToBOM(orderId, 16, tempValue, tempQuantity, tempPrice);
        totalPrice = totalPrice + tempPrice;


        //metals

        //17. material (skruer til tagplader)   DONE

        tempValue = (length * width) / 10000;
        tempValue = tempValue * 12;
        tempValue = (tempValue / 200);
        tempValue = tempValue + 1; //da den runder ned
        tempPrice = DBGetPrice(17);
        tempPrice = tempPrice * tempQuantity;
        DBInsertToBOMOther(orderId, 17, tempValue, tempPrice);
        totalPrice = totalPrice + tempPrice;


        //18. material (hulbånd til vindkryds på spær)  DONE

        tempPrice = DBGetPrice(18);
        tempPrice = tempPrice * 2;
        DBInsertToBOMOther(orderId, 18, 2, tempPrice);
        totalPrice = totalPrice + tempPrice;


        //19. material (montering af spær på rem)   DONE

        tempQuantity = (length - 5) / 55;          //runder ned, så vi plusser 1
        tempQuantity = tempQuantity + 1;
        tempPrice = DBGetPrice(19);
        tempPrice = tempPrice * tempQuantity;
        totalPrice = totalPrice + tempPrice;
        DBInsertToBOMOther(orderId, 19, tempQuantity, tempPrice);


        //20. material (montering af spær på rem)       DONE

        tempQuantity = (length - 5) / 55;          //runder ned, så vi plusser 1
        tempQuantity = tempQuantity + 1;
        tempPrice = DBGetPrice(20);
        tempPrice = tempPrice * tempQuantity;
        totalPrice = totalPrice + tempPrice;
        DBInsertToBOMOther(orderId, 20, tempQuantity, tempPrice);


        //21. material (montering af stærn&vandbrædt)           //altid 1 pakke skruer, fås ikke mindre   DONE

        tempPrice = DBGetPrice(21);
        totalPrice = totalPrice + tempPrice;
        DBInsertToBOMOther(orderId, 21, 1, tempPrice);


        //22. material (Til	montering	af	universalbeslag	+	hulbånd)  //hver gang vi har 1 spær, skal vi bruge ca. 40 skruer   DONE

        tempQuantity = (length - 5) / 55;
        tempQuantity = tempQuantity + 1;
        tempQuantity = (tempQuantity * 40) / 250;
        tempQuantity = tempQuantity + 1;
        tempPrice = DBGetPrice(22);
        tempPrice = tempPrice * tempQuantity;
        totalPrice = totalPrice + tempPrice;
        DBInsertToBOMOther(orderId, 22, tempQuantity, tempPrice);


        //23. material (montering af rem på stolper)                jeg sender 12, de sender 18 ?!?

        tempQuantity = 8;
        if (length > 720) {
            tempQuantity = 20;
        }
        if (length > 550 && length <= 720) {
            tempQuantity = 12;
        }
        tempPrice = DBGetPrice(23);
        tempPrice = tempPrice * tempQuantity;
        totalPrice = totalPrice + tempPrice;
        DBInsertToBOMOther(orderId, 23, tempQuantity, tempPrice);


        //24. material (Til	montering	af	rem	på	stolper) //tror der er fejl i deres tegning.


        tempPrice = DBGetPrice(24);
        tempPrice = tempPrice * tempQuantity;
        totalPrice = totalPrice + tempPrice;
        DBInsertToBOMOther(orderId, 24, tempQuantity, tempPrice);


        //25. material (skruer til montering af ydre beklædning af skur)

        if (withShed == 1) {
            tempQuantity = (shedLength * 2 + shedWidth * 2) / 100;
            tempQuantity = tempQuantity * 13;
            tempQuantity = (tempQuantity / 2) + 1;    //halvdelen af bræderne skal være yderst, så de skal have andre skruer
            tempQuantity = tempQuantity * 6;  //6 skruer per bræt
            tempQuantity = (tempQuantity / 400) + 1;
            tempPrice = DBGetPrice(25);
            tempPrice = tempPrice * tempQuantity;
            DBInsertToBOMOther(orderId, 25, tempQuantity, tempPrice);
            totalPrice = totalPrice + tempPrice;
        }

        //26. material (kruer til montering af indre beklædning af skur)

        if (withShed == 1) {
            tempQuantity = (shedLength * 2 + shedWidth * 2) / 100;
            tempQuantity = tempQuantity * 13;
            tempQuantity = (tempQuantity / 2) + 1;    //halvdelen af bræderne skal være yderst, så de skal have andre skruer
            tempQuantity = tempQuantity * 6;  //6 skruer per bræt
            tempQuantity = (tempQuantity / 300) + 1;
            tempPrice = DBGetPrice(26);
            tempPrice = tempPrice * tempQuantity;
            DBInsertToBOMOther(orderId, 25, tempQuantity, tempPrice);
            totalPrice = totalPrice + tempPrice;
        }


        //27. og 28. material (til skurdør)

        if (withShed == 1) {

            tempPrice = DBGetPrice(27);
            totalPrice = totalPrice + tempPrice;
            DBInsertToBOMOther(orderId, 27, 1, tempPrice);

            tempPrice = DBGetPrice(28);
            tempPrice = tempPrice * 2; //da der er 2 hængsler
            totalPrice = totalPrice + tempPrice;
            DBInsertToBOMOther(orderId, 28, 2, tempPrice);
        }


        //29. material (til montering af løsholter i skur)

        if (withShed == 1) {
            tempQuantity = tempValue2 * 2;
            tempPrice = DBGetPrice(29);
            tempPrice = tempPrice * tempQuantity;
            totalPrice = totalPrice + tempPrice;
            DBInsertToBOMOther(orderId, 29, tempQuantity, tempPrice);
        }

        return totalPrice;


    }

}







