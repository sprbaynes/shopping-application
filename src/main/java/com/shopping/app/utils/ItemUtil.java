package com.shopping.app.utils;

import com.shopping.app.model.Item;

/**
 * Created by baynescorps on 09/11/2018.
 */
public class ItemUtil {

    /*This class only really makes sense in the context of this test as an easy way to fetch the items on offer and
    share them with the tests. In the real world we'd probably fetch each item individually from a service*/

    public static Item headPhones = new Item("Audio","Headphones",150.00);
    public static Item speakers = new Item("Audio","Speakers",85);
    public static Item batteries = new Item("Power", "AAA Batteries", 0.85);
    public static Item proteinBars = new Item("Food", "Protein Bars (Box)", 0.85);

}
