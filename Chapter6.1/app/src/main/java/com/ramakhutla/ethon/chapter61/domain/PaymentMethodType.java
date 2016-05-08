package com.ramakhutla.ethon.chapter61.domain;

import java.io.Serializable;

/**
 * Created by Dillin on 4/19/2016.
 */
public class PaymentMethodType implements Serializable {

    private Long id;
    private String PaymentType;
    private double Price;

    private PaymentMethodType()

    {

    }

    public PaymentMethodType(Builder builder) {
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

        public Builder copy(PaymentMethodType paymentMethodtype) {
            this.id = paymentMethodtype.id;
            this.PaymentType = paymentMethodtype.PaymentType;
            this.Price = paymentMethodtype.Price;
            return this;
        }

        public PaymentMethodType build() {
            return new PaymentMethodType(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentMethodType that = (PaymentMethodType) o;

        if (Double.compare(that.Price, Price) != 0) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return PaymentType != null ? PaymentType.equals(that.PaymentType) : that.PaymentType == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (PaymentType != null ? PaymentType.hashCode() : 0);
        temp = Double.doubleToLongBits(Price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
