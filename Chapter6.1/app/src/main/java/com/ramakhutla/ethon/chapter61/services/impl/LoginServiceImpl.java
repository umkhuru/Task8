package com.ramakhutla.ethon.chapter61.services.impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import com.ramakhutla.ethon.chapter61.api.resource.LoginResource;
import com.ramakhutla.ethon.chapter61.conf.util.App;
import com.ramakhutla.ethon.chapter61.domain.LoginEmbeddableType;
import com.ramakhutla.ethon.chapter61.repository.LoginRepository;
import com.ramakhutla.ethon.chapter61.repository.impl.LoginRepositoryImpl;
import com.ramakhutla.ethon.chapter61.services.LoginService;

/*
I am using the intent service why I am using it is that
I am doing normal cruds which works on the database and I dont not
need to use bound services because I am not looking for a quick respons I only
need to know data has been updated or deleted or even new data has been added.
*/

public class LoginServiceImpl extends IntentService implements LoginService{
    private final LoginRepository repository;

    private static final String ACTION_ADD = "com.ramakhutla.ethon.chapter61.services.impl.action.ADD";

    private static final String ACTION_DELETE = "com.ramakhutla.ethon.chapter61.services.impl.action.DELETE ";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "com.ramakhutla.ethon.chapter61.services.impl.extra.ADD";


    private static LoginServiceImpl service = null;

    public static LoginServiceImpl getInstance() {
        if (service == null)
            service = new LoginServiceImpl();
        return service;
    }

    public LoginServiceImpl() {
        super("LoginServiceImpl");
        repository = new LoginRepositoryImpl(App.getAppContext());

    }




    @Override
    public void addLogin(Context context, LoginResource loginResource) {
        Intent intent = new Intent(context, LoginServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, loginResource);
        context.startService(intent);

    }

    @Override
    public void deleteLogin(Context context, LoginResource loginResource) {
        Intent intent = new Intent(context, LoginServiceImpl.class);
        intent.putExtra(EXTRA_ADD, loginResource);
        context.startService(intent);

    }




    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final LoginResource loginResource = (LoginResource) intent.getSerializableExtra(EXTRA_ADD);
                saveLogin(loginResource);
            } else if (ACTION_DELETE.equals(action)) {
                deleteLoginRecords();
            }
        }
    }

    private void deleteLoginRecords() {
        repository.deleteAll();
    }

    private void saveLogin( LoginResource loginResource) {
        LoginEmbeddableType loginEmbeddableType = new LoginEmbeddableType.Builder()
                .username(loginResource.getUsername())
                .password(loginResource.getPassword())
                .build();
        LoginEmbeddableType saveLogin = repository.save(loginEmbeddableType);

    }
}
