package com.ramakhutla.ethon.chapter61.factory;

import com.ramakhutla.ethon.chapter61.domain.PaymentMethodType;
import com.ramakhutla.ethon.chapter61.domain.RentalType;

import java.util.List;

/**
 * Created by Dillin on 4/19/2016.
 */
public class RentalFactory {

    public static RentalType getRental(String pickUpdate, String returnDate, List<PaymentMethodType> paymentMethodtype)
    {
        return new RentalType.Builder()
                .pickUpDate(pickUpdate)
                .returnDate(returnDate)
                .paymentMethod(paymentMethodtype)
                .build();
    }

}
