package org.diduk.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.diduk.Models.Grim;
import org.diduk.Services.GrimService;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "grimSearchServlet", value = "/grim-search")
public class GrimSearchServlet extends HttpServlet {

    private GrimService service = new GrimService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name_parameter = request.getParameter("name");
        String surname_parameter = request.getParameter("surname");
        String country_parameter = request.getParameter("country");
        String status_parameter = request.getParameter("status");
        String sortOption = request.getParameter("sort");

        System.out.println("Received parameters - Name: " + name_parameter + ", Surname: " + surname_parameter + ", Country: " + country_parameter + ", Status: " + status_parameter + ", Sort: " + sortOption);

        List<Grim> grims = service.getGrimWithParameters(name_parameter, surname_parameter, country_parameter, status_parameter);

        if (sortOption != null && !sortOption.isEmpty()) {
            if ("killsASC".equals(sortOption)) {
                grims = service.sortByKillsAsc();
            } else if ("killsDESC".equals(sortOption)) {
                grims = service.sortByKillsDesc();
            }
        }

        if (grims != null && !grims.isEmpty()) {
            request.setAttribute("grims", grims);
            RequestDispatcher dispatcher = request.getRequestDispatcher("grim.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("error", "No results found");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
