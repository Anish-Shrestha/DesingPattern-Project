package com.ecommerce.framework.payment;

import java.util.Date;

/* Concrete Strategy Class*/
public class MobilePayment implements PaymentMethod {
    private final String serviceProvider;
    private final String mobileNumber;
    private final Date expires;

    public String getServiceProvider() {
        return serviceProvider;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Date getExpires() {
        return expires;
    }

    public MobilePayment(String serviceProvider, String mobileNumber,
                         Date expires) {
        super();
        this.serviceProvider = serviceProvider;
        this.mobileNumber = mobileNumber;
        this.expires = expires;
    }

    @Override
    public String pay(double amount) {
    	String data = "This amount " + amount + " is paid from " + mobileNumber + " via mobile payment";
        System.out.println(data);
        return data;
       
    }
}