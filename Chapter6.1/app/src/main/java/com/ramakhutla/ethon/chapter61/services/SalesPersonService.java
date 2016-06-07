package com.ramakhutla.ethon.chapter61.services;

import android.content.Context;

import com.ramakhutla.ethon.chapter61.api.resource.SalesPersonResource;

/**
 * Created by Ethon on 5/8/2016.
 */
public interface SalesPersonService {

    void addSales(Context context, SalesPersonResource salesPersonResource);
    //void updateSales(Context context, SalesPersonResource salesPersonResource);
    void deleteSales(Context context, SalesPersonResource salesPersonResource);
}
