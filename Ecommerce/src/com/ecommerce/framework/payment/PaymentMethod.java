package com.ecommerce.framework.payment;



/*Strategy Interface*/
public interface PaymentMethod {
    public String pay(double amount);

}