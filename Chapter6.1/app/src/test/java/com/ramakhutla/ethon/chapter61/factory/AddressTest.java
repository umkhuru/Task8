package com.ramakhutla.ethon.chapter61.factory;

import com.ramakhutla.ethon.chapter61.domain.AddressEmbeddableType;

import junit.framework.Assert;


import org.junit.Test;

/**
 * Created by Dillin on 4/19/2016.
 */
public class AddressTest {

    @Test
    public void testcreateAddress() throws Exception {

        AddressEmbeddableType addressEmbeddableType = AddressFactory.getAddressEmbeddableType("E15-9th AVE", "Oranjemund", "9000");
        Assert.assertEquals("E15-9th AVE", addressEmbeddableType.getAddress());
        Assert.assertEquals("Oranjemund", addressEmbeddableType.getCity());
        Assert.assertEquals("9000", addressEmbeddableType.getPostalCode());

    }

    @Test
    public void testupdateAddress() throws Exception {

        AddressEmbeddableType addressEmbeddableType = AddressFactory.getAddressEmbeddableType("E15-9th AVE", "Oranjemund", "9000");

        AddressEmbeddableType newaddressEmbeddableType = new AddressEmbeddableType
                .Builder()
                .copy(addressEmbeddableType)
                .postalCode("8000")
                .build();

        Assert.assertEquals("9000", addressEmbeddableType.getPostalCode());
        Assert.assertEquals("8000", newaddressEmbeddableType.getPostalCode());

    }

}
