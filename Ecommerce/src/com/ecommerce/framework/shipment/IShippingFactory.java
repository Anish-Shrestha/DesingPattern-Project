package com.ecommerce.framework.shipment;


public interface IShippingFactory {
        public IShipOrder getShippingAddress(String shippingType);
}
