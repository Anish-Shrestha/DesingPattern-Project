package com.ecommerce.framework.shipment;

import com.ecommerce.framework.cart.Order;


public class UPS implements IShipOrder {
    @Override
    public void shipOrder(Order order) {
        System.out.println("************ ORDER DELIVERY THROUGH UPS ************");
        System.out.println(order.getUser().getShippingAddress());
    }
}
