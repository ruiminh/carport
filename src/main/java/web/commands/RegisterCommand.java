package web.commands;

import business.entities.User;
import business.persistence.Database;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterCommand extends CommandUnprotectedPage
{
    private UserFacade userFacade;

    public RegisterCommand(String pageToShow)
    {
        super(pageToShow);
        userFacade = new UserFacade(database);
    }

    public RegisterCommand(String pageToShow, UserFacade userFacade) {
        super(pageToShow);
        this.userFacade = userFacade;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        String email = request.getParameter("email");
        String name= request.getParameter("name");
        String adress = request.getParameter("adress");
        String city = request.getParameter("city");
        String phone = request.getParameter("phone");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        if (password1.equals(password2))
        {
            User user = userFacade.createUser(email, password1,name,adress,city,phone);
            HttpSession session = request.getSession();

            session.setAttribute("email", email);
            session.setAttribute("name",name);
            session.setAttribute("adress",adress);
            session.setAttribute("city",city);
            session.setAttribute("phone",phone);
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            return user.getRole() + "page";
        }
        else
        {
            request.setAttribute("error", "the two passwords did not match");
            return "registerpage";
        }
    }

}
