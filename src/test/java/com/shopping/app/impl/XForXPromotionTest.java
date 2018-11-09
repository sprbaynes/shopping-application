package com.shopping.app.impl;

import com.shopping.app.enums.MatchType;
import com.shopping.app.interfaces.Promotion;
import com.shopping.app.model.Item;
import com.shopping.app.utils.ItemUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by baynescorps on 09/11/2018.
 */
public class XForXPromotionTest {

    Promotion xForXPromotionName;
    Promotion xForXPromotionType;

    @Before
    public void setup(){
        xForXPromotionName =  new XForXPromotion(3,2,"AAA Batteries", MatchType.Name);
        xForXPromotionType =  new XForXPromotion(3,2,"Food", MatchType.ProductType);
    }

    @After
    public void teardown(){
        xForXPromotionName = null;
        xForXPromotionType = null;
    }

    @Test
    public void testIsPromotionSuitable_1(){
        Item batteries = ItemUtil.batteries;
        Item proteinBars = ItemUtil.proteinBars;

        boolean isPromoSuitable1 = xForXPromotionName.isPromotionSuitableForItem(batteries);
        assertEquals(true, isPromoSuitable1);

        boolean isPromoSuitable2 = xForXPromotionName.isPromotionSuitableForItem(proteinBars);
        assertEquals(false, isPromoSuitable2);
    }

    @Test
    public void testIsPromotionSuitable_2(){
        Item batteries = ItemUtil.batteries;
        Item proteinBars = ItemUtil.proteinBars;

        boolean isPromoSuitable1 = xForXPromotionType.isPromotionSuitableForItem(batteries);
        assertEquals(false, isPromoSuitable1);

        boolean isPromoSuitable2 = xForXPromotionType.isPromotionSuitableForItem(proteinBars);
        assertEquals(true, isPromoSuitable2);
    }

    @Test
    public void testTotalPrice_1(){
        Item batteries = ItemUtil.batteries;

        double total = xForXPromotionName.getTotalPrice(batteries, 2, null, null);
        assertEquals(1.7, total, 0.001);
    }

    @Test
    public void testTotalPrice_2(){
        Item batteries = ItemUtil.batteries;

        double total = xForXPromotionName.getTotalPrice(batteries, 3, null, null);
        assertEquals(1.7, total, 0.001);
    }

    @Test
    public void testTotalPrice_3(){
        Item batteries = ItemUtil.batteries;

        double total = xForXPromotionName.getTotalPrice(batteries, 4, null, null);
        assertEquals(2.55, total, 0.001);
    }
}
