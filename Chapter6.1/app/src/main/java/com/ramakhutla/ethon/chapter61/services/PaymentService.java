package com.ramakhutla.ethon.chapter61.services;

import android.content.Context;

import com.ramakhutla.ethon.chapter61.api.resource.PaymentResource;

/**
 * Created by Ethon on 5/8/2016.
 */
public interface PaymentService {

    void addPayment(Context context, PaymentResource paymentResource);

    void deletePayment(Context context, PaymentResource paymentResource);

}
