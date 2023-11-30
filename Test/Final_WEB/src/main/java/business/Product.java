package business;

import jakarta.persistence.*;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.Date;

@Entity
public class Product {
    @Id
    private String fruitID;


    @Basic
    private String description;


    @Basic
    private String Origin;



    @Basic
    private Integer price;



    @Basic
    private Date exp;


    @Basic
    private Date dateInput;




    @Basic
    private String name;

    public String getFruitID() {
        return fruitID;
    }

    public void setFruitID(String fruitID) {
        this.fruitID = fruitID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }

    public Date getDateInput() {
        return dateInput;
    }

    public void setDateInput(Date dateInput) {
        this.dateInput = dateInput;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
}
