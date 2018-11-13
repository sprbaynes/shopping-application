package com.shopping.app;

import com.shopping.app.model.Cart;
import com.shopping.app.model.Item;
import com.shopping.app.utils.CartItemUtil;
import com.shopping.app.utils.ItemUtil;
import com.shopping.app.utils.PromotionUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by baynescorps on 09/11/2018.
 */
public class ShoppingApplicationTest {

    Cart cart;
    Item speakers, batteries, proteinBars;

    @Before
    public void setup(){
        cart = new Cart(PromotionUtil.getPromotionList());

        speakers = ItemUtil.speakers;
        batteries = ItemUtil.batteries;
        proteinBars = ItemUtil.proteinBars;
    }

    @After
    public void teardown(){
        cart = null;
    }

    @Test
    public void testMainScenario() {
        cart.setItemQuantity(speakers, 1, CartItemUtil.isCartItemNull());
        cart.setItemQuantity(batteries, 5, CartItemUtil.isCartItemNull());
        cart.setItemQuantity(proteinBars, 2, CartItemUtil.isCartItemNull());

        //85 + (5 x 0.85) + (2 x 25) = 139.25
        double totalBeforePromo = cart.getCartTotalBeforePromotions();
        assertEquals(139.25, totalBeforePromo, 0.001);

        //59.5 + 3.4 + 50
        double totalWithPromo = cart.getCartTotalWithPromotions();
        assertEquals(112.9, totalWithPromo, 0.001);
    }
}
