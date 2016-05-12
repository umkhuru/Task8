package com.ramakhutla.ethon.chapter61.services;

import android.content.Intent;
import android.test.AndroidTestCase;

/**
 * Created by Ethon on 5/8/2016.
 */
public class LoginServiceTest  extends AndroidTestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), LoginService.class);
        intent.putExtra("username","211162213");
        intent.putExtra("password", "mom");
        this.getContext().startService(intent);

    }
}
