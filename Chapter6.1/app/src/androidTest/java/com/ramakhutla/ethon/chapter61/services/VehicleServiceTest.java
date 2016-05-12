package com.ramakhutla.ethon.chapter61.services;

import android.content.Intent;
import android.test.AndroidTestCase;

/**
 * Created by Ethon on 5/8/2016.
 */
public class VehicleServiceTest  extends AndroidTestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), VehicleService.class);
        intent.putExtra("SerialNumber","1234");
        intent.putExtra("Make", "BMW");
        intent.putExtra("Model", "3series");
        intent.putExtra("year", "2010");
        this.getContext().startService(intent);

    }
}
