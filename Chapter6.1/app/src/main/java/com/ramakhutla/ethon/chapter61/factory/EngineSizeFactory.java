package com.ramakhutla.ethon.chapter61.factory;

import com.ramakhutla.ethon.chapter61.domain.EngineSizeEmbeddableType;

/**
 * Created by Dillin on 4/19/2016.
 */
public class EngineSizeFactory {


    public static EngineSizeEmbeddableType getEngineSizeEmbeddable(String EngineSerialNumber, String EngineSize, String FuelType)
    {
        return new EngineSizeEmbeddableType.Builder()
                .EngineSerialNumber(EngineSerialNumber)
                .EngineSize(EngineSize)
                .FuelType(FuelType)
                .build();
    }

}
