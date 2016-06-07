package com.ramakhutla.ethon.chapter61.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.ramakhutla.ethon.chapter61.domain.LoginEmbeddableType;
import com.ramakhutla.ethon.chapter61.services.impl.LoginServiceImpl;

import junit.framework.Assert;

/**
 * Created by Ethon on 5/8/2016.
 */
public class LoginServiceTest  extends AndroidTestCase {

    private LoginService loginService;
    private boolean isBound;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), LoginServiceImpl.class);
        this.getContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);

    }

    public ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            LoginServiceImpl.RetrieveAccountInfoLocalBinder binder
                    = (LoginServiceImpl.RetrieveAccountInfoLocalBinder) service;
            loginService = binder.getService();

            isBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

    public void testLogin() throws Exception {

        LoginEmbeddableType login = new LoginEmbeddableType.Builder()
                .username("Ethon")
                .password("Rama")
                .build();

        boolean isValid = loginService.isValiduser(login);

        Assert.assertFalse(isValid);

    }
}
