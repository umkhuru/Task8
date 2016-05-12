package com.ramakhutla.ethon.chapter61.api.resource;

import com.ramakhutla.ethon.chapter61.domain.EngineSizeEmbeddableType;
import com.ramakhutla.ethon.chapter61.domain.RentalType;
import com.ramakhutla.ethon.chapter61.domain.VehicleConditionEmbeddableType;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ethon on 5/8/2016.
 */
public class VehicleResource implements Serializable {

    private Long id;
    private String SerialNumber;
    private String Make;
    private String Model;
    private String year;
    private VehicleConditionEmbeddableType vehicleConditionEmbeddabletype;
    private EngineSizeEmbeddableType engineSizeEmbeddabletype;
    private List<RentalType> rentalstype;

    private VehicleResource() {

    }

    public VehicleResource(Builder builder) {
        this.id = builder.id;
        this.SerialNumber = builder.SerialNumber;
        this.Make = builder.Make;
        this.Model = builder.Model;
        this.year = builder.year;
        this.vehicleConditionEmbeddabletype = builder.vehicleConditionEmbeddabletype;
        this.engineSizeEmbeddabletype = builder.engineSizeEmbeddabletype;
        this.rentalstype = builder.rentalstype;
    }

    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    public String getMake() {
        return Make;
    }

    public String getModel() {
        return Model;
    }

    public String getYear() {
        return year;
    }

    public VehicleConditionEmbeddableType getVehicleConditionEmbeddableType() {
        return vehicleConditionEmbeddabletype;
    }

    public EngineSizeEmbeddableType getEngineSizeEmbeddableType() {
        return engineSizeEmbeddabletype;
    }

    public List<RentalType> getRentalType() {
        return rentalstype;
    }


    public static class Builder {
        private Long id;
        private String SerialNumber;
        private String Make;
        private String Model;
        private String year;
        private VehicleConditionEmbeddableType vehicleConditionEmbeddabletype;
        // private MotorCycleStatusEmbeddable motorCycleStatusEmbeddable;
        private EngineSizeEmbeddableType engineSizeEmbeddabletype;
        private List<RentalType> rentalstype;


        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder SerialNumber(String SerialNumber) {
            this.SerialNumber = SerialNumber;
            return this;
        }

        public Builder Make(String Make) {
            this.Make = Make;
            return this;
        }

        public Builder Model(String Model) {
            this.Model = Model;
            return this;
        }

        public Builder year(String year) {
            this.year = year;
            return this;
        }

        public Builder vehicleConditiontype(VehicleConditionEmbeddableType vehicleConditionEmbeddabletype) {
            this.vehicleConditionEmbeddabletype = vehicleConditionEmbeddabletype;
            return this;
        }

        public Builder engineSizeEmbeddabletype(EngineSizeEmbeddableType engineSizeEmbeddabletype) {
            this.engineSizeEmbeddabletype = engineSizeEmbeddabletype;
            return this;
        }

        public Builder rentalstype(List<RentalType> rentalstype) {
            this.rentalstype = rentalstype;
            return this;
        }

        public Builder copy(VehicleResource vehicletype) {
            this.id = vehicletype.id;
            this.SerialNumber = vehicletype.SerialNumber;
            this.Make = vehicletype.Make;
            this.Model = vehicletype.Model;
            this.year = vehicletype.year;
            this.vehicleConditionEmbeddabletype = vehicletype.vehicleConditionEmbeddabletype;
            this.engineSizeEmbeddabletype = vehicletype.engineSizeEmbeddabletype;
            this.rentalstype = vehicletype.rentalstype;
            return this;
        }

        public VehicleResource build() {
            return new VehicleResource(this);
        }


    }
}
