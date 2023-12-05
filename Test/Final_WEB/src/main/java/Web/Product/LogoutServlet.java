package Web.Product;

import business.Admin;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String url ="/login.jsp";
        ServletContext sc = request.getServletContext();
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (action.equals("Logout")) {


            // Get the session
            session = request.getSession();

            // Remove the "admin" attribute from the session
            session.removeAttribute("admin");

            // Invalidate the session
            session.invalidate();

        }
        sc.getRequestDispatcher(url)
                .forward(request, response);
    }
}
