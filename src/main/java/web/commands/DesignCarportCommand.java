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

//        tempo = request.getParameter("carportRoofType");              returns null, should be replaced with a lookup in database for rooftype later, but we are way behind. - hardcoding value 1 as we only have 1 type of roof at the moment.
//        int carportRoofType = Integer.parseInt(tempo);
//        System.out.println(carportRoofType);
        int carportRoofType = 1;


        if(carportWithShed == 1){                                   //there must be a better way, but this solves the input crisis if people dont want a shed, and dont select anything in shedlength and shedwidth.
            tempo = request.getParameter("shedlength");
            int shedlength = Integer.parseInt(tempo);
            System.out.println(shedlength);

            tempo = request.getParameter("shedwidth");
            int shedwidth = Integer.parseInt(tempo);
            System.out.println(shedwidth);
            orderFacade.createOrder(10001,carportLength,carportWidth,0,carportRoofType,carportWithShed,shedlength,shedwidth,0,0,"0");
        }
        if(carportWithShed == 0){
            int shedlength = 0;
            int shedwidth = 0;
            orderFacade.createOrder(10001,carportLength,carportWidth,0,carportRoofType,carportWithShed,shedlength,shedwidth,0,0,"0");
        }



//






        //int userId =   what to do
//        if (carportWithShed == 1){
//            shedlength = request.getIntHeader("shedlength");
//            shedwidth = request.getIntHeader("shedwidth");
//        }



        return "carportDesigned";

    }


}
