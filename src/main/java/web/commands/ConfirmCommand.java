package web.commands;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.OrderMapper;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class ConfirmCommand extends CommandUnprotectedPage {

    OrderFacade orderFacade;
    OrderMapper orderMapper;

    public ConfirmCommand(String pageToShow) {
        super(pageToShow);
        orderFacade = new OrderFacade(database);
        orderMapper = new OrderMapper(database);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {


        int orderId = Integer.parseInt(request.getParameter("carportid"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));


        int customerId = 0;
        int length = 0;
        int width = 0;
        int incline = 0;
        int roofTileType = 0;
        int withShed = 0;
        int shedLength = 0;
        int shedWidth = 0;
        int shedWallType = 0;
        int shedFloorType = 0;
        String comments = null;
        Order order = orderMapper.CreateOrder(customerId, length, width,incline, roofTileType,withShed,shedLength,shedWidth,shedWallType,shedFloorType,comments,price);




        return null;
    }


}

