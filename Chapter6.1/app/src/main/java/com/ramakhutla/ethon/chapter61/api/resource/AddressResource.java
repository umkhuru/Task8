package com.ramakhutla.ethon.chapter61.api.resource;

import java.io.Serializable;

/**
 * Created by Ethon on 5/8/2016.
 */
public class AddressResource implements Serializable {

    private Long id;
    private String Address;
    private String City;
    private String postalCode;

    //constructors
    public AddressResource()
    {

    }

    public AddressResource (Builder builder)
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

        public Builder copy(AddressResource addressResource)
        {
            this.id = addressResource.id;
            this.Address = addressResource.Address;
            this.City = addressResource.City;
            this.postalCode = addressResource.postalCode;
            return this;
        }

        public AddressResource build()
        {
            return new AddressResource(this);
        }
    }


}
