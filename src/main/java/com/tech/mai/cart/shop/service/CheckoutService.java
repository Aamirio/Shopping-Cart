package com.tech.mai.cart.shop.service;

import com.tech.mai.cart.shop.type.Item;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Aamir
 */
public interface CheckoutService {

    public BigDecimal sumUpCartItems(List<Item> cartItems);

}