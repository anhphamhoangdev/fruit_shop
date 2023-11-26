package business;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class LineItem {
    @Id
    private String lineItemID;

    public String getLineItemID() {
        return lineItemID;
    }

    public void setLineItemID(String lineItemID) {
        this.lineItemID = lineItemID;
    }

    @Basic
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Product item;

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }
}
