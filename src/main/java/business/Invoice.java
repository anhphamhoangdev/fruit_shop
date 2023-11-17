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

    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private Collection<LineItem> listlineitem;

    public Collection<LineItem> getListlineitem() {
        return listlineitem;
    }

    public void setListlineitem(Collection<LineItem> listlineitem) {
        this.listlineitem = listlineitem;
    }

    @ManyToOne(optional = false)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
