package com.ramakhutla.ethon.chapter61.factory;

import com.ramakhutla.ethon.chapter61.domain.RentalType;
import com.ramakhutla.ethon.chapter61.domain.VehicleType;

import java.util.List;

/**
 * Created by Dillin on 4/19/2016.
 */
public class VehicleFactory {

    public static VehicleType getVehicle(String SerialNumber, String Make, String Model, String year,
                                         String RefcounterReading, String Gas, String MotorCondition,
                                         String EngineSerialNumber, String EngineSize, String FuelType,
                                         List<RentalType> rentalstype)
    {
        return new VehicleType.Builder()
                .SerialNumber(SerialNumber)
                .Make(Make)
                .Model(Model)
                .year(year)
                .vehicleConditiontype(VehicleConditionEmbeddableFactory.getVehicleConditionEmbeddable(RefcounterReading, Gas, MotorCondition))
                .engineSizeEmbeddabletype(EngineSizeFactory.getEngineSizeEmbeddable(EngineSerialNumber, EngineSize, FuelType))
                .rentalstype(rentalstype)
                .build();
    }


}
