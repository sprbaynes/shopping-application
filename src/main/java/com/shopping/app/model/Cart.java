package com.shopping.app.model;

import com.shopping.app.interfaces.Promotion;

import java.util.List;

/**
 * Created by baynescorps on 09/11/2018.
 */
public class Cart {

    public Cart(List<Promotion> promotionList)
    {

    }

    public void setItemQuantity(Item item, int quantity)
    {

    }

    public List<CartItem> getCartItems(){
        return null;
    }

    public double getCartTotalBeforePromotions(){
        return 0;
    }

    public double getCartTotalWithPromotions(double cartTotal, double itemTypeTotal){
        return 0;
    }


}
