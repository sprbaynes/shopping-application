package com.shopping.app.model;

/**
 * Created by baynescorps on 09/11/2018.
 */
public class Item {
    String type;
    String name;
    double price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}