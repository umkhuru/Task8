package com.ramakhutla.ethon.chapter61.factory;

import com.ramakhutla.ethon.chapter61.domain.VehicleConditionEmbeddableType;

/**
 * Created by Dillin on 4/19/2016.
 */
public class VehicleConditionEmbeddableFactory {

    public static VehicleConditionEmbeddableType getVehicleConditionEmbeddable(String RefcounterReading, String Gas, String MotorCondition)
    {
        return new VehicleConditionEmbeddableType.Builder()
            .RefcounterReading(RefcounterReading)
            .Gas(Gas)
            .MotorCondition(MotorCondition)
            .build();
    }

}
