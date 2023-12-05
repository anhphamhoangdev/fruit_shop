package Controller;

import Data.AdminDB;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String url ="/login.jsp";
        ServletContext sc = request.getServletContext();
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        if(action==null){
            action = "j_security_check";
        }
        if (action.equals("j_security_check")){
            String username =request.getParameter("j_username");
            String pass =request.getParameter("j_password");
            AdminDB adminDB = new AdminDB();
            if (adminDB.login(username,pass) != null){

                session.setAttribute("admin",adminDB.login(username,pass));
                url ="/basic-table.jsp";

            }
            else {
                url ="/login_error.jsp";
            }
        }
        sc.getRequestDispatcher(url)
                .forward(request, response);
    }

}
