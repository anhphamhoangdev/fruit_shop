package Web.Product;

import Data.ProductDB;
import Data.ProductDB.*;
import business.Product;
import jakarta.persistence.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        List<Product> products = ProductDB.getAllProducts();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }
}
