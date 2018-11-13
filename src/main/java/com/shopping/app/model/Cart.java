package com.shopping.app.model;

import com.shopping.app.interfaces.Promotion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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

    /*I've only used a predicate here to demonstrate use of Java 8 features. I probably wouldn't use one here
    * under normal circumstances as it assumes too much knowledge of the code that underlies the method*/
    public void setItemQuantity(Item item, int quantity, Predicate<CartItem> itemPredicate)
    {
        log.debug("About to add/update item in cart");

        CartItem cartItem = getCartItem(item);

        if(itemPredicate.test(cartItem))
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

        Optional<CartItem> cartItemOptional = cartItemsList.stream().filter(
            (cartItem)->{
                Item cItem = cartItem.getItem();
                String cItemName = cItem.getName();
                return (itemName.equals(cItemName));
            }
        ).findFirst();

        foundCartItem = cartItemOptional.orElse(null);

        return foundCartItem;
    }


    public double getCartTotalBeforePromotions(){
        double total = 0;

        total = cartItemsList.stream().mapToDouble( cartItem -> cartItem.getTotalBeforePromotions()).sum();

        return total;
    }

    public double getCartTotalWithPromotions(){
        double total = 0;

        total = cartItemsList.stream().mapToDouble( cartItem -> cartItem.getTotalWithPromotions()).sum();

        return total;
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
        Optional<Promotion> promotionOptional = promotionList.stream().filter(
                (p) -> p.isPromotionSuitableForItem(item)
            ).findFirst();

        Promotion foundPromotion = promotionOptional.orElse(null);

        return foundPromotion;
    }

}
