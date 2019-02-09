package ua.bryzhatov.javaee;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lifecycle")
public class LifecycleServlet extends HttpServlet {

    /**
     * When server downloaded servlet it will call this method one time. This method needs
     * for load something files, initial difficult object. Guarantees that this method will
     * end own work before call other method in servlet.
     *
     * @param servletConfig is parameters for initial servlet.
     */
    @Override
    public void init(ServletConfig servletConfig) {
        ServletContext context = servletConfig.getServletContext();
        System.out.println("Init LifecycleServlet.");
    }

    /**
     * In each user request this method will be call. This will may be useful when
     * server create similar answer for user request.
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Service LifecycleServlet.");
        response.getWriter().print("service(): LifecycleServlet answer for user request, " +
                "id session = "+request.getSession().getId());
    }

    /**
     * This method will call when servlet will be unload. It uses for close connection DB,
     * file or other things.
     */
    @Override
    public void destroy() {
        System.out.println("Destroy LifecycleServlet.");
    }
}
