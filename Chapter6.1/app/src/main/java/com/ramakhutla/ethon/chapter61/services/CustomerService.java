package com.ramakhutla.ethon.chapter61.services;

import android.content.Context;

import com.ramakhutla.ethon.chapter61.domain.CustomerType;

/**
 * Created by Ethon on 5/8/2016.
 */
public interface CustomerService {

    void addCustomer(Context context, CustomerType customerType);

    void updateCustomer(Context context, CustomerType customerType);
}
