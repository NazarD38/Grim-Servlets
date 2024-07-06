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

@WebServlet(name = "personSearchServlet", value = "/person-search")
public class PersonSearchServlet extends HttpServlet {

    private final PersonService service = new PersonService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        String status = request.getParameter("status");

        List<Person> persons = service.getPersonsWithParameters(name, surname,status);


        if (persons != null) {
            request.setAttribute("persons", persons);
            RequestDispatcher dispatcher = request.getRequestDispatcher("person.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
