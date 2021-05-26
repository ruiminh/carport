package business.services;

import business.entities.Order;
import business.entities.UserOrder;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.sql.SQLException;
import java.util.List;

public class OrderFacade {
OrderMapper orderMapper;

public OrderFacade(Database database)
    {
        orderMapper = new OrderMapper(database);

    }

public List<UserOrder> getuserOrder() throws SQLException {
    return orderMapper.getUserOrder();
}

    public UserOrder getOrderId(int idOrder) throws SQLException {
    return orderMapper.getOrderId(idOrder);
    }

    public int updateOrder(int idOrder, double price) throws SQLException, UserException {
    return orderMapper.updateOrder(idOrder,price);
    }

    public void createOrder(int customerId, int length, int width, int incline, int roofTileType, int withShed, int shedLength, int shedWidth, int shedWallType, int shedFloorType, String comments) throws UserException, SQLException {
        orderMapper.DBCreateOrder(customerId,length,width,incline,roofTileType,withShed,shedLength,shedWidth,shedWallType,shedFloorType,comments);
    }

    public double DBgetPrice(int materialId) throws SQLException {
        return orderMapper.DBGetPrice(materialId);
    }

    public void insertIntoBOM(int orderId, int idMaterial, int length, int quantity, double price) throws UserException {
        orderMapper.DBInsertToBOM(orderId, idMaterial, length, quantity, price);
    }

    public void insertIntoBOMOther(int orderId, int idMaterial, int quantity, double price) throws UserException {
        orderMapper.DBInsertToBOMOther(orderId,idMaterial,quantity,price);
    }

    public void updatePrice(int orderId, double totalPrice) throws SQLException {
        orderMapper.DBUpdatePrice(orderId,totalPrice);
    }


    public Order addOrder(int customerId, int standardCarportId, String standardCarportName, int length, int width, int incline, int roofTileType, int withShed, int shedLength, int shedWidth, int shedWallType, int shedFloorType, String comments, Double price) throws SQLException {
    Order order = new Order(0,0,0,standardCarportId,standardCarportName,0,0,0,0,0,0,0,0,0,0,0,price,"",false,false);
        orderMapper.CreateOrder(order);
        return order;
}


}
