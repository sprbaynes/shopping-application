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
public class DiscountPromotionTest {
    Promotion discountPromotionName;
    Promotion discountPromotionType;

    @Before
    public void setup(){
        discountPromotionName =  new DiscountPromotion(30.00, "Protein Bars (Box)", MatchType.Name);
        discountPromotionType =  new DiscountPromotion(30.00, "Power", MatchType.ProductType);
    }

    @After
    public void teardown(){
        discountPromotionName = null;
        discountPromotionType = null;
    }

    @Test
    public void testIsPromotionSuitable_1(){
        Item batteries = ItemUtil.batteries;
        Item proteinBars = ItemUtil.proteinBars;

        boolean isPromoSuitable1 = discountPromotionName.isPromotionSuitableForItem(proteinBars);
        assertEquals(true, isPromoSuitable1);

        boolean isPromoSuitable2 = discountPromotionName.isPromotionSuitableForItem(batteries);
        assertEquals(false, isPromoSuitable2);
    }

    @Test
    public void testIsPromotionSuitable_2(){
        Item batteries = ItemUtil.batteries;
        Item proteinBars = ItemUtil.proteinBars;

        boolean isPromoSuitable1 = discountPromotionType.isPromotionSuitableForItem(proteinBars);
        assertEquals(false, isPromoSuitable1);

        boolean isPromoSuitable2 = discountPromotionType.isPromotionSuitableForItem(batteries);
        assertEquals(true, isPromoSuitable2);
    }

    @Test
    public void testTotalPrice_1(){
        Item proteinBars = ItemUtil.proteinBars;

        double total = discountPromotionName.getTotalPrice(proteinBars, 1, null, null);
        assertEquals(17.5, total, 0.001);
    }

    @Test
    public void testTotalPrice_2(){
        Item proteinBars = ItemUtil.proteinBars;

        double total = discountPromotionName.getTotalPrice(proteinBars, 2, null, null);
        assertEquals(35, total, 0.001);
    }


}
