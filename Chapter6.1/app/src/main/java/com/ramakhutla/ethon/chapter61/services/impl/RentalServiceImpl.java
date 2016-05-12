package com.ramakhutla.ethon.chapter61.services.impl;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import com.ramakhutla.ethon.chapter61.api.resource.RentalResource;
import com.ramakhutla.ethon.chapter61.conf.util.App;
import com.ramakhutla.ethon.chapter61.domain.RentalType;
import com.ramakhutla.ethon.chapter61.repository.RentalTypeRepository;
import com.ramakhutla.ethon.chapter61.repository.impl.RentalTypeRepositoryImpl;
import com.ramakhutla.ethon.chapter61.services.RentalService;

/*
I am using the intent service why I am using it is that
I am doing normal cruds which works on the database and I dont not
need to use bound services because I am not looking for a quick respons I only
need to know data has been updated or deleted or even new data has been added.
*/
public class RentalServiceImpl extends IntentService implements RentalService{
    private final RentalTypeRepository repository;

    private static final String ACTION_ADD = "com.ramakhutla.ethon.chapter61.services.impl.action.ADD";

    private static final String ACTION_DELETE = "com.ramakhutla.ethon.chapter61.services.impl.action.DELETE ";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "com.ramakhutla.ethon.chapter61.services.impl.extra.ADD";


    private static RentalServiceImpl service = null;

    public static RentalServiceImpl getInstance() {
        if (service == null)
            service = new RentalServiceImpl();
        return service;
    }

    public RentalServiceImpl() {
        super("AddressServiceImpl");
        repository = new RentalTypeRepositoryImpl(App.getAppContext());
    }

    @Override
    public void addRental(Context context, RentalResource rentalResource) {
        Intent intent = new Intent(context, RentalServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, rentalResource);
        context.startService(intent);

    }

    @Override
    public void deleteRental(Context context, RentalResource rentalResource) {
        Intent intent = new Intent(context, RentalServiceImpl.class);
        intent.setAction(ACTION_DELETE);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final RentalResource rentalResource = (RentalResource) intent.getSerializableExtra(EXTRA_ADD);
                saveRental(rentalResource);
            } else if (ACTION_DELETE.equals(action)) {
                deleteRentalRecords();
            }
        }

    }

    private void deleteRentalRecords() {
        repository.deleteAll();
    }

    private void saveRental(RentalResource rentalResource) {
        RentalType rentalType = new RentalType.Builder()
                .pickUpDate(rentalResource.getPickUpDate())
                .returnDate(rentalResource.getReturnDate())
                .build();
        RentalType saveRental = repository.save(rentalType);

    }
}
