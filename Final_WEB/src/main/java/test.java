import Data.*;
import business.*;
import jakarta.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class test {
    public static void main(String[] args) throws ParseException {

//        Product product = new Product();
//        product.setFruitID("F002");
//        product.setDescription("A juicy, citrus orange");
//        product.setOrigin("Florida, USA");
//        product.setPrice(3);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        product.setExp(dateFormat.parse("2023-12-15"));
//        product.setDateInput(new Date());
//        ProductDB.insert(product);

//        LineItem lineItem = new LineItem();
//        lineItem.setLineItemID("L001");
//        lineItem.setQuantity(4);
//        lineItem.setProduct(product);
/*        LineItemDB.insert(lineItem);*/
//
        Product product1 = new Product();
        product1.setFruitID("F004");
        product1.setDescription("A citrus Strawberry");
        product1.setOrigin("Florida");
        product1.setPrice(7);
        product1.setName("Strawberry");
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        product1.setExp(dateFormat1.parse("2023-12-15"));
        product1.setDateInput(new Date());
        ProductDB.insert(product1);


//        LineItem lineItem1 = new LineItem();
//        lineItem1.setLineItemID("L002");
//        lineItem1.setQuantity(4);
//        lineItem1.setProduct(product1);
//       LineItemDB.insert(lineItem1);//

//        Customer newCustomer = new Customer();
//        newCustomer.setId("C001");
//        newCustomer.setName("John Doe");
////        newCustomer.setEmail("john.doe@example.com");
//        newCustomer.setAddress("123 Main St");
////        newCustomer.setCreditCardType("Visa");
////        newCustomer.setCreditCardNumber("1234-5678-9012-3456");
//        UserDB.insert(newCustomer);

//        Customer newCustomer = new Customer();
//        newCustomer = UserDB.selectUser("C001");
//
//        Invoice invoice = new Invoice();
//        invoice.setInvoiceID("INV-001");
//        invoice.setDate(new Date());
//        invoice.setCustomer(newCustomer);


        // Add the LineItem to the Invoice's list of line items
//        List<Product> products = ProductDB.getAllProducts();
//
//        for (Product Item1 : products) {
//            System.out.println("LineItem ID: " + Item1.getFruitID());


//
//        Collection<LineItem> items = invoice.getLineItem();
//        for (LineItem Item1 : items) {
//            System.out.println("LineItem ID: " + Item1.getLineItemID());
//            System.out.println("Quantity: " + Item1.getQuantity());
//            System.out.println("Product: " + Item1.getProduct().getDescription());
//           System.out.println("Total: " + Item1.getTotalCurrencyFormat());
//            System.out.println("-----------------------");
//
//
//        }
//    }
}}
