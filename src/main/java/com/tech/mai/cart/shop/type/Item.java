package com.tech.mai.cart.shop.type;

import java.math.BigDecimal;

/**
 * Created by Aamir
 */
public class Item {

    long id;
    long barcode;
    BigDecimal price;
    DiscountType discountType;

    public Item(long barcode, BigDecimal price, DiscountType discountType) {
        this.barcode = barcode;
        this.price = price;
        this.discountType = discountType;
    }

    public long getId() {
        return id;
    }

    public long getBarcode() {
        return barcode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }
}
