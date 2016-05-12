package com.ramakhutla.ethon.chapter61.services;

import android.content.Context;

import com.ramakhutla.ethon.chapter61.api.resource.SalesPersonResource;

/**
 * Created by Ethon on 5/8/2016.
 */
public interface SalesPersonService {
    void addLogin(Context context, SalesPersonResource salesPersonResource);

    void deleteLogin(Context context, SalesPersonResource salesPersonResource);
}
