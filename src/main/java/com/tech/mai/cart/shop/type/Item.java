package com.tech.mai.cart.shop.type;

import java.math.BigDecimal;

/**
 * Created by Aamir
 */
public class Item {

    long id;
    long barcode;
    String name;
    BigDecimal price;
    DiscountType discountType;

    public Item(long barcode, String name, BigDecimal price, DiscountType discountType) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
        this.discountType = discountType;
    }

    public long getId() {
        return id;
    }

    public long getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }
}
