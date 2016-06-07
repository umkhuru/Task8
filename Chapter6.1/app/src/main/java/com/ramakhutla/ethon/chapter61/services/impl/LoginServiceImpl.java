package com.ramakhutla.ethon.chapter61.services.impl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.ramakhutla.ethon.chapter61.api.resource.LoginResource;
import com.ramakhutla.ethon.chapter61.domain.LoginEmbeddableType;
import com.ramakhutla.ethon.chapter61.repository.LoginRepository;
import com.ramakhutla.ethon.chapter61.repository.impl.LoginRepositoryImpl;
import com.ramakhutla.ethon.chapter61.services.LoginService;

public class LoginServiceImpl extends Service implements LoginService {

    private IBinder localBinder = new RetrieveAccountInfoLocalBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    @Override
    public boolean isValiduser(LoginEmbeddableType login) {
        LoginRepository loginRepository = new LoginRepositoryImpl(getBaseContext());
        LoginEmbeddableType login1 = null;
        if (login1 == null)
            return false;
        else
            return true;
    }

    public class RetrieveAccountInfoLocalBinder extends Binder {
        public LoginServiceImpl getService() {
            return LoginServiceImpl.this;
        }
    }
}
