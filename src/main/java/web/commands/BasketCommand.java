package web.commands;

import business.entities.Basket;

import business.entities.Order;
import business.entities.Product;
import business.exceptions.UserException;
import business.persistence.ProductMapper;
import business.services.ProductFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class BasketCommand extends CommandUnprotectedPage {

    private ProductMapper productMapper;
    private ProductFacade productFacade;


    public BasketCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        int carportId;
        String name;
        double price;
        int quantity;

        try{
            carportId= Integer.parseInt(request.getParameter("carportId"));
            name= request.getParameter("name");
            price= Double.parseDouble(request.getParameter("price"));



        }catch(NumberFormatException ex){
            throw new UserException("Ingen valgte carporte");
        }

        List<Product> productList =(List<Product>)request.getServletContext().getAttribute("productList");


        HttpSession session= request.getSession();

        Basket basket = (Basket) session.getAttribute("basket");
        //session.setAttribute("basket", basket);

        if(basket ==null){
            basket =new Basket();
        }

        Product product1 = getProductFromId(productList,carportId);
        Product product = new Product(carportId,name,price);

        basket.addToCart(product);

        session.setAttribute("basket",basket);

        return pageToShow;
    }

    private Product getProductFromId(List<Product> productList, int carportId) {
        for(Product product : productList){
            if(product.getCarportId()==carportId){
                return product;

            }
        }
        return null;
    }



}
