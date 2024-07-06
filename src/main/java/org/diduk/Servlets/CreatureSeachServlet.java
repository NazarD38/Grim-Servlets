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

@WebServlet(name = "CreatureSeachServlet", value = "/creature-search")
public class CreatureSeachServlet extends HttpServlet {
    private CreatureService service = new CreatureService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name_parameter = request.getParameter("name_parameter");
        String surname_parameter = request.getParameter("surname_parameter");
        String country_parameter = request.getParameter("country_parameter");
        String status_parameter = request.getParameter("status_parameter");
        String type_parameter = request.getParameter("type_parameter");
        String danger_level = request.getParameter("danger_level");

        List<Creature> creatures = service.getCreaturesWithParameters(
                name_parameter,
                surname_parameter,
                country_parameter,
                status_parameter,
                type_parameter,
                danger_level
        );

        if (creatures != null && !creatures.isEmpty()) {
            request.setAttribute("creatures", creatures);
            RequestDispatcher dispatcher = request.getRequestDispatcher("creatures.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
