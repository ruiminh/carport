package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class DesignCarportCommand extends CommandUnprotectedPage
{
    private OrderFacade orderFacade;

    public DesignCarportCommand(String pageToShow) {
        super(pageToShow);
        orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException, SQLException {


        int carportWidth = 600;
        int carportLength = 720;
        int carportRoofType = 1;
        int carportWithShed = 1;
        int shedlength = 240;
        int shedwidth = 530;
        //int userId =   what to do
//        if (carportWithShed == 1){
//            shedlength = request.getIntHeader("shedlength");
//            shedwidth = request.getIntHeader("shedwidth");
//        }

        orderFacade.createOrder(10001,carportLength,carportWidth,0,carportRoofType,carportWithShed,shedlength,shedwidth,0,0,"0");

        return "carportDesigned";

    }


}
