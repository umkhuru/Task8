package com.ramakhutla.ethon.chapter61.api.resource;

import java.io.Serializable;

/**
 * Created by Ethon on 5/8/2016.
 */
public class PaymentResource implements Serializable {

    private Long id;
    private String PaymentType;
    private double Price;

    private PaymentResource()

    {

    }

    public PaymentResource(Builder builder) {
        this.id = builder.id;
        this.PaymentType = builder.PaymentType;
        this.Price = builder.Price;
    }

    public Long getId() {
        return id;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public double getPrice() {
        return Price;
    }


    public static class Builder {
        private Long id;
        private String PaymentType;
        private double Price;

        public Builder PaymentType(String PaymentType) {
            this.PaymentType = PaymentType;
            return this;
        }

        public Builder Price(double Price) {
            this.Price = Price;
            return this;
        }


        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder copy(PaymentResource paymentMethodtype) {
            this.id = paymentMethodtype.id;
            this.PaymentType = paymentMethodtype.PaymentType;
            this.Price = paymentMethodtype.Price;
            return this;
        }

        public PaymentResource build() {
            return new PaymentResource(this);
        }
    }
}
