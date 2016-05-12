package com.ramakhutla.ethon.chapter61.api.resource;

import com.ramakhutla.ethon.chapter61.domain.PaymentMethodType;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ethon on 5/8/2016.
 */
public class RentalResource implements Serializable {

    private Long id;
    private String pickUpDate;
    private String returnDate;

    private List<PaymentMethodType> paymentMethodtype;

    private RentalResource() {

    }

    public RentalResource(Builder builder) {
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

        public Builder copy(RentalResource rentalstype) {
            this.id = rentalstype.id;
            this.pickUpDate = rentalstype.pickUpDate;
            this.returnDate = rentalstype.returnDate;
            this.paymentMethodtype = rentalstype.paymentMethodtype;

            return this;
        }

        public RentalResource build() {
            return new RentalResource(this);
        }

    }
}
