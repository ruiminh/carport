package web.commands;

import business.entities.Calculator;
import business.entities.Order;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CreateOrderCommand extends CommandProtectedPage {


    public CreateOrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, UserException {

        int carportlenght = Integer.parseInt(request.getParameter("carportlenght"));
        int carportwidth = Integer.parseInt(request.getParameter("carportwidth"));
        int rooftype = Integer.parseInt(request.getParameter("rooftype"));
        int withshed = Integer.parseInt(request.getParameter("withshed"));
        int shedlenght = Integer.parseInt(request.getParameter("shedlenght"));
        int shedwidth = Integer.parseInt(request.getParameter("shedwidth"));

        Order order = new Order(carportlenght,carportwidth,rooftype,shedlenght,shedwidth);
        Calculator calculator = new Calculator();

        calculator.calcCarportFlatRoof(carportlenght,carportwidth,withshed,shedlenght,shedwidth);






        return pageToShow;
    }




}
