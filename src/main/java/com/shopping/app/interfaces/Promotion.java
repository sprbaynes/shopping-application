package com.shopping.app.interfaces;

import com.shopping.app.model.Item;

/**
 * Created by baynescorps on 09/11/2018.
 */
public interface Promotion {
    double getTotalPrice(Item item, int quantity, Double cartTotal, Double itemTypeTotal);
}
