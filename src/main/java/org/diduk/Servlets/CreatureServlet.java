package org.diduk.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.diduk.Models.Creature;
import org.diduk.Services.CreatureService;

import java.io.IOException;
import java.util.List;


@WebServlet(name="creatureServlet",value = "/creature-servlet")
public class CreatureServlet extends HttpServlet {

private CreatureService service=new CreatureService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Creature> creature=service.getAllCreatures();


        if (creature!= null) {
            request.setAttribute("creatures", creature);
            RequestDispatcher dispatcher = request.getRequestDispatcher("creatures.jsp");
            dispatcher.forward(request, response);
        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }


    }
}
