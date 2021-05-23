package web.commands;

import business.entities.Basket;
import business.entities.Product;
import business.entities.UserOrder;
import business.exceptions.UserException;
import business.persistence.OrderMapper;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class ShowOrderCommand extends CommandProtectedPage {

    OrderMapper orderMapper;
    private OrderFacade orderFacade;

    public ShowOrderCommand(String pageToShow, String role) {

        super(pageToShow, role);
        orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {

        String editId = request.getParameter("edit");


        if (editId != null){

            request.setAttribute("orderitem",orderFacade.getOrderId(Integer.parseInt(editId)));

            return "showOrder";
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
