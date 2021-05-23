package web.commands;

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


        int idOrder = Integer.parseInt(request.getParameter("idOrder"));
        orderFacade.getOrderId(idOrder);
        request.setAttribute("idOrder",idOrder);





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
