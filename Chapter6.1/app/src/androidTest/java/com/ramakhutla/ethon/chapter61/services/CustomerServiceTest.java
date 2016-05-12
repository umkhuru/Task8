package com.ramakhutla.ethon.chapter61.services;

import android.content.Intent;
import android.test.AndroidTestCase;

/**
 * Created by Ethon on 5/8/2016.
 */
public class CustomerServiceTest extends AndroidTestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), CustomerService.class);
        intent.putExtra("firstName","ramakhutla");
        intent.putExtra("lastName", "ethan");
        intent.putExtra("phoneNumber", "0766651268");
        this.getContext().startService(intent);

    }
}
