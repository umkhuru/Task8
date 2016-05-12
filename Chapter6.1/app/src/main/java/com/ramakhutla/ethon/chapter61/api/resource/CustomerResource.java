package com.ramakhutla.ethon.chapter61.api.resource;

import com.ramakhutla.ethon.chapter61.domain.AddressEmbeddableType;
import com.ramakhutla.ethon.chapter61.domain.LoginEmbeddableType;
import com.ramakhutla.ethon.chapter61.domain.RentalType;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ethon on 5/8/2016.
 */
public class CustomerResource implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private AddressEmbeddableType addressEmbeddabletype;

    private LoginEmbeddableType loginEmbeddabletype;
    private List<RentalType> rentalstype;

    //constructors
    private CustomerResource()
    {

    }

    public CustomerResource(Builder builder)
    {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.addressEmbeddabletype = builder.addressEmbeddabletype;
        this.loginEmbeddabletype = builder.loginEmbeddabletype;
        this.rentalstype = builder.rentalstype;
    }

    //getters
    public Long getId() {
        return id;
    }

    //@Override
    public String getFirstName() {
        return firstName;
    }

    //@Override
    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public AddressEmbeddableType getAddressEmbeddabletype() {
        return addressEmbeddabletype;
    }

    public LoginEmbeddableType getLoginEmbeddabletype() {
        return loginEmbeddabletype;
    }

    public List<RentalType> getRentalsType() {
        return rentalstype;
    }


    public static class Builder
    {
        private Long id;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private AddressEmbeddableType addressEmbeddabletype;
        private List<RentalType> rentalstype;
        private LoginEmbeddableType loginEmbeddabletype;


        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder addressEmbeddabletype(AddressEmbeddableType addressEmbeddabletype) {
            this.addressEmbeddabletype = addressEmbeddabletype;
            return this;
        }

        public Builder loginEmbeddabletype(LoginEmbeddableType loginEmbeddabletype) {
            this.loginEmbeddabletype = loginEmbeddabletype;
            return this;
        }

        public Builder rentals(List<RentalType> rentalstype) {
            this.rentalstype = rentalstype;
            return this;
        }


        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder copy(CustomerResource customertype)
        {
            this.id = customertype.id;
            this.firstName = customertype.firstName;
            this.lastName = customertype.lastName;
            this.phoneNumber = customertype.phoneNumber;
            this.addressEmbeddabletype = customertype.addressEmbeddabletype;
            this.loginEmbeddabletype = customertype.loginEmbeddabletype;
            this.rentalstype = customertype.rentalstype;
            return this;
        }

        public CustomerResource build()
        {
            return new CustomerResource(this);
        }
    }
}
