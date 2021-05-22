package web.commands;

import business.exceptions.UserException;
import business.persistence.OrderMapper;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class ShowOrderCommand extends CommandProtectedPage {

    OrderMapper orderMapper;
    private OrderFacade orderFacade;

    public ShowOrderCommand(String pageToShow, String role) {

        super(pageToShow, role);
        orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {


        int idOrder = Integer.parseInt(request.getParameter("idOrder"));

        request.setAttribute("idOrder",idOrder);
        orderFacade.getOrderId(idOrder);




        return pageToShow;
    }




}