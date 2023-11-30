package Web.Product;

import business.Customer;
import business.Invoice;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class OtpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = request.getServletContext();
        String action = request.getParameter("action");
        String url ="/index.jsp";
        if(action == null) {
            action = "order";
        }
        if (action == "shop") {
            url ="/shop.jsp";
        }
        else if (action == "sendEmail"){
            Customer customer = (Customer) request.getAttribute("customer");
//            String userEmail = customer.getEmail();
            String userEmail = request.getParameter("Email");
            Invoice invoice = (Invoice) customer.getBill();
            // Generate OTP
            String otp = generateOtp();
            // Save OTP in session for verification
            HttpSession session = request.getSession();
            session.setAttribute("otp", otp);
            sendOtpEmail(userEmail, otp);
            response.getWriter().println("OTP sent to " + userEmail);
        }
        servletContext.getRequestDispatcher(url)
                .forward(request, response);
    }
    private String generateOtp() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

    private void sendOtpEmail(String toEmail, String otp) {
        // Your email configuration
        final String username = "fsmile3107@gmail.com";
        final String password = "quan2032003";

        // Set the properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Get the Session object
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("OTP Verification");
            message.setText("Your OTP for email verification is: " + otp);

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}