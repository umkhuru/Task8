package com.ramakhutla.ethon.chapter61.services;

import android.content.Context;

import com.ramakhutla.ethon.chapter61.api.resource.AddressResource;
import com.ramakhutla.ethon.chapter61.domain.AddressEmbeddableType;

/**
 * Created by Ethon on 5/8/2016.
 */
public interface AddressService {

    void addAddress(Context context,AddressResource addressResource);

    void deleteAddress(Context context,  AddressResource addressResource);
}
