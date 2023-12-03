package Data;

import business.Invoice;
import business.LineItem;
import business.Product;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportDB {
    public static double total_revenue(){
        double totalrenvune = 0;
        List<Invoice> invoiceList = InvoiceDB.selectInvoice();
        for (Invoice invoice : invoiceList){
            List<LineItem> lineItems = (List<LineItem>) invoice.getLineItem();
            for(LineItem lineItem : lineItems){
                totalrenvune += lineItem.getTotal();
            }
        }
        return totalrenvune;
    }
    public static Product popularProduct(){
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
        return mostPopular;
    }


}
