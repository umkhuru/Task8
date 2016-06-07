package com.ramakhutla.ethon.chapter61.services;

import android.content.Intent;
import android.test.AndroidTestCase;

/**
 * Created by Ethon on 6/7/2016.
 */
public class AddAddressServiceTest extends AndroidTestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), AddressService.class);
        intent.putExtra("Address","e15-9th ave");
        intent.putExtra("City", "oranjemund");
        intent.putExtra("postalCode", "1624");
        this.getContext().startService(intent);

    }
}
