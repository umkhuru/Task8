package com.ramakhutla.ethon.chapter61.factory;

import com.ramakhutla.ethon.chapter61.domain.SalesPersonType;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by Dillin on 4/19/2016.
 */
public class SalesPersonTest {


    /*@Test
    public void testCreateSalesPerson() throws Exception
    {
        SalesPersonType salesPerson= SalesPersonFactory.getSalesPerson("Ethon", "Owen", 9, 300.00, "pethon", "pj200K", null);

        Assert.assertEquals("Owen", salesPerson.getLastName());
    }

    @Test
    public void testUpdateSalesPerson() throws Exception
    {
        SalesPersonType salesPerson= SalesPersonFactory.getSalesPerson("Ethon", "Owen", 9, 300.00, "pethon", "pj200K", null);

        SalesPersonType newSalesPerson = new SalesPersonType
                .Builder()
                .copy(salesPerson)
                .firstName("Owen")
                .build();

        Assert.assertEquals("Ethon", salesPerson.getFirstName());
        Assert.assertEquals("Owen", newSalesPerson.getFirstName());
    }*/


}
