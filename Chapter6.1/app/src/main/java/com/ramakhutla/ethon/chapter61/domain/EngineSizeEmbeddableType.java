package com.ramakhutla.ethon.chapter61.domain;

import java.io.Serializable;

/**
 * Created by Dillin on 4/19/2016.
 */
public class EngineSizeEmbeddableType implements Serializable {

    private Long id;
    private String EngineSerialNumber;
    private String EngineSize;
    private String FuelType;

    private EngineSizeEmbeddableType()
    {

    }

    public EngineSizeEmbeddableType(Builder builder)
    {
        this.id = builder.id;
        this.EngineSerialNumber = builder.EngineSerialNumber;
        this.EngineSize = builder.EngineSize;
        this.FuelType = builder.FuelType;
    }

    public Long getId() {
        return id;
    }

    public String getEngineSerialNumber() {
        return EngineSerialNumber;
    }

    public String getEngineSize() {
        return EngineSize;
    }

    public String getFuelType() {
        return FuelType;
    }

    public static class Builder
    {
        private Long id;
        private String EngineSerialNumber;
        private String EngineSize;
        private String FuelType;

        public Builder EngineSerialNumber(String EngineSerialNumber)
        {
            this.EngineSerialNumber = EngineSerialNumber;
            return this;
        }

        public Builder EngineSize(String EngineSize)
        {
            this.EngineSize = EngineSize;
            return this;
        }

        public Builder FuelType(String FuelType)
        {
            this.FuelType = FuelType;
            return this;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }



        public Builder copy(EngineSizeEmbeddableType engineSizeEmbeddabletype)
        {
            this.id = engineSizeEmbeddabletype.id;
            this.EngineSerialNumber = engineSizeEmbeddabletype.EngineSerialNumber;
            this.EngineSize = engineSizeEmbeddabletype.EngineSize;
            this.FuelType = engineSizeEmbeddabletype.FuelType;
            return this;
        }

        public EngineSizeEmbeddableType build()
        {
            return new EngineSizeEmbeddableType(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EngineSizeEmbeddableType that = (EngineSizeEmbeddableType) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (EngineSerialNumber != null ? !EngineSerialNumber.equals(that.EngineSerialNumber) : that.EngineSerialNumber != null)
            return false;
        if (EngineSize != null ? !EngineSize.equals(that.EngineSize) : that.EngineSize != null)
            return false;
        return FuelType != null ? FuelType.equals(that.FuelType) : that.FuelType == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (EngineSerialNumber != null ? EngineSerialNumber.hashCode() : 0);
        result = 31 * result + (EngineSize != null ? EngineSize.hashCode() : 0);
        result = 31 * result + (FuelType != null ? FuelType.hashCode() : 0);
        return result;
    }
}
