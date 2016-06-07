package com.ramakhutla.ethon.chapter61.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.ramakhutla.ethon.chapter61.conf.GlobalContext;
import com.ramakhutla.ethon.chapter61.domain.EngineSizeEmbeddableType;
import com.ramakhutla.ethon.chapter61.factory.EngineSizeFactory;
import com.ramakhutla.ethon.chapter61.repository.EngineSizeRepository;
import com.ramakhutla.ethon.chapter61.repository.impl.EngineSizeRepositoryImpl;
import com.ramakhutla.ethon.chapter61.services.impl.EnginServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ethon on 5/8/2016.
 */
public class EngineServiceTest extends AndroidTestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(this.getContext(), VehicleService.class);
        intent.putExtra("SerialNumber","1234");
        intent.putExtra("Make", "BMW");
        intent.putExtra("Model", "3series");
        intent.putExtra("year", "2010");
        this.getContext().startService(intent);

    }
}
