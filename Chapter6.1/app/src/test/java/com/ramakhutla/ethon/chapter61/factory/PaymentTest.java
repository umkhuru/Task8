package com.ramakhutla.ethon.chapter61.factory;

import com.ramakhutla.ethon.chapter61.domain.PaymentMethodType;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by Dillin on 4/19/2016.
 */
public class PaymentTest {


    @Test
    public void testCreatePayment() throws Exception
    {
        PaymentMethodType paymentMethod = PaymentMethodFactory.getPaymentMethod("Credit", 300.00);
        Assert.assertEquals(300.00, paymentMethod.getPrice(), 0.2f);
    }

    @Test
    public void testUpdatePayment() throws Exception
    {
        PaymentMethodType paymentMethod = PaymentMethodFactory.getPaymentMethod("Credit", 300.00);

        PaymentMethodType newPaymentMethod = new PaymentMethodType
                .Builder()
                .copy(paymentMethod)
                .Price(800.00)
                .build();

        Assert.assertEquals(300.00, paymentMethod.getPrice(), 0.2f);
        Assert.assertEquals(800.00,newPaymentMethod.getPrice(), 0.2f);
    }










    /*
    @Test
    public void testCreate() throws Exception {
        Settings settings = SettingsFactory.getSettings("test@test.com","USEM");
        Assert.assertEquals("test@test.com",settings.getUsername());

    }

    @Test
    public void testUpdate() throws Exception {
        Settings settings = SettingsFactory.getSettings("test@test.com","USEM");
        Settings newSettings = new Settings
                .Builder()
                .copy(settings)
                .username("test@t.com")
                .build();
        Assert.assertEquals("test@t.com",newSettings.getUsername());
        Assert.assertEquals("USEM",newSettings.getCode());

    }*/

}
