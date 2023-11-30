/*

package Web.Product;

import jakarta.servlet.http.HttpServlet;
import Data.InvoiceDB;
import Data.UserDB;
import business.Cart;
import business.Customer;
import business.Invoice;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.*;
import org.eclipse.tags.shaded.org.apache.bcel.classfile.ConstantUtf8;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductforAdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/profile.jsp";
        ServletContext servletContext = getServletContext();
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (action.equals("insert")) {
            String name = request.getParameter("Name");
            String origin = request.getParameter("Origin");
            int price = Integer.parseInt(request.getParameter("Price"));
            String date = request.getParameter("exp");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date exp = formatter.parse(date);
        }
    }
}

*/
