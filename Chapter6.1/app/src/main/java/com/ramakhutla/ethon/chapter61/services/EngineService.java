package com.ramakhutla.ethon.chapter61.services;

import android.content.Context;

import com.ramakhutla.ethon.chapter61.api.resource.EngineResource;
import com.ramakhutla.ethon.chapter61.domain.EngineSizeEmbeddableType;

/**
 * Created by Ethon on 5/8/2016.
 */
public interface EngineService {

    void addEngine(Context context, EngineResource engineResource);
    //void updateEngine(Context context, EngineSizeEmbeddableType engineSizeEmbeddableType);
    void deleteEngine(Context context, EngineResource engineResource);
}
