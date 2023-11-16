package business;

import jakarta.persistence.*;

import java.util.Collection;

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

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.EAGER, mappedBy = "customer")
    private Collection<Invoice> bill;

    public Collection<Invoice> getBill() {
        return bill;
    }

    public void setBill(Collection<Invoice> bill) {
        this.bill = bill;
    }
}
