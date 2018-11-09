package com.shopping.app.model;

import com.shopping.app.interfaces.Promotion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by baynescorps on 09/11/2018.
 */
public class Cart {

    private static final Logger log = LoggerFactory.getLogger(Cart.class);

    public Cart(List<Promotion> promotionList)
    {

    }

    public void setItemQuantity(Item item, int quantity)
    {

    }

    public List<CartItem> getCartItems(){
        return null;
    }

    public CartItem getCartItem(Item item)
    {
        return null;
    }


    public double getCartTotalBeforePromotions(){
        return 0;
    }

    public double getCartTotalWithPromotions(){
        return 0;
    }


}
