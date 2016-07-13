package com.ecommerce.framework.cart;

import java.util.List;


public  abstract class AShoppingCart {
    protected List<ShoppingCartItem> cart;
    
    public List<ShoppingCartItem> getCart() {
        return cart;
    }
}
