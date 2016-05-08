package com.ramakhutla.ethon.chapter61.factory;

import com.ramakhutla.ethon.chapter61.domain.EngineSizeEmbeddableType;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by Dillin on 4/19/2016.
 */
public class EnginSizeTest {


    @Test
    public void testcreateEngineSize() throws Exception {

        EngineSizeEmbeddableType engine = EngineSizeFactory.getEngineSizeEmbeddable("123", "3L", "petrol");
        Assert.assertEquals("123", engine.getEngineSerialNumber());
        Assert.assertEquals("3L", engine.getEngineSize());
        Assert.assertEquals("petrol", engine.getFuelType());

    }

    @Test
    public void testupdateEngineSize() throws Exception {

        EngineSizeEmbeddableType engine = EngineSizeFactory.getEngineSizeEmbeddable("123", "3L", "petrol");

        EngineSizeEmbeddableType newengine = new EngineSizeEmbeddableType
                .Builder()
                .copy(engine)
                .FuelType("diesel")
                .build();

        Assert.assertEquals("petrol", engine.getFuelType());
        Assert.assertEquals("diesel", newengine.getFuelType());

    }



}
