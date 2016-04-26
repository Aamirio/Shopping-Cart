package com.tech.mai.cart.shop.service;

import com.tech.mai.cart.shop.type.Item;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Aamir
 */
public class CheckoutServiceImpl implements CheckoutService {

    @Override
    public BigDecimal sumUpCartItems(List<Item> cartItems) {
        BigDecimal total = BigDecimal.ZERO;
        for (Item item : cartItems) { total = total.add(item.getPrice()); }
        return total;
    }
}
