package com.tech.mai.cart.shop.service;

import com.tech.mai.cart.shop.type.DiscountType;
import com.tech.mai.cart.shop.type.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aamir
 */
public class CheckoutServiceImpl implements CheckoutService {

    @Override
    public BigDecimal sumUpCartItems(List<Item> cartItems) {
        return sumUpItemsByBarcode(sortByBarcode(cartItems));
    }

    private Map<Long, List<Item>> sortByBarcode(List<Item> cartItems) {
        final Map<Long, List<Item>> itemsByBarcode = new HashMap<>();

        for (Item item : cartItems) {
            List<Item> items = itemsByBarcode.get(item.getBarcode());
            if (items == null) {
                items = new ArrayList<>();
                itemsByBarcode.put(item.getBarcode(), items);
            }
            items.add(item);
        }
        return itemsByBarcode;
    }

    private BigDecimal sumUpItemsByBarcode(Map<Long, List<Item>> itemsByBarcode) {
        BigDecimal total = BigDecimal.ZERO;

        for (Map.Entry<Long, List<Item>> itemsEntry : itemsByBarcode.entrySet()) {
            List<Item> items = itemsEntry.getValue();
            BigDecimal itemsTotal = calculateTotal(items, items.get(0).getDiscountType());
            total = total.add(itemsTotal);
        }
        return total;
    }

    private BigDecimal calculateTotal(List<Item> items, DiscountType discountType) {
        switch (discountType) {
            case TWO4ONE:
                return calculateTotalWithEveryNthItemFree(items, 2);
            case THREE4TWO:
                return calculateTotalWithEveryNthItemFree(items, 3);
            default:
                return calculateTotalWithEveryNthItemFree(items, 0);
        }
    }

    private BigDecimal calculateTotalWithEveryNthItemFree(List<Item> items, int n) {
        BigDecimal total = BigDecimal.ZERO;

        for (int i = 0; i < items.size(); i++) {
            total = n!=0 && (i+1)%n == 0 ? total : total.add(items.get(i).getPrice());
        }
        return total;
    }
}
