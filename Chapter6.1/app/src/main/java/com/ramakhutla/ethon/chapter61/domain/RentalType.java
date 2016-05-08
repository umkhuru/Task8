package com.ramakhutla.ethon.chapter61.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dillin on 4/19/2016.
 */
public class RentalType implements Serializable {


    private Long id;
    private String pickUpDate;
    private String returnDate;

    private List<PaymentMethodType> paymentMethodtype;

    private RentalType() {

    }

    public RentalType(Builder builder) {
        this.id = builder.id;
        this.pickUpDate = builder.pickUpDate;
        this.returnDate = builder.returnDate;
        this.paymentMethodtype = builder.paymentMethodtype;
    }

    public Long getId() {
        return id;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public List<PaymentMethodType> getPaymentMethodType() {
        return paymentMethodtype;
    }


    public static class Builder {
        private Long id;
        private String pickUpDate;
        private String returnDate;
        private List<PaymentMethodType> paymentMethodtype;


        public Builder pickUpDate(String pickUpDate) {
            this.pickUpDate = pickUpDate;
            return this;
        }



        public Builder returnDate(String returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public Builder paymentMethod(List<PaymentMethodType> paymentMethodtype) {
            this.paymentMethodtype = paymentMethodtype;
            return this;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder copy(RentalType rentalstype) {
            this.id = rentalstype.id;
            this.pickUpDate = rentalstype.pickUpDate;
            this.returnDate = rentalstype.returnDate;
            this.paymentMethodtype = rentalstype.paymentMethodtype;

            return this;
        }

        public RentalType build() {
            return new RentalType(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RentalType that = (RentalType) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (pickUpDate != null ? !pickUpDate.equals(that.pickUpDate) : that.pickUpDate != null)
            return false;
        if (returnDate != null ? !returnDate.equals(that.returnDate) : that.returnDate != null)
            return false;
        return paymentMethodtype != null ? paymentMethodtype.equals(that.paymentMethodtype) : that.paymentMethodtype == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pickUpDate != null ? pickUpDate.hashCode() : 0);
        result = 31 * result + (returnDate != null ? returnDate.hashCode() : 0);
        result = 31 * result + (paymentMethodtype != null ? paymentMethodtype.hashCode() : 0);
        return result;
    }
}
