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


        int standardCarportId;
       String standardCarportName;
       double price;

       standardCarportId = Integer.parseInt(request.getParameter("carportid"));
       standardCarportName = request.getParameter("name");
       price = Double.parseDouble(request.getParameter("price"));


        Order order = orderFacade.addOrder(0,standardCarportId,standardCarportName,0,0,0,0,0,0,0,0,0,"",price);

        HttpSession session = request.getSession(false);

        session.setAttribute("carportid",standardCarportId);
        session.setAttribute("name",standardCarportName);
        session.setAttribute("price",price);





        return "index.jsp";
    }


}

