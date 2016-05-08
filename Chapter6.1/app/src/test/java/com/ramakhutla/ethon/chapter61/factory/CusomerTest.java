package com.ramakhutla.ethon.chapter61.factory;

import com.ramakhutla.ethon.chapter61.domain.CustomerType;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by Dillin on 4/19/2016.
 */
public class CusomerTest {



    @Test
    public void testCreateCustomer() throws Exception
    {
        CustomerType customerType = CustomerFactory.getCustomerType("Ramakhutla", "Ethon", "0766651268", "12 de jong straat", "Springbok", "8200", "eethon", "rramakhutla", null);
        Assert.assertEquals("Ramakhutla", customerType.getFirstName());
    }

    @Test
    public void testUpdateCustomer() throws Exception
    {
        CustomerType customerType = CustomerFactory.getCustomerType("Ramakhutla", "Ethon", "0766651268", "12 de jong straat", "Springbok", "8200", "eethon", "rramakhutla", null);
        CustomerType newcustomerType = new CustomerType
                .Builder()
                .copy(customerType)
                .phoneNumber("0813817755")
                .build();

        Assert.assertEquals("0766651268", customerType.getPhoneNumber());
        Assert.assertEquals("0813817755", newcustomerType.getPhoneNumber());
    }


}
