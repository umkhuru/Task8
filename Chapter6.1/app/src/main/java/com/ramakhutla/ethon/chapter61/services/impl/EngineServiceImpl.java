package com.ramakhutla.ethon.chapter61.services.impl;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import com.ramakhutla.ethon.chapter61.api.resource.EngineResource;
import com.ramakhutla.ethon.chapter61.conf.util.App;
import com.ramakhutla.ethon.chapter61.domain.EngineSizeEmbeddableType;
import com.ramakhutla.ethon.chapter61.repository.EngineSizeRepository;
import com.ramakhutla.ethon.chapter61.repository.impl.EngineSizeRepositoryImpl;
import com.ramakhutla.ethon.chapter61.services.EngineService;

/*
I am using the intent service why I am using it is that
I am doing normal cruds which works on the database and I dont not
need to use bound services because I am not looking for a quick respons I only
need to know data has been updated or deleted or even new data has been added.
*/
public class EngineServiceImpl extends IntentService implements EngineService{
    private final EngineSizeRepository repository;

    private static final String ACTION_ADD = "com.ramakhutla.ethon.chapter61.services.impl.action.ADD";

    private static final String ACTION_DELETE = "com.ramakhutla.ethon.chapter61.services.impl.action.DELETE ";

    // TODO: Rename parameters
    private static final String EXTRA_ADD = "com.ramakhutla.ethon.chapter61.services.impl.extra.ADD";


    private static EngineServiceImpl service = null;

    public static EngineServiceImpl getInstance() {
        if (service == null)
            service = new EngineServiceImpl();
        return service;
    }

    public EngineServiceImpl() {
        super("EngineServiceImpl");
        repository = new EngineSizeRepositoryImpl(App.getAppContext());

    }


    @Override
    public void addEngine(Context context, EngineResource engineResource) {
        Intent intent = new Intent(context, EngineServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, engineResource);
        context.startService(intent);

    }

    @Override
    public void deleteEngine(Context context,EngineResource engineResource) {
        Intent intent = new Intent(context, EngineServiceImpl.class);
        intent.putExtra(EXTRA_ADD, engineResource);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final EngineResource engineResource = (EngineResource) intent.getSerializableExtra(EXTRA_ADD);
                saveEngine(engineResource);
            } else if (ACTION_DELETE.equals(action)) {
                deleteEngineRecords();
            }
        }
    }

    private void deleteEngineRecords() {
        repository.deleteAll();
    }

    private void saveEngine(EngineResource engineResource) {
        EngineSizeEmbeddableType engineSizeEmbeddableType = new EngineSizeEmbeddableType.Builder()
                .EngineSerialNumber(engineResource.getEngineSerialNumber())
                .EngineSize(engineResource.getEngineSize())
                .FuelType(engineResource.getFuelType())
                .build();
        EngineSizeEmbeddableType saveEngine = repository.save(engineSizeEmbeddableType);

    }
}
