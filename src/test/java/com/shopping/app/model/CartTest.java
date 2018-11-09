package com.shopping.app.model;

import com.shopping.app.utils.ItemUtil;
import com.shopping.app.utils.PromotionUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by baynescorps on 09/11/2018.
 */
public class CartTest {

    private Cart cart;

    @Before
    public void setup(){
        cart = new Cart(PromotionUtil.getPromotionList());
    }

    @After
    public void teardown(){
        cart = null;
    }

    @Test
    public void testAddingCartItems_1()
    {
        cart.setItemQuantity(ItemUtil.headPhones, 3);
        List<CartItem> cartItems = cart.getCartItems();

        assertEquals(1, cartItems.size());

        CartItem cartItem1 = cart.getCartItem(ItemUtil.headPhones);;
        Item item1 = cartItem1.getItem();

        assertNotEquals(null, item1);
        assertEquals("Headphones", item1.getName());
        assertEquals(3, cartItem1.getQuantity());
        assertEquals(450.00, cart.getCartTotalBeforePromotions(), 0);
        assertEquals(315.00, cart.getCartTotalWithPromotions(),0);
    }

    @Test
    public void testAddingCartItems_2()
    {
        cart.setItemQuantity(ItemUtil.headPhones, 3);
        cart.setItemQuantity(ItemUtil.batteries, 2);
        cart.setItemQuantity(ItemUtil.proteinBars, 4);

        List<CartItem> cartItems = cart.getCartItems();

        assertEquals(9, cartItems.size());

        CartItem cartItem1 = cart.getCartItem(ItemUtil.headPhones);
        CartItem cartItem2 = cart.getCartItem(ItemUtil.batteries);
        CartItem cartItem3 = cart.getCartItem(ItemUtil.proteinBars);

        Item item1 = cartItem1.getItem();
        Item item2 = cartItem2.getItem();
        Item item3 = cartItem3.getItem();

        assertNotEquals(null, item1);
        assertEquals("Headphones", item1.getName());
        assertEquals(3, cartItem1.getQuantity());

        assertNotEquals(null, item2);
        assertEquals("AAA Batteries", item2.getName());
        assertEquals(2, cartItem2.getQuantity());

        assertNotEquals(null, item3);
        assertEquals("Protein Bars (Box)", item3.getName());
        assertEquals(4, cartItem3.getQuantity());
    }

    @Test
    public void testRemovingCartItems_1()
    {
        cart.setItemQuantity(ItemUtil.headPhones, 3);
        cart.setItemQuantity(ItemUtil.batteries, 2);
        cart.setItemQuantity(ItemUtil.proteinBars, 4);
        cart.setItemQuantity(ItemUtil.batteries, 0);

        List<CartItem> cartItems = cart.getCartItems();

        assertEquals(9, cartItems.size());

        CartItem cartItem1 = cart.getCartItem(ItemUtil.headPhones);
        CartItem cartItem2 = cart.getCartItem(ItemUtil.batteries);
        CartItem cartItem3 = cart.getCartItem(ItemUtil.proteinBars);

        Item item1 = cartItem1.getItem();
        Item item2 = cartItem2.getItem();
        Item item3 = cartItem3.getItem();

        assertNotEquals(null, item1);
        assertEquals("Headphones", item1.getName());
        assertEquals(3, cartItem1.getQuantity());

        assertEquals(null, item2);

        assertNotEquals(null, item3);
        assertEquals("Protein Bars (Box)", item3.getName());
        assertEquals(4, cartItem3.getQuantity());
    }


    @Test
    public void testUpdatingCartItems_1()
    {
        cart.setItemQuantity(ItemUtil.headPhones, 3);
        cart.setItemQuantity(ItemUtil.batteries, 2);
        cart.setItemQuantity(ItemUtil.proteinBars, 4);
        cart.setItemQuantity(ItemUtil.batteries, 5);

        List<CartItem> cartItems = cart.getCartItems();

        assertEquals(9, cartItems.size());

        CartItem cartItem1 = cart.getCartItem(ItemUtil.headPhones);
        CartItem cartItem2 = cart.getCartItem(ItemUtil.batteries);
        CartItem cartItem3 = cart.getCartItem(ItemUtil.proteinBars);

        Item item1 = cartItem1.getItem();
        Item item2 = cartItem2.getItem();
        Item item3 = cartItem3.getItem();

        assertNotEquals(null, item1);
        assertEquals("Headphones", item1.getName());
        assertEquals(3, cartItem1.getQuantity());

        assertNotEquals(null, item2);
        assertEquals("AAA Batteries", item2.getName());
        assertEquals(5, cartItem2.getQuantity());

        assertNotEquals(null, item3);
        assertEquals("Protein Bars (Box)", item3.getName());
        assertEquals(4, cartItem3.getQuantity());
    }

    @Test
    public void testUpdatingCartItems_2()
    {
        cart.setItemQuantity(ItemUtil.headPhones, 3);
        cart.setItemQuantity(ItemUtil.batteries, 2);
        cart.setItemQuantity(ItemUtil.proteinBars, 4);
        cart.setItemQuantity(ItemUtil.batteries, 5);
        cart.setItemQuantity(ItemUtil.headPhones, 8);

        List<CartItem> cartItems = cart.getCartItems();

        assertEquals(9, cartItems.size());

        CartItem cartItem1 = cart.getCartItem(ItemUtil.headPhones);
        CartItem cartItem2 = cart.getCartItem(ItemUtil.batteries);
        CartItem cartItem3 = cart.getCartItem(ItemUtil.proteinBars);

        Item item1 = cartItem1.getItem();
        Item item2 = cartItem2.getItem();
        Item item3 = cartItem3.getItem();

        assertNotEquals(null, item1);
        assertEquals("Headphones", item1.getName());
        assertEquals(8, cartItem1.getQuantity());

        assertNotEquals(null, item2);
        assertEquals("AAA Batteries", item2.getName());
        assertEquals(5, cartItem2.getQuantity());

        assertNotEquals(null, item3);
        assertEquals("Protein Bars (Box)", item3.getName());
        assertEquals(4, cartItem3.getQuantity());
    }

    public void testCartTotals_1(){
        cart.setItemQuantity(ItemUtil.headPhones, 3);

        assertEquals(450.00, cart.getCartTotalBeforePromotions(), 0);
        assertEquals(315.00, cart.getCartTotalWithPromotions(),0);
    }

    public void testCartTotals_2(){
        cart.setItemQuantity(ItemUtil.headPhones, 3);
        cart.setItemQuantity(ItemUtil.speakers, 2);

        assertEquals(620, cart.getCartTotalBeforePromotions(), 0);
        assertEquals(434, cart.getCartTotalWithPromotions(),0);
    }

    public void testCartTotals_3(){
        cart.setItemQuantity(ItemUtil.batteries, 3);

        assertEquals(2.55, cart.getCartTotalBeforePromotions(), 0);
        assertEquals(1.7, cart.getCartTotalWithPromotions(),0);
    }

    public void testCartTotals_4(){
        cart.setItemQuantity(ItemUtil.batteries, 4);

        assertEquals(3.4, cart.getCartTotalBeforePromotions(), 0);
        assertEquals(2.55, cart.getCartTotalWithPromotions(),0);
    }

    public void testCartTotals_5(){
        cart.setItemQuantity(ItemUtil.batteries, 6);

        assertEquals(5.1, cart.getCartTotalBeforePromotions(), 0);
        assertEquals(3.4, cart.getCartTotalWithPromotions(),0);
    }

    public void testCartTotals_6(){
        cart.setItemQuantity(ItemUtil.batteries, 6);
        cart.setItemQuantity(ItemUtil.proteinBars, 2);

        assertEquals(55.1, cart.getCartTotalBeforePromotions(), 0);
        assertEquals(53.4, cart.getCartTotalWithPromotions(),0);
    }


}
