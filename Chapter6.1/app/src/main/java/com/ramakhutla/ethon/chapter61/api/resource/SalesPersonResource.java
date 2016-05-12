package com.ramakhutla.ethon.chapter61.api.resource;

import com.ramakhutla.ethon.chapter61.domain.CustomerType;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ethon on 5/8/2016.
 */
public class SalesPersonResource implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private int hours;
    private double rate;
    private List<CustomerType> customertype;

    //constructors
    private SalesPersonResource()
    {

    }

    public SalesPersonResource(Builder builder)
    {
        this.id=builder.id;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.hours= builder.hours;
        this.rate=builder.rate;
        this.customertype=builder.customertype;
    }


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

    public int getHours() {
        return hours;
    }

    public double getRate() {
        return rate;
    }

    public List<CustomerType> getCustomerType() {
        return customertype;
    }

    //getters



    public static class Builder
    {
        private Long id;
        private String firstName;
        private String lastName;
        private int hours;
        private double rate;
        private List<CustomerType> customertype;

        public Builder lastName(String lastName)
        {
            this.lastName = lastName;
            return this;
        }

        public Builder firstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        public Builder hours(int hours)
        {
            this.hours = hours;
            return this;
        }

        public Builder rate(double rate)
        {
            this.rate = rate;
            return this;
        }


        public Builder customertype(List<CustomerType> customertype)
        {
            this.customertype = customertype;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(SalesPersonResource salespersontype)
        {
            this.id = salespersontype.id;
            this.firstName = salespersontype.firstName;
            this.lastName = salespersontype.lastName;
            this.hours = salespersontype.hours;
            this.rate = salespersontype.rate;
            this.customertype = salespersontype.customertype;

            return this;
        }

        public SalesPersonResource build()
        {
            return new SalesPersonResource(this);
        }
    }
}
