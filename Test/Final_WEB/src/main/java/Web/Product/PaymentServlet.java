package Web.Product;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@WebServlet("order")
public class PaymentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url="/index.jsp";
        ServletContext servletContext= getServletContext();
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (action == null){ action = "order";}
        if (action.equals("shop")){
            url ="/shop.jsp";
        }
        else if (action.equals("order")){
            String name = request.getParameter("Name");
            String email = request.getParameter("Email");
            String address = request.getParameter("Address");
            String contact = request.getParameter("Phone");
            String moreInfo = request.getParameter("bill");

            Customer customer = new Customer();
            customer.setId(customer.getId());
            customer.setName(name);
            customer.setEmail(email);
            customer.setContact(contact);
            customer.setAddress(address);
            UserDB.insert(customer);
            session.setAttribute("customer",customer);
            Cart cart =(Cart) session.getAttribute("cart");
            Invoice invoice = new Invoice();
            invoice.setInvoiceID(invoice.getInvoiceID());
            invoice.setCustomer(customer);
            invoice.setLineItem(cart.getItems());
            invoice.setDate(new Date());
            invoice.setTotal(cart.totalBillWithoutShip()+ cart.Shipping());
            InvoiceDB.insert(invoice);

//            System.out.println("CusID: " + invoice.getCustomer().getId());
//            System.out.println("Quantity: " + Item1.getQuantity());


        }
        servletContext.getRequestDispatcher(url)
                .forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
