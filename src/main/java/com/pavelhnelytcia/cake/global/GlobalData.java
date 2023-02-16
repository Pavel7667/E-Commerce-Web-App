package com.pavelhnelytcia.cake.global;

import com.pavelhnelytcia.cake.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * GlobalData class for shopping cart for storing orders
 */
public class GlobalData {
    public static List<Product> cart;
    static {
        cart = new ArrayList<>();
    }
}
