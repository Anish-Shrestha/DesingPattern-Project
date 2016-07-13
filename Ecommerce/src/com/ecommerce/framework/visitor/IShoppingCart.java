package com.ecommerce.framework.visitor;

import com.ecommerce.framework.cart.ShoppingCartItem;
import com.ecommerce.framework.product.Product;

import java.util.List;

public interface IShoppingCart {
    void removeItem(Product product);
    void addItem(Product product);
    List<ShoppingCartItem> getItems();
    double calculateTotal();
    void clear();
    int getNoOfItems();
}
