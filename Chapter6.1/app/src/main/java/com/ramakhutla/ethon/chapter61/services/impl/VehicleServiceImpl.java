package com.ramakhutla.ethon.chapter61.services.impl;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import com.ramakhutla.ethon.chapter61.api.resource.VehicleResource;
import com.ramakhutla.ethon.chapter61.conf.util.App;
import com.ramakhutla.ethon.chapter61.domain.VehicleType;
import com.ramakhutla.ethon.chapter61.repository.VehicleTypeRepository;
import com.ramakhutla.ethon.chapter61.repository.impl.VehicleTypeRepositoryImpl;
import com.ramakhutla.ethon.chapter61.services.VehicleService;

/*
I am using the intent service why I am using it is that
I am doing normal cruds which works on the database and I dont not
need to use bound services because I am not looking for a quick respons I only
need to know data has been updated or deleted or even new data has been added.
*/
public class VehicleServiceImpl extends IntentService implements VehicleService{
    private final VehicleTypeRepository repository;

    private static final String ACTION_ADD = "com.ramakhutla.ethon.chapter61.services.impl.action.ADD";

    private static final String ACTION_DELETE = "com.ramakhutla.ethon.chapter61.services.impl.action.DELETE ";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "com.ramakhutla.ethon.chapter61.services.impl.extra.ADD";


    private static VehicleServiceImpl service = null;

    public static VehicleServiceImpl getInstance() {
        if (service == null)
            service = new VehicleServiceImpl();
        return service;
    }

    public VehicleServiceImpl() {
        super("VehicleServiceImpl");
        repository = new VehicleTypeRepositoryImpl(App.getAppContext());
    }



    @Override
    public void addVehicle(Context context, VehicleResource vehicleResource) {
        Intent intent = new Intent(context, VehicleServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, vehicleResource);
        context.startService(intent);

    }

    @Override
    public void deleteVehicle(Context context, VehicleResource vehicleResource) {
        Intent intent = new Intent(context, VehicleServiceImpl.class);
        intent.setAction(ACTION_DELETE);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final VehicleResource vehicleResource = (VehicleResource) intent.getSerializableExtra(EXTRA_ADD);
                saveVehicle(vehicleResource);
            } else if (ACTION_DELETE.equals(action)) {
                deleteVehicleRecords();
            }
        }

    }
    private void deleteVehicleRecords() {
        repository.deleteAll();
    }

    private void saveVehicle(VehicleResource vehicleResource) {
        VehicleType vehicleType = new VehicleType.Builder()
                .SerialNumber(vehicleResource.getSerialNumber())
                .Make(vehicleResource.getMake())
                .Model(vehicleResource.getModel())
                .year(vehicleResource.getYear())
                .build();
        VehicleType saveVehicle = repository.save(vehicleType);

    }

}
