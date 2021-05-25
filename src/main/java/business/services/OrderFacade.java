package business.services;

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





}
