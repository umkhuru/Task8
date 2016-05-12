package com.ramakhutla.ethon.chapter61.services;

import android.content.Context;

import com.ramakhutla.ethon.chapter61.api.resource.VehicleResource;


/**
 * Created by Ethon on 5/8/2016.
 */
public interface VehicleService {
    void addVehicle(Context context, VehicleResource vehicleResource);

    void deleteVehicle(Context context, VehicleResource vehicleResource);
}
