package com.ecommerce.framework.payment;

import com.ecommerce.framework.cart.ShoppingCart;


public class PaymentContext {
    private PaymentMethod paymentMethod;

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    /* For changing runtime strategy for payment */
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String makePayment(double payableAmount) {
      return  paymentMethod.pay(payableAmount);
    }
}
