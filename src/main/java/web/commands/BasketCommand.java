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
    private Product product;

    public BasketCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        int carportId = 0;
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));




        





        List<Product> cartList =(List<Product>)request.getServletContext().getAttribute("cartList");


        HttpSession session= request.getSession();

        Basket basket = (Basket) session.getAttribute("basket");
        //session.setAttribute("basket", basket);

        if(basket ==null){
            basket =new Basket();
        }

        Product product1 = getProductFromId(cartList,carportId);
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
