package Web.Product;

import Data.ProductDB;
import Data.ProductDB.*;
import business.Product;
import jakarta.persistence.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        ServletContext servletContext = req.getServletContext();
        HttpSession session = req.getSession();
        String url ="/dashboard.jsp";
        if (action == null){
            action = "insertProduct";
        }
        if (action.equals("insertProduct")){
            String name = req.getParameter("NameProduct");
            String price = req.getParameter("Price");
            int priceProduct = Integer.parseInt(price);
            String dateString = req.getParameter("exp");
            Date exp = null;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                exp = dateFormat.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace(); // Handle the parse exception appropriately
            }
            String dateInput = req.getParameter("DateInput");
            Date date = null;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                date = dateFormat.parse(dateInput);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String origin = req.getParameter("Origin");

            Product product = new Product();
            product.setName(name);
            product.setPrice(priceProduct);
            product.setExp(exp);
            product.setDateInput(date);
//            product.setDescription();
            ProductDB.insert(product);

        }
//        else if (action.equals("checkout")) {
//            url = "/checkout.jsp";
//        }
//        else if (action.equals("back")) {
//            // Xóa giỏ hàng hiện tại từ session
//            session.removeAttribute("cart");
//            url = "/index.jsp";
//        }
        servletContext.getRequestDispatcher(url)
                .forward(req, resp);

    }
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
