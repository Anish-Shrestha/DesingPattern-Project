package com.ecommerce.framework.cart;

import com.ecommerce.framework.product.Product;

public class ShoppingCartItem{
    private int quantity;
    private Product product;

    public ShoppingCartItem(Product product){
        this.product =product;
        quantity=1;
    }
    public ShoppingCartItem(Product product, int quantity){
        this.product =product;
        this.quantity = quantity;
    }

    public void increaseQuantity(){
        quantity++;
    }

    public boolean hasProduct(Product product){
      return   (this.product.getProductId()==product.getProductId())?true:false;
    }

    public int getQuantity(){
        return  this.quantity;
    }

    public Product getProduct(){
        return this.product;
    }

}
