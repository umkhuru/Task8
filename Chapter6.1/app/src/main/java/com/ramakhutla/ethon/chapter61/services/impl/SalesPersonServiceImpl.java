package com.ramakhutla.ethon.chapter61.services.impl;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import com.ramakhutla.ethon.chapter61.api.resource.SalesPersonResource;
import com.ramakhutla.ethon.chapter61.conf.util.App;
import com.ramakhutla.ethon.chapter61.domain.SalesPersonType;
import com.ramakhutla.ethon.chapter61.repository.impl.SalesPersonTypeRepositoryImpl;
import com.ramakhutla.ethon.chapter61.services.SalesPersonService;

/*
I am using the intent service why I am using it is that
I am doing normal cruds which works on the database and I dont not
need to use bound services because I am not looking for a quick respons I only
need to know data has been updated or deleted or even new data has been added.
*/
public class SalesPersonServiceImpl extends IntentService implements SalesPersonService{
    private final SalesPersonTypeRepositoryImpl repository;

    private static final String ACTION_ADD = "com.ramakhutla.ethon.chapter61.services.impl.action.ADD";

    private static final String ACTION_DELETE = "com.ramakhutla.ethon.chapter61.services.impl.action.DELETE ";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "com.ramakhutla.ethon.chapter61.services.impl.extra.ADD";


    private static SalesPersonServiceImpl service = null;

    public static SalesPersonServiceImpl getInstance() {
        if (service == null)
            service = new SalesPersonServiceImpl();
        return service;
    }

    public SalesPersonServiceImpl() {
        super("SalesPersonServiceImpl");
        repository = new SalesPersonTypeRepositoryImpl(App.getAppContext());
    }

    @Override
    public void addLogin(Context context, SalesPersonResource salesPersonResource) {
        Intent intent = new Intent(context, SalesPersonServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, salesPersonResource);
        context.startService(intent);

    }

    @Override
    public void deleteLogin(Context context, SalesPersonResource salesPersonResource) {
        Intent intent = new Intent(context, SalesPersonServiceImpl.class);
        intent.setAction(ACTION_DELETE);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final SalesPersonResource salesPersonResource = (SalesPersonResource) intent.getSerializableExtra(EXTRA_ADD);
                saveSalesPerson(salesPersonResource);
            } else if (ACTION_DELETE.equals(action)) {
                deleteSalesPersonRecords();
            }
        }

    }
    private void deleteSalesPersonRecords() {
        repository.deleteAll();
    }

    private void saveSalesPerson(SalesPersonResource salesPersonResource) {
        SalesPersonType salesPersonType = new SalesPersonType.Builder()
                .firstName(salesPersonResource.getFirstName())
                .lastName(salesPersonResource.getLastName())
                .hours(salesPersonResource.getHours())
                .rate(salesPersonResource.getRate())
                .build();
        SalesPersonType saveAddress = repository.save(salesPersonType);

    }

}
