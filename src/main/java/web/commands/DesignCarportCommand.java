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
        String tempo;
        tempo = request.getParameter("carportlength");
        int carportLength = Integer.parseInt(tempo);
        System.out.println(carportLength);

        tempo = request.getParameter("carportwidth");
        int carportWidth = Integer.parseInt(tempo);
        System.out.println(carportWidth);

        tempo = request.getParameter("withshed");
        int carportWithShed = Integer.parseInt(tempo);
        System.out.println(carportWithShed);

        tempo = request.getParameter("shedlength");
        int shedlength = Integer.parseInt(tempo);
        System.out.println(shedlength);

        tempo = request.getParameter("shedwidth");
        int shedwidth = Integer.parseInt(tempo);
        System.out.println(shedwidth);

        tempo = request.getParameter("carportRoofType");
        int carportRoofType = Integer.parseInt(tempo);
        System.out.println(carportRoofType);



        //int userId =   what to do
//        if (carportWithShed == 1){
//            shedlength = request.getIntHeader("shedlength");
//            shedwidth = request.getIntHeader("shedwidth");
//        }

        orderFacade.createOrder(10001,carportLength,carportWidth,0,carportRoofType,carportWithShed,shedlength,shedwidth,0,0,"0");

        return "carportDesigned";

    }


}
