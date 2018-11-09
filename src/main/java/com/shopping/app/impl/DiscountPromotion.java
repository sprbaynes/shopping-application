package com.shopping.app.impl;

import com.shopping.app.enums.MatchType;
import com.shopping.app.interfaces.Promotion;
import com.shopping.app.model.Item;
import com.shopping.app.utils.PromotionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by baynescorps on 09/11/2018.
 */
public class DiscountPromotion implements Promotion{

    private static final Logger log = LoggerFactory.getLogger(DiscountPromotion.class);

    private MatchType matchType;
    private double discountPercentage;
    private String match;

    /* Percentage Discounts can often be have a minimum spend either on the total cart, total item type e.g. audio or
    * video games and sometimes within a specific product/product line. For the sake of speed I won't be implementing
    * this functionality here. However we could add the below parameters to this promotion's constructor, which would go some
    * way toward allowing us to implement these kinds of promotions.
    *
    * Using the primitive wrappers for the minimum purchase values allows us to signify the relevance of each of the
    * minimum purchase types e.g. if minimumCartPurchase is null then we know not to check the total cart price when
    * applying the promotion.
     public DiscountPromotion(double discountPercentage,
                             Double minimumCartPurchase,
                             Double minimumItemTypePurchase,
                             Double minimumSpecificItemPurchase,
                             String match, MatchType matchType){}
     * */

    public DiscountPromotion(double discountPercentage, String match, MatchType matchType){
        this.matchType = matchType;
        this.discountPercentage = discountPercentage;
        this.match = match;
    }

    @Override
    public double getTotalPrice(Item item, int quantity, Double cartTotal, Double itemTypeTotal) {
        double price = item.getPrice();
        double totalBeforePromo = price * quantity;

        double percentageToPay = 100.00 - discountPercentage;
        log.info("perecentage to pay is {}", percentageToPay);

        double decimalPercentage = percentageToPay / 100.00;
        double totalWithPromo = decimalPercentage * totalBeforePromo;

        return totalWithPromo;
    }

    @Override
    public boolean isPromotionSuitableForItem(Item item) {
        return PromotionUtil.isPromotionSuitableForItem(item, match, matchType);
    }
}
