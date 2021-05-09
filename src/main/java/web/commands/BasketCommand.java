package web.commands;

import business.entities.Basket;
import business.entities.Carport;
import business.entities.Order;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class BasketCommand extends CommandUnprotectedPage {

    public BasketCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        int orderId;
        double price;
        int quantity;
        try{
            orderId= Integer.parseInt(request.getParameter("orderId"));
            price= Double.parseDouble(request.getParameter("price"));
            quantity = Integer.parseInt(request.getParameter("quantity"));

        }catch(NumberFormatException ex){
            throw new UserException("Ingen valgte carporte");
        }

        List<Order> standardCarportList =(List<Order>)request.getServletContext().getAttribute("standardCarportList");


        HttpSession session= request.getSession();

        Basket basket = (Basket) session.getAttribute("showBasket");
        //session.setAttribute("basket", basket);

        if(basket ==null){
            basket =new Basket();
        }



       Order order = new Order();

        basket.addToCart(order);

        session.setAttribute("basket",order);

        return pageToShow;
    }



}
