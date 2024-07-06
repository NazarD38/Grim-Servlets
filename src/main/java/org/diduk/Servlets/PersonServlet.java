package org.diduk.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.diduk.Models.Person;
import org.diduk.Services.PersonService;

import java.io.IOException;

import java.util.List;

@WebServlet(name = "personServlet", value = "/person-servlet")
public class PersonServlet extends HttpServlet {

    private final PersonService service = new PersonService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Person> persons = service.getAllPersons();
        request.setAttribute("persons", persons);
        RequestDispatcher dispatcher = request.getRequestDispatcher("person.jsp");
        dispatcher.forward(request, response);
    }
}
