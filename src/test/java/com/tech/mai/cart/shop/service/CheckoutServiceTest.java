package com.tech.mai.cart.shop.service;

import com.tech.mai.cart.shop.type.DiscountType;
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
        cartItems.add(new Item(123, new BigDecimal("0.60"), DiscountType.NONE));
        cartItems.add(new Item(123, new BigDecimal("0.60"), DiscountType.NONE));
        cartItems.add(new Item(124, new BigDecimal("0.25"), DiscountType.NONE));
        cartItems.add(new Item(123, new BigDecimal("0.60"), DiscountType.NONE));

        assertEquals(0, new BigDecimal("2.05").compareTo(checkoutService.sumUpCartItems(cartItems)));
    }

    @Test
    public void testSumUpCartItemsWithTwoForOneSpecialOffers() {
        List<Item> cartItems = new ArrayList<>();
        cartItems.add(new Item(123, new BigDecimal("0.60"), DiscountType.TWO4ONE));
        cartItems.add(new Item(123, new BigDecimal("0.60"), DiscountType.TWO4ONE));
        cartItems.add(new Item(124, new BigDecimal("0.25"), DiscountType.THREE4TWO));
        cartItems.add(new Item(123, new BigDecimal("0.60"), DiscountType.TWO4ONE));

        assertEquals(0, new BigDecimal("1.45").compareTo(checkoutService.sumUpCartItems(cartItems)));
    }

    @Test
    public void testSumUpCartItemsWithThreeForTwoSpecialOffers() {
        List<Item> cartItems = new ArrayList<>();
        cartItems.add(new Item(123, new BigDecimal("0.60"), DiscountType.THREE4TWO));
        cartItems.add(new Item(123, new BigDecimal("0.60"), DiscountType.THREE4TWO));
        cartItems.add(new Item(124, new BigDecimal("0.25"), DiscountType.TWO4ONE));
        cartItems.add(new Item(123, new BigDecimal("0.60"), DiscountType.THREE4TWO));
        cartItems.add(new Item(123, new BigDecimal("0.60"), DiscountType.THREE4TWO));

        assertEquals(0, new BigDecimal("2.05").compareTo(checkoutService.sumUpCartItems(cartItems)));
    }

    @Test
    public void testSumUpCartItemsWithBothSpecialOffers() {
        List<Item> cartItems = new ArrayList<>();
        cartItems.add(new Item(123, new BigDecimal("0.60"), DiscountType.THREE4TWO));
        cartItems.add(new Item(123, new BigDecimal("0.60"), DiscountType.THREE4TWO));
        cartItems.add(new Item(124, new BigDecimal("0.25"), DiscountType.TWO4ONE));
        cartItems.add(new Item(123, new BigDecimal("0.60"), DiscountType.THREE4TWO));
        cartItems.add(new Item(123, new BigDecimal("0.60"), DiscountType.THREE4TWO));
        cartItems.add(new Item(124, new BigDecimal("0.25"), DiscountType.TWO4ONE));
        cartItems.add(new Item(124, new BigDecimal("0.25"), DiscountType.TWO4ONE));
        cartItems.add(new Item(123, new BigDecimal("0.60"), DiscountType.THREE4TWO));
        cartItems.add(new Item(123, new BigDecimal("0.60"), DiscountType.THREE4TWO));
        cartItems.add(new Item(125, new BigDecimal("0.50"), DiscountType.NONE));

        assertEquals(0, new BigDecimal("3.40").compareTo(checkoutService.sumUpCartItems(cartItems)));
    }
}