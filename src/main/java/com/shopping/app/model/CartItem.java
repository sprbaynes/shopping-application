package com.shopping.app.model;

import com.shopping.app.interfaces.Promotion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by baynescorps on 09/11/2018.
 */
public class CartItem {

    private static final Logger log = LoggerFactory.getLogger(CartItem.class);

    public Item item;
    public double quantity;
    public Promotion promotion;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public double getTotalBeforePromotions(){
        return 0;
    }

    public double getTotalWithPromotions(){
        return 0;
    }
}
