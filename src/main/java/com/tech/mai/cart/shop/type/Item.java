package com.tech.mai.cart.shop.type;

import java.math.BigDecimal;

/**
 * Created by Aamir
 */
public class Item {

    long id;
    BigDecimal price;

    public Item(BigDecimal price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
