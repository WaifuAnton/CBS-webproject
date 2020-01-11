package servlet;

import command.CommandFactory;
import interfaces.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processQuery(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processQuery(req, resp);
    }

    private void processQuery(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommandFactory commandFactory = CommandFactory.getInstance();
        Command command = commandFactory.getCommand(req);
        String page = command.execute(req);
        RequestDispatcher dispatcher = req.getRequestDispatcher(page);
        dispatcher.forward(req, resp);
    }
}
