package com.ramakhutla.ethon.chapter61.services;

import android.content.Intent;
import android.test.AndroidTestCase;

/**
 * Created by Ethon on 5/8/2016.
 */
public class SalesPersonServiceTest  extends AndroidTestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), SalesPersonService.class);
        intent.putExtra("firstName","owen");
        intent.putExtra("lastName", "cloete");
        intent.putExtra("hours", 6);
        intent.putExtra("rate", 5.0);
        this.getContext().startService(intent);

    }
}
