package com.ramakhutla.ethon.chapter61.services;

import android.content.Context;

import com.ramakhutla.ethon.chapter61.api.resource.CustomerResource;
import com.ramakhutla.ethon.chapter61.domain.CustomerType;

/**
 * Created by Ethon on 5/8/2016.
 */
public interface CustomerService {

    void addCustomer(Context context, CustomerResource customerResource);

    void deleteCustomer(Context context, CustomerResource customerResource);

}
