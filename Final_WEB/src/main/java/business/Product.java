package business;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;

@Entity
public class Product {
    @Id
    private String fruitID;

    public String getFruitID() {
        return fruitID;
    }

    public void setFruitID(String fruitID) {
        this.fruitID = fruitID;
    }

    @Basic
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String fruitName) {
        this.description = fruitName;
    }

    @Basic
    private String Origin;

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String fruitType) {
        this.Origin = fruitType;
    }

    @Basic
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    private Date exp;

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }

    @Basic
    private Date dateInput;

    public Date getDateInput() {
        return dateInput;
    }

    public void setDateInput(Date dateInput) {
        this.dateInput = dateInput;
    }


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Admin> admin;

    public Collection<Admin> getAdmin() {
        return admin;
    }

    public void setAdmin(Collection<Admin> admin) {
        this.admin = admin;
    }
}
