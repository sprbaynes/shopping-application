package com.shopping.app.model;

import com.shopping.app.interfaces.Promotion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baynescorps on 09/11/2018.
 */
public class Cart {

    private static final Logger log = LoggerFactory.getLogger(Cart.class);

    List<CartItem> cartItemsList;
    List<Promotion> promotionList;

    public Cart(List<Promotion> promotionList)
    {
        this.promotionList = promotionList;
        this.cartItemsList = new ArrayList<>();
    }

    public void setItemQuantity(Item item, int quantity)
    {
        log.debug("About to add/update item in cart");

        CartItem cartItem = getCartItem(item);

        if(cartItem == null)
        {
            this.addItemToCart(item, quantity);
        }
        else{
            this.updateCartItem(cartItem, quantity);
        }
    }

    public List<CartItem> getCartItems(){
        return this.cartItemsList;
    }

    public CartItem getCartItem(Item item)
    {
        String itemName = item.getName();
        log.debug("Checking cart for item {}", itemName);

        CartItem foundCartItem = null;

        for(CartItem cartItem : cartItemsList)
        {
            Item cItem = cartItem.getItem();
            String cItemName = cItem.getName();

            if(itemName.equals(cItemName))
            {
                foundCartItem = cartItem;
                break;
            }
        }

        return foundCartItem;
    }


    public double getCartTotalBeforePromotions(){
        return 0;
    }

    public double getCartTotalWithPromotions(){
        return 0;
    }

    private CartItem addItemToCart(Item item, int quantity)
    {
        CartItem cartItem = null;

        if(quantity > 0)
        {
            log.debug("Adding item to cart");
            Promotion promotion = getPromotionForItem(item);
            cartItem = new CartItem(item, quantity, promotion);
            cartItemsList.add(cartItem);
        }
        else{
            log.debug("Not adding item to cart");
        }

        return cartItem;
    }

    private void updateCartItem(CartItem cartItem, int quantity)
    {
        if(quantity == 0)
        {
            removeCartItemFromCart(cartItem);
        }
        else{
            cartItem.setQuantity(quantity);
        }
    }

    private void removeCartItemFromCart(CartItem cartItem)
    {
        cartItemsList.remove(cartItem);
    }

    private Promotion getPromotionForItem(Item item)
    {
        Promotion foundPromotion = null;

        for(Promotion promotion: this.promotionList)
        {
            boolean isPromoSuitable = promotion.isPromotionSuitableForItem(item);

            if(isPromoSuitable)
            {
                foundPromotion = promotion;
                break;
            }
        }

        return foundPromotion;
    }

}
