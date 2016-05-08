package com.ramakhutla.ethon.chapter61.domain;

import java.io.Serializable;

/**
 * Created by Dillin on 4/19/2016.
 */

public class AddressEmbeddableType implements Serializable {


    private Long id;
    private String Address;
    private String City;
    private String postalCode;

    //constructors
    public AddressEmbeddableType()
    {

    }

    public AddressEmbeddableType (Builder builder)
    {
        this.Address = builder.Address;
        this.City = builder.City;
        this.postalCode = builder.postalCode;
        this.id = builder.id;
    }

    //Getters
    public Long getId() {
        return id;
    }
    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return City;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public static class Builder
    {
        private String Address;
        private String City;
        private String postalCode;
        private Long id;

        public Builder Address(String Address)
        {
            this.Address = Address;
            return this;
        }

        public Builder City(String City)
        {
            this.City = City;
            return this;
        }

        public Builder postalCode(String postalCode)
        {
            this.postalCode = postalCode;
            return this;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder copy(AddressEmbeddableType addressEmbeddabletype)
        {
            this.id = addressEmbeddabletype.id;
            this.Address = addressEmbeddabletype.Address;
            this.City = addressEmbeddabletype.City;
            this.postalCode = addressEmbeddabletype.postalCode;
            return this;
        }

        public AddressEmbeddableType build()
        {
            return new AddressEmbeddableType(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressEmbeddableType that = (AddressEmbeddableType) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (Address != null ? !Address.equals(that.Address) : that.Address != null) return false;
        if (City != null ? !City.equals(that.City) : that.City != null) return false;
        return postalCode != null ? postalCode.equals(that.postalCode) : that.postalCode == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (Address != null ? Address.hashCode() : 0);
        result = 31 * result + (City != null ? City.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        return result;
    }
}
