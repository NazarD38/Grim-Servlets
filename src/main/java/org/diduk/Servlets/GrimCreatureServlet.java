package org.diduk.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.diduk.Models.GrimCreature;
import org.diduk.Services.GrimService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GrimCreatureServlet",value = "/grim-creature")
public class GrimCreatureServlet extends HttpServlet {

    private GrimService service = new GrimService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String grimNameParameter = request.getParameter("grimName");

        List<GrimCreature> grimCreatures = null;

        if(grimNameParameter!=null){
            grimCreatures=service.getGrimCreatureByGrimName(grimNameParameter);
        }

        if (grimCreatures != null) {
            request.setAttribute("grimCreatures", grimCreatures);
            RequestDispatcher dispatcher = request.getRequestDispatcher("grim.jsp");
            dispatcher.forward(request, response);
        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
