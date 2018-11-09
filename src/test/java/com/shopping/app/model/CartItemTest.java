package com.shopping.app.model;

import com.shopping.app.utils.ItemUtil;
import com.shopping.app.utils.PromotionUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by baynescorps on 09/11/2018.
 */
public class CartItemTest {

    CartItem headphones, speakers, batteries, proteinBars;

    @Before
    public void setup(){
        speakers = new CartItem(ItemUtil.speakers, 0, PromotionUtil.thirtyPercentPromotion);
        batteries = new CartItem(ItemUtil.batteries,0,PromotionUtil.threeforTwoPromotion);
        proteinBars = new CartItem(ItemUtil.proteinBars,0, null);

    }

    @After
    public void teardown(){
        headphones = null;
        speakers = null;
        batteries = null;
        proteinBars = null;
    }

    @Test
    public void testTotalPrice_1(){
        proteinBars.setQuantity(3);

        double totalBefore = proteinBars.getTotalBeforePromotions();
        assertEquals(75, totalBefore, 0.001);

        double totalWith = proteinBars.getTotalWithPromotions();
        assertEquals(75, totalWith, 0.001);
    }

    @Test
    public void testTotalPrice_2(){
        speakers.setQuantity(4);

        double totalBefore = speakers.getTotalBeforePromotions();
        assertEquals(340, totalBefore, 0.001);

        double totalWith = speakers.getTotalWithPromotions();
        assertEquals(238, totalWith, 0.001);
    }

    @Test
    public void testTotalPrice_3(){
        batteries.setQuantity(2);

        double totalBefore = batteries.getTotalBeforePromotions();
        assertEquals(1.7, totalBefore, 0.001);

        double totalWith = batteries.getTotalWithPromotions();
        assertEquals(1.7, totalWith, 0.001);
    }

    @Test
    public void testTotalPrice_4(){
        batteries.setQuantity(3);

        double totalBefore = batteries.getTotalBeforePromotions();
        assertEquals(2.55, totalBefore, 0.001);

        double totalWith = batteries.getTotalWithPromotions();
        assertEquals(1.7, totalWith, 0.001);
    }

    @Test
    public void testTotalPrice_5(){
        batteries.setQuantity(4);

        double totalBefore = batteries.getTotalBeforePromotions();
        assertEquals(3.4, totalBefore, 0.001);

        double totalWith = batteries.getTotalWithPromotions();
        assertEquals(2.55, totalWith, 0.001);
    }
}
