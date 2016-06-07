package com.ramakhutla.ethon.chapter61.conf;

import android.app.Application;
import android.content.Context;

/**
 * Created by Ethon on 6/7/2016.
 */
public class GlobalContext extends Application {

    public static Context context;

    private static GlobalContext singleton;

    public void onCreate() {
        super.onCreate();
        GlobalContext.context = getApplicationContext();
        singleton = this;
    }

    public static Context getAppContext() {
        return GlobalContext.context;
    }

    public static synchronized GlobalContext getInstance() {
        return singleton;
    }
}
