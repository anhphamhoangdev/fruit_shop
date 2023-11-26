package business;

import java.util.*;
import java.io.Serializable;
import business.*;
import Data.*;
public class Cart implements Serializable {

    private List<LineItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void setItems(List<LineItem> lineItems) {
        items = lineItems;
    }

    public List<LineItem> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }

    public void addItem(LineItem item, String type) {
        //If the item already exists in the cart, only the quantity is changed.
        String code = item.getItem().getFruitID();
        String update = type.toString();
        int quantity = item.getQuantity();

        if(update.equals("true"))
        {
            for (int i = 0; i < items.size(); i++) {
                LineItem lineItem = items.get(i);
                if (lineItem.getItem().getFruitID().equals(code))
                {
                    lineItem.setQuantity(quantity);
                    return;
                }
            }
        }
        else // add
        {
            for (int i = 0; i < items.size(); i++) {
                LineItem lineItem = items.get(i);
                if (lineItem.getItem().getFruitID().equals(code))
                {
                    lineItem.setQuantity(lineItem.getQuantity() + quantity);
                    return;
                }
            }
            items.add(item); // new
        }
    }

    public void removeItem(LineItem item) {
        String code = item.getItem().getFruitID();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getItem().getFruitID().equals(code)) {
                items.remove(i);
                return;
            }
        }
    }
}