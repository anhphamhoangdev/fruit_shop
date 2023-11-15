package business;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;

@Entity
public class Invoice {
    @Id
    private String invoiceID;

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    @Basic
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private LineItem listItems;

    public LineItem getListItems() {
        return listItems;
    }

    public void setListItems(LineItem listItems) {
        this.listItems = listItems;
    }
}
