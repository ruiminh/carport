package web.commands;

import business.exceptions.UserException;
import business.persistence.OrderMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class ShowOrderCommand extends CommandProtectedPage {
OrderMapper orderMapper;

    public ShowOrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {

    int idOrder;
    int customerId;
    int length;
    int width;
    int incline;
    int rooftileType;
    int withShed;
    int shedLength;
    int shedWidth;
    double price;
    int quantity;
    String comments;

    idOrder = Integer.parseInt(request.getParameter("idorder"));
    customerId = Integer.parseInt(request.getParameter("customerid"));
    length = Integer.parseInt(request.getParameter("length"));
    width = Integer.parseInt(request.getParameter("width"));
    incline = Integer.parseInt(request.getParameter("incline"));
    rooftileType = Integer.parseInt(request.getParameter("rooftiletype"));
    withShed = Integer.parseInt(request.getParameter("withshed"));
    shedLength = Integer.parseInt(request.getParameter("shedlength"));
    shedWidth = Integer.parseInt(request.getParameter("shedwidth"));
    price = Double.parseDouble(request.getParameter("price"));
    comments = request.getParameter("comments");


    orderMapper.getAllOrders();

      request.setAttribute("idOrder",idOrder);
      request.setAttribute("customerid",customerId);
      request.setAttribute("lenght",length);
      request.setAttribute("width",width);
      request.setAttribute("incline",incline);
      request.setAttribute("rooftiletype",rooftileType);
      request.setAttribute("withshed",withShed);
      request.setAttribute("shedlenght",shedLength);
      request.setAttribute("shedwidth",shedWidth);
      request.setAttribute("price",price);
      request.setAttribute("comments",comments);





        return pageToShow;
    }




}
