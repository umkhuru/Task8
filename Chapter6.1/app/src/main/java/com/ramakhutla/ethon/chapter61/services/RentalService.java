package com.ramakhutla.ethon.chapter61.services;

import android.content.Context;

import com.ramakhutla.ethon.chapter61.api.resource.RentalResource;

/**
 * Created by Ethon on 5/8/2016.
 */
public interface RentalService {
    void addRental(Context context, RentalResource rentalResource);

    void deleteRental(Context context, RentalResource rentalResource);

}
