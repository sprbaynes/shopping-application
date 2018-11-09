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
    public int quantity;
    public Promotion promotion;

    public CartItem(Item item, int quantity, Promotion promotion) {
        this.item = item;
        this.quantity = quantity;
        this.promotion = promotion;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
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
