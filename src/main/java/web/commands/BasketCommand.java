package web.commands;

import business.entities.Basket;

import business.entities.Order;
import business.entities.Product;
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
        int carportId;
        String name;
        double price;

        try{
            carportId= Integer.parseInt(request.getParameter("carportId"));
            name= request.getParameter("name");
            price= Double.parseDouble(request.getParameter("price"));
            name = request.getParameter("quantity");


        }catch(NumberFormatException ex){
            throw new UserException("Ingen valgte carporte");
        }

        List<Order> productList =(List<Order>)request.getServletContext().getAttribute("productList");


        HttpSession session= request.getSession();

        Basket basket = (Basket) session.getAttribute("showBasket");
        //session.setAttribute("basket", basket);

        if(basket ==null){
            basket =new Basket();
        }


        Product product = new Product(carportId,name,price);

        basket.addToCart(product);

        session.setAttribute("basket",product);

        return pageToShow;
    }



}
