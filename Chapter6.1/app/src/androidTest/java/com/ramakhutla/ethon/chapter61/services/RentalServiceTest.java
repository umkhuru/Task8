package com.ramakhutla.ethon.chapter61.services;

import android.content.Intent;
import android.test.AndroidTestCase;

/**
 * Created by Ethon on 5/8/2016.
 */
public class RentalServiceTest  extends AndroidTestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), RentalService.class);
        intent.putExtra("pickUpDate","21-08-16");
        intent.putExtra("returnDate", "09-09-16");
        this.getContext().startService(intent);

    }
}
