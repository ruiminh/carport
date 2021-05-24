package web.commands;

import business.exceptions.UserException;
import business.persistence.Database;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public abstract class CommandUnprotectedPage extends Command
{
    public String pageToShow;

    public CommandUnprotectedPage(String pageToShow)
    {
        this.pageToShow = pageToShow;
    }

    public String execute(
            HttpServletRequest request,
            HttpServletResponse response) throws UserException, SQLException {
        return pageToShow;
    }

    protected abstract void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}


