package com.ramakhutla.ethon.chapter61.factory;

import com.ramakhutla.ethon.chapter61.domain.PaymentMethodType;

/**
 * Created by Dillin on 4/19/2016.
 */
public class PaymentMethodFactory {

    public static PaymentMethodType getPaymentMethod(String PaymentType, double Price)
    {
        return new PaymentMethodType.Builder()
                .PaymentType(PaymentType)
                .Price(Price)
                .build();
    }


}
