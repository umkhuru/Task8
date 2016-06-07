package com.ramakhutla.ethon.chapter61.services.impl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.ramakhutla.ethon.chapter61.api.resource.EngineResource;
import com.ramakhutla.ethon.chapter61.conf.GlobalContext;
import com.ramakhutla.ethon.chapter61.domain.EngineSizeEmbeddableType;
import com.ramakhutla.ethon.chapter61.repository.EngineSizeRepository;
import com.ramakhutla.ethon.chapter61.repository.impl.EngineSizeRepositoryImpl;
import com.ramakhutla.ethon.chapter61.services.EngineService;

import java.util.Set;

public class EnginServiceImpl extends Service implements EngineService {

    EngineSizeRepository repository;
    private static EnginServiceImpl service = null;

    public EnginServiceImpl()
    {
        repository = new EngineSizeRepositoryImpl(GlobalContext.getAppContext());
    }
    private final IBinder localBinder = new EngineServiceLocalBinder();

    public static EnginServiceImpl getInstance() {
        if (service == null)
            service = new EnginServiceImpl();
        return service;
    }

    @Override
    public boolean duplicateCheck(String EngineSize) {
        Set<EngineSizeEmbeddableType> engineSizeEmbeddableTypes;
        engineSizeEmbeddableTypes =   repository.findAll();

        for (EngineSizeEmbeddableType engineSizeEmbeddableType : engineSizeEmbeddableTypes)
        {
            if (engineSizeEmbeddableType.getEngineSize().trim().equalsIgnoreCase(EngineSize))
                return true;

        }
        return false;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class EngineServiceLocalBinder extends Binder {
        public EnginServiceImpl getService() {
            return EnginServiceImpl.this;
        }
    }
}
