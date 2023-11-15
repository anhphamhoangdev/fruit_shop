package business;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    private String contact;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Basic
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Invoice bills;

    public Invoice getBills() {
        return bills;
    }

    public void setBills(Invoice bills) {
        this.bills = bills;
    }
}
