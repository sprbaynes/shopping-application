package com.shopping.app.utils;

import com.shopping.app.enums.MatchType;
import com.shopping.app.impl.DiscountPromotion;
import com.shopping.app.impl.XForXPromotion;
import com.shopping.app.interfaces.Promotion;
import com.shopping.app.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baynescorps on 09/11/2018.
 */
public class PromotionUtil {

    /*This class only really makes sense in the context of this test as an easy way to fetch the promotions and
    share them with the tests without duplicating code. In the real world we'd probably fetch each promotion
    individually from a service*/

    public static Promotion thirtyPercentPromotion = new DiscountPromotion("30% Off", 30.00, "Audio", MatchType.ProductType);
    public static Promotion threeforTwoPromotion = new XForXPromotion("3 for 2",3,2,"AAA Batteries", MatchType.Name);

    public static List<Promotion> getPromotionList()
    {
        List<Promotion> promotionList = new ArrayList<>();
        promotionList.add(thirtyPercentPromotion);
        promotionList.add(threeforTwoPromotion);
        return promotionList;
    }

    public static boolean isPromotionSuitableForItem(Item item, String match, MatchType matchType) {
        String itemName = item.getName();
        String itemType = item.getType();

        if(matchType == MatchType.Name && itemName.equals(match))
        {
            return true;
        }
        if(matchType == MatchType.ProductType && itemType.equals(match))
        {
            return true;
        }
        else{
            return false;
        }
    }
}
