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

@WebServlet(name = "grimServlet", value = "/grim-servlet")
public class GrimServlet extends HttpServlet {

    private final GrimService service = new GrimService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Grim> grims = service.getAllGrims();

        if (grims != null) {
            request.setAttribute("grims", grims);
            RequestDispatcher dispatcher = request.getRequestDispatcher("grim.jsp");
            dispatcher.forward(request, response);
        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }

    }


}
