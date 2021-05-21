package web.commands;

import business.entities.User;
import business.exceptions.UserException;
import business.persistence.OrderMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class AllOrderCommand extends CommandProtectedPage {

    OrderMapper orderMapper;

    public AllOrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }



    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {
        request.setAttribute("orderList", orderMapper.getAllOrders());
        return pageToShow;
    }





}
