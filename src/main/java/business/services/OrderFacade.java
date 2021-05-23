package business.services;

import business.entities.UserOrder;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.sql.SQLException;

public class OrderFacade {
OrderMapper orderMapper;

public OrderFacade(Database database)
    {
        orderMapper = new OrderMapper(database);

    }


    public UserOrder getOrderId(int idOrder) throws SQLException {
    return orderMapper.getOrderId(idOrder);
    }
}
