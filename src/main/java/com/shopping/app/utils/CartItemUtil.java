package com.shopping.app.utils;

import com.shopping.app.model.CartItem;

import java.util.function.Predicate;

/**
 * Created by baynescorps on 13/11/2018.
 */
public class CartItemUtil {

    public static Predicate<CartItem> isCartItemNull() {
        return (CartItem cItem)-> (cItem == null);
    }
}
