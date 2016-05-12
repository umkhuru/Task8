package com.ramakhutla.ethon.chapter61.services;

import android.content.Intent;
import android.test.AndroidTestCase;

/**
 * Created by Ethon on 5/8/2016.
 */
public class PaymentServiceTest  extends AndroidTestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), PaymentService.class);
        intent.putExtra("PaymentType","card");
        intent.putExtra("Price", "566.00");
        this.getContext().startService(intent);

    }
}
