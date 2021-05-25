package web.commands;

import business.entities.Basket;
import business.entities.Product;
import business.entities.UserOrder;
import business.exceptions.UserException;
import business.persistence.OrderMapper;
import business.services.OrderFacade;
import business.services.UserFacade;
import com.sun.org.apache.xerces.internal.impl.io.Latin1Reader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ShowOrderCommand extends CommandUnprotectedPage {

    OrderMapper orderMapper;
    private OrderFacade orderFacade;

    public ShowOrderCommand(String pageToShow)
    {
        super(pageToShow);
        orderFacade = new OrderFacade(database);
    }

    public ShowOrderCommand(String pageToShow, OrderFacade orderFacade) {
        super(pageToShow);
        this.orderFacade= orderFacade;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {

        String editId = request.getParameter("edit");
        String update = request.getParameter("update");



        if (editId != null){

            UserOrder userOrder = orderFacade.getOrderId(Integer.parseInt(editId));
           request.setAttribute("orderItem",userOrder);

           return "showOrder";

        } else if (update != null){
            String idOrder = request.getParameter("idOrder");
            String price = request.getParameter("price");


           int rowsInserted = orderFacade.updateOrder(Integer.parseInt(idOrder),Double.parseDouble(price));



           if(rowsInserted==1){
               request.getServletContext().setAttribute("userOrderList",orderFacade.getuserOrder());

           }




        }


        return pageToShow;
    }


    private UserOrder getOrderFromId(List<UserOrder> UserOrderList, int idOrder) {
        for(UserOrder userOrder : UserOrderList){
            if(userOrder.getIdOrder()==idOrder){
                return userOrder;

            }
        }
        return null;
    }




}
