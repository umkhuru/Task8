package com.ramakhutla.ethon.chapter61.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dillin on 4/19/2016.
 */
public class CustomerType implements PersonType, Serializable {


    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private AddressEmbeddableType addressEmbeddabletype;

    private LoginEmbeddableType loginEmbeddabletype;
    private List<RentalType> rentalstype;

    //constructors
    private CustomerType()
    {

    }

    public CustomerType(Builder builder)
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

        public Builder copy(CustomerType customertype)
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

        public CustomerType build()
        {
            return new CustomerType(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerType that = (CustomerType) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null)
            return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null)
            return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null)
            return false;
        if (addressEmbeddabletype != null ? !addressEmbeddabletype.equals(that.addressEmbeddabletype) : that.addressEmbeddabletype != null)
            return false;
        if (loginEmbeddabletype != null ? !loginEmbeddabletype.equals(that.loginEmbeddabletype) : that.loginEmbeddabletype != null)
            return false;
        return rentalstype != null ? rentalstype.equals(that.rentalstype) : that.rentalstype == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (addressEmbeddabletype != null ? addressEmbeddabletype.hashCode() : 0);
        result = 31 * result + (loginEmbeddabletype != null ? loginEmbeddabletype.hashCode() : 0);
        result = 31 * result + (rentalstype != null ? rentalstype.hashCode() : 0);
        return result;
    }
}
