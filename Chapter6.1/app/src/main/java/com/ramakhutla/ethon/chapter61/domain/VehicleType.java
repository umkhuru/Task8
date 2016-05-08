package com.ramakhutla.ethon.chapter61.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dillin on 4/19/2016.
 */
public class VehicleType implements Serializable {

    private Long id;
    private String SerialNumber;
    private String Make;
    private String Model;
    private String year;
    private VehicleConditionEmbeddableType vehicleConditionEmbeddabletype;
    private EngineSizeEmbeddableType engineSizeEmbeddabletype;
    private List<RentalType> rentalstype;

    private VehicleType() {

    }

    public VehicleType(Builder builder) {
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

        public Builder copy(VehicleType vehicletype) {
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

        public VehicleType build() {
            return new VehicleType(this);
        }


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleType that = (VehicleType) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (SerialNumber != null ? !SerialNumber.equals(that.SerialNumber) : that.SerialNumber != null)
            return false;
        if (Make != null ? !Make.equals(that.Make) : that.Make != null) return false;
        if (Model != null ? !Model.equals(that.Model) : that.Model != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;
        if (vehicleConditionEmbeddabletype != null ? !vehicleConditionEmbeddabletype.equals(that.vehicleConditionEmbeddabletype) : that.vehicleConditionEmbeddabletype != null)
            return false;
        if (engineSizeEmbeddabletype != null ? !engineSizeEmbeddabletype.equals(that.engineSizeEmbeddabletype) : that.engineSizeEmbeddabletype != null)
            return false;
        return rentalstype != null ? rentalstype.equals(that.rentalstype) : that.rentalstype == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (SerialNumber != null ? SerialNumber.hashCode() : 0);
        result = 31 * result + (Make != null ? Make.hashCode() : 0);
        result = 31 * result + (Model != null ? Model.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (vehicleConditionEmbeddabletype != null ? vehicleConditionEmbeddabletype.hashCode() : 0);
        result = 31 * result + (engineSizeEmbeddabletype != null ? engineSizeEmbeddabletype.hashCode() : 0);
        result = 31 * result + (rentalstype != null ? rentalstype.hashCode() : 0);
        return result;
    }
}
