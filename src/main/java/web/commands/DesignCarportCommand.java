package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        HttpSession session = request.getSession();
        String tempo;
        tempo = request.getParameter("carportlength");
        int carportLength = Integer.parseInt(tempo);

        tempo = request.getParameter("carportwidth");
        int carportWidth = Integer.parseInt(tempo);

        tempo = request.getParameter("withshed");
        int carportWithShed = Integer.parseInt(tempo);

        int carportRoofType = 1;

        int shedlength = 0;         //default noshed - we do this to prevent the null value
        int shedwidth = 0;
        System.out.println(session.getAttribute("customerId"));
        int customerId = (int)session.getAttribute("customerId");
        System.out.println(customerId);

        if(carportWithShed == 1){                                   //there must be a better way, but this solves the input crisis if people dont want a shed, and dont select anything in shedlength and shedwidth.
            tempo = request.getParameter("shedlength");
            shedlength = Integer.parseInt(tempo);
            System.out.println(shedlength);

            tempo = request.getParameter("shedwidth");
            shedwidth = Integer.parseInt(tempo);
            System.out.println(shedwidth);
        }

        orderFacade.createOrder(customerId,carportLength,carportWidth,0,carportRoofType,carportWithShed,shedlength,shedwidth,0,0,"0");


        return "carportDesigned";

    }


}
