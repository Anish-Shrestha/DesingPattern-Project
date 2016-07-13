package com.ecommerce.framework.payment;

import java.util.Date;

/* Concrete Strategy Class*/
public class CreditCard implements PaymentMethod {
    private String name;
    private String cardNumber;
    private Date expires;

    public CreditCard() {
    }

    public String getName() {
        return name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Date getExpires() {
        return expires;
    }

    public CreditCard(String name, String cardNumber, Date expires) {
        super();
        this.name = name;
        this.cardNumber = cardNumber;
        this.expires = expires;
    }

    @Override
    public String pay(double amount) {
    	String data = "This amount " + amount + " is paid from " + name + " via credit card";
        System.out.println(data);
        return data;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }
}