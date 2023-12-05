import Data.*;
import business.*;

import java.text.ParseException;
import java.util.*;

public class test {
    public static void main(String[] args) throws ParseException {


//        Product product = new Product();
//        product.setName("Strawberry");
//        product.setFruitID("S002");
//        product.setDescription("A juicy, citrus orange");
//        product.setOrigin("Florida, USA");
//        product.setPrice(10);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        product.setExp(dateFormat.parse("2023-12-15"));
//        product.setDateInput(new Date());
//        ProductDB.insert(product);
//        Admin admin = new Admin();
//        admin.setAdminID("ad01");
//        admin.setUserName("admin");
//        admin.setPasswd("123456");
//        AdminDB.insert(admin);


//        LineItem lineItem = new LineItem();
//        lineItem.setLineItemID("L001");
//        lineItem.setQuantity(4);
//        lineItem.setItem(ProductDB.selectProduct("m005"));
//        LineItemDB.insert(lineItem);

//        Product product1 = new Product();
//        String id = product1.getFruitID();
//        product1.setFruitID(id);
//        product1.setFruitID("m328");
//        product1.setDescription("A citrus Strawberry");
//        product1.setOrigin("Flor");
//        product1.setPrice(7);
//        product1.setName("Strawberry");
//        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
//        product1.setExp(dateFormat1.parse("2023-12-15"));
//        product1.setDateInput(new Date());
//        ProductDB.insert(product1);


//        LineItem lineItem1 = new LineItem();
//        lineItem1.setLineItemID("L006");
//        lineItem1.setQuantity(12);
//        lineItem1.setItem(product1);
//        LineItemDB.insert(lineItem1);

//         Cart cart = new Cart();
//         cart.addItem(lineItem, "true");
//        cart.addItem(lineItem1, "false");

//        Customer newCustomer = new Customer();
//        newCustomer.setId("C0012");
//        newCustomer.setName("John Doe");
//        newCustomer.setEmail("john.doe@example.com");
//        newCustomer.setAddress("123 Main St");
//        newCustomer.setCreditCardType("Visa");
//        UserDB.insert(newCustomer);

//        Invoice invoice = new Invoice();
//        invoice.setInvoiceID("INV0001");
//        invoice.setLineItem(cart.getItems());
//        invoice.setCustomer(UserDB.selectUser("C0012"));
//        InvoiceDB.insert(invoice);
//        for (LineItem item : invoice.getLineItem()) {
//            System.out.println("LineItem ID: " + item.getItem());
//        }
//        cart.getItems().stream().map(item -> "LineItem ID: " + item.getItem()).forEach(System.out::println);
//    }
//}
////        Product product = new Product();
////        product.setFruitID("apple123");
////        product.setDescription("Juicy and sweet apple");
////        product.setOrigin("USA");
////        product.setPrice(2);
////        product.setExp(new Date());
////        product.setDateInput(new Date());
////        product.setName("Apple");
////        ProductDB.insert(product);
//
////        LineItem lineItem1 = new LineItem();
////        lineItem1.setLineItemID("L002");
////        lineItem1.setQuantity(4);
////        lineItem1.setProduct(product1);
////       LineItemDB.insert(lineItem1);//
//
//
//
////        Customer newCustomer = new Customer();
////        newCustomer = UserDB.selectUser("C001");
////
////        Invoice invoice = new Invoice();
////        invoice.setInvoiceID("INV-001");
////        invoice.setDate(new Date());
////        invoice.setCustomer(newCustomer);
//
//
//        // Add the LineItem to the Invoice's list of line items
////        List<Product> products = ProductDB.getAllProducts();
////
////        for (Product Item1 : products) {
////            System.out.println("LineItem ID: " + Item1.getFruitID());
//
//
////
////        Collection<LineItem> items = invoice.getLineItem();
////        for (LineItem Item1 : items) {
////            System.out.println("LineItem ID: " + Item1.getLineItemID());
////            System.out.println("Quantity: " + Item1.getQuantity());
////            System.out.println("Product: " + Item1.getProduct().getDescription());
////           System.out.println("Total: " + Item1.getTotalCurrencyFormat());
////            System.out.println("-----------------------");
////
////
////        }
////    }
//}}
        Map<Product, Integer> productIntegerMap = new HashMap<>();
        List<Invoice> invoiceList = InvoiceDB.selectInvoice();
        for (Invoice invoice : invoiceList){
            List<LineItem> lineItems = (List<LineItem>) invoice.getLineItem();
            for(LineItem lineItem : lineItems){
                Product product = lineItem.getItem();
                int quantity = lineItem.getQuantity();
                productIntegerMap.merge(product,quantity,Integer::sum);
            }
        }
        Product mostPopular = null;
        int maxQuantity = 0;
        for (Map.Entry<Product,Integer>entry : productIntegerMap.entrySet()){
            if(entry.getValue()>maxQuantity){
                maxQuantity = entry.getValue();
                mostPopular = entry.getKey();
            }
        }

        System.out.println(mostPopular.getName());


    }
}