package com.tech.mai.cart.shop.service;

import com.tech.mai.cart.shop.type.Item;
import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aamir
 */
public class CheckoutServiceTest extends TestCase {

    private CheckoutService checkoutService = new CheckoutServiceImpl();

    @Test
    public void testSumUpCartItems() {
        List<Item> cartItems = new ArrayList<>();
        cartItems.add(new Item(new BigDecimal("0.60")));
        cartItems.add(new Item(new BigDecimal("0.60")));
        cartItems.add(new Item(new BigDecimal("0.25")));
        cartItems.add(new Item(new BigDecimal("0.60")));

        assertEquals(0, new BigDecimal("2.05").compareTo(checkoutService.sumUpCartItems(cartItems)));
    }
}