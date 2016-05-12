package com.ramakhutla.ethon.chapter61.services;

import android.content.Intent;
import android.test.AndroidTestCase;

/**
 * Created by Ethon on 5/8/2016.
 */
public class EngineServiceTest extends AndroidTestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), EngineService.class);
        intent.putExtra("EngineSerialNumber","1234");
        intent.putExtra("EngineSize", "m3");
        intent.putExtra("FuelType", "petrol");
        this.getContext().startService(intent);

    }
}
