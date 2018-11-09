package com.shopping.app.impl;

import com.shopping.app.enums.MatchType;
import com.shopping.app.interfaces.Promotion;
import com.shopping.app.model.Item;

/**
 * Created by baynescorps on 09/11/2018.
 */
//E.g. 3 for 2
public class XForXPromotion implements Promotion{

    public XForXPromotion(int x, int forX, String match, MatchType matchType){

    }

    @Override
    public double getTotalPrice(Item item, int quantity, Double cartTotal, Double itemTypeTotal) {
        return 0;
    }
}
