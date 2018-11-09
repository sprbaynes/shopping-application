package com.shopping.app;

import com.shopping.app.interfaces.Promotion;
import com.shopping.app.model.Cart;
import com.shopping.app.model.CartItem;
import com.shopping.app.model.Item;
import com.shopping.app.utils.ItemUtil;
import com.shopping.app.utils.PromotionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by baynescorps on 29/05/2018.
 */
public class ShoppingApplication {

    private static final Logger log = LoggerFactory.getLogger(ShoppingApplication.class);

    public static void main(String... args) {

        log.info("Starting Shopping ShoppingApplication");

        Cart cart = new Cart(PromotionUtil.getPromotionList());
        Item speakers = ItemUtil.speakers;
        Item batteries = ItemUtil.batteries;
        Item proteinBars = ItemUtil.proteinBars;

        cart.setItemQuantity(speakers, 1);
        cart.setItemQuantity(batteries, 5);
        cart.setItemQuantity(proteinBars, 2);

        outputCartToConsole(cart);
    }

    public static void outputCartToConsole(Cart cart){
        List<CartItem> cartItemList = cart.getCartItems();

        StringBuilder cartSB = new StringBuilder("");
        cartSB.append("\n------------------------------\n");
        cartSB.append("Cart Items\n");
        cartSB.append("------------------------------\n");

        for(int i = 0; i < cartItemList.size(); i++)
        {
            CartItem cartItem = cartItemList.get(i);
            Item item = cartItem.getItem();
            String name = item.getName();
            double price = item.getPrice();
            int quantity = cartItem.getQuantity();
            Promotion promo = cartItem.getPromotion();

            cartSB.append(String.format("Item %d: %s x %d @ %s\n",i+1, name, quantity, price ));
            if(promo != null)
            {
                cartSB.append(String.format("|_ + %s savings\n",promo.getPromoDescription()));
            }
        }

        cartSB.append("------------------------------\n");

        double totalBeforePromo = cart.getCartTotalBeforePromotions();
        cartSB.append(String.format("Total before promotion(s): %s\n", totalBeforePromo));

        double totalWithPromo = cart.getCartTotalWithPromotions();
        cartSB.append(String.format("Total with promotion(s): %s\n", totalWithPromo));

        cartSB.append("------------------------------\n");
        log.info(cartSB.toString());
    }

}
