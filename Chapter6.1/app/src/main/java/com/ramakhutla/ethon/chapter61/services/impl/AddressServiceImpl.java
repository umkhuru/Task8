package com.ramakhutla.ethon.chapter61.services.impl;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import com.ramakhutla.ethon.chapter61.api.AddressApi;
import com.ramakhutla.ethon.chapter61.api.impl.AddressApiImpl;
import com.ramakhutla.ethon.chapter61.api.resource.AddressResource;
import com.ramakhutla.ethon.chapter61.conf.util.App;
import com.ramakhutla.ethon.chapter61.domain.AddressEmbeddableType;
import com.ramakhutla.ethon.chapter61.repository.AddressRepository;
import com.ramakhutla.ethon.chapter61.repository.impl.AddressRepositoryImpl;
import com.ramakhutla.ethon.chapter61.services.AddressService;

/*
I am using the intent service why I am using it is that
I am doing normal cruds which works on the database and I dont not
need to use bound services because I am not looking for a quick respons I only
need to know data has been updated or deleted or even new data has been added.
*/
public class AddressServiceImpl extends IntentService implements AddressService{

    private final AddressRepository repository;


    private static final String ACTION_ADD = "com.ramakhutla.ethon.chapter61.services.impl.action.ADD";
    private static final String ACTION_UPDATE = "com.ramakhutla.ethon.chapter61.services.impl.action.UPDATE";
    private static final String ACTION_DELETE = "com.ramakhutla.ethon.chapter61.services.impl.action.DELETE ";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "com.ramakhutla.ethon.chapter61.services.impl.extra.ADD";
    private static final String EXTRA_UPDATE = "com.ramakhutla.ethon.chapter61.services.impl.extra.UPDATE";


    private static AddressServiceImpl service = null;

    public static AddressServiceImpl getInstance() {
        if (service == null)
            service = new AddressServiceImpl();
        return service;
    }

    public AddressServiceImpl() {
        super("AddressServiceImpl");
        repository = new AddressRepositoryImpl(App.getAppContext());

    }

    @Override
    public void addAddress(Context context, AddressResource addressResource) {
        Intent intent = new Intent(context, AddressServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, addressResource);
        context.startService(intent);
    }



    @Override
    public void deleteAddress(Context context, AddressResource addressResource) {
        Intent intent = new Intent(context, AddressServiceImpl.class);
        intent.setAction(ACTION_DELETE);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final AddressResource addressResource = (AddressResource) intent.getSerializableExtra(EXTRA_ADD);
                saveAddress(addressResource);
            }

            else if (ACTION_DELETE.equals(action)) {
                deleteAddressRecords();
            }
        }
    }

    private void deleteAddressRecords() {
        repository.deleteAll();
    }

    private void saveAddress(AddressResource addressResource) {
        AddressEmbeddableType addressEmbeddableType = new AddressEmbeddableType.Builder()
                .Address(addressResource.getAddress())
                .City(addressResource.getCity())
                .postalCode(addressResource.getPostalCode())
                .build();
        AddressEmbeddableType saveAddress = repository.save(addressEmbeddableType);

    }



}
