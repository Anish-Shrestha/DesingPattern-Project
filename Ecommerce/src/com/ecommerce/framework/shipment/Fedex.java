package com.ecommerce.framework.shipment;

import com.ecommerce.framework.cart.Order;


public class Fedex implements IShipOrder {
    @Override
    public void shipOrder(Order order) {
        System.out.println("************ ORDER DELIVERY THROUGH FEDEX ************");
    
    }
}
