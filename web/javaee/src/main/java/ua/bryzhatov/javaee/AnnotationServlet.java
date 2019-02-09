package ua.bryzhatov.javaee;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Since DefaultServlet 3.0 appeared annotation @WebServlet
 */
@WebServlet("/annotation")
public class AnnotationServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().print("Annotation Servlet (@WebServlet)");
    }
}