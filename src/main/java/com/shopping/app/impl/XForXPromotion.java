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
//E.g. 3 for 2
public class XForXPromotion implements Promotion{

    private static final Logger log = LoggerFactory.getLogger(XForXPromotion.class);

    private MatchType matchType;
    private String match;
    private int x, forX;

    public XForXPromotion(int x, int forX, String match, MatchType matchType){
        this.matchType = matchType;
        this.x = x;
        this.forX = forX;
        this.match = match;
    }

    @Override
    public double getTotalPrice(Item item, int quantity, Double cartTotal, Double itemTypeTotal) {
        double price = item.getPrice();
        int numOfPromotions = quantity / this.x;
        int numNotInPromotion = quantity % this.x;
        int numToPayFor = (numOfPromotions * this.forX) + numNotInPromotion;

        double totalToPayFor = price * numToPayFor;

        return totalToPayFor;
    }

    @Override
    public boolean isPromotionSuitableForItem(Item item) {
        return PromotionUtil.isPromotionSuitableForItem(item, match, matchType);
    }
}
