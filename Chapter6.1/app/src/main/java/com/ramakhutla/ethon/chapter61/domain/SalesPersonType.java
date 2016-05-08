package com.ramakhutla.ethon.chapter61.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dillin on 4/19/2016.
 */
public class SalesPersonType implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private int hours;
    private double rate;
    private List<CustomerType> customertype;

    //constructors
    private SalesPersonType()
    {

    }

    public SalesPersonType(Builder builder)
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

        public Builder copy(SalesPersonType salespersontype)
        {
            this.id = salespersontype.id;
            this.firstName = salespersontype.firstName;
            this.lastName = salespersontype.lastName;
            this.hours = salespersontype.hours;
            this.rate = salespersontype.rate;
            this.customertype = salespersontype.customertype;

            return this;
        }

        public SalesPersonType build()
        {
            return new SalesPersonType(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesPersonType that = (SalesPersonType) o;

        if (hours != that.hours) return false;
        if (Double.compare(that.rate, rate) != 0) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null)
            return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null)
            return false;
        return customertype != null ? customertype.equals(that.customertype) : that.customertype == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + hours;
        temp = Double.doubleToLongBits(rate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (customertype != null ? customertype.hashCode() : 0);
        return result;
    }
}
