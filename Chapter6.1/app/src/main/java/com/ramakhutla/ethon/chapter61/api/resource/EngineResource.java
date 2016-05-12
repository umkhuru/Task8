package com.ramakhutla.ethon.chapter61.api.resource;

import java.io.Serializable;

/**
 * Created by Ethon on 5/8/2016.
 */
public class EngineResource implements Serializable {

    private Long id;
    private String EngineSerialNumber;
    private String EngineSize;
    private String FuelType;

    private EngineResource()
    {

    }

    public EngineResource(Builder builder)
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



        public Builder copy(EngineResource engineSizeEmbeddabletype)
        {
            this.id = engineSizeEmbeddabletype.id;
            this.EngineSerialNumber = engineSizeEmbeddabletype.EngineSerialNumber;
            this.EngineSize = engineSizeEmbeddabletype.EngineSize;
            this.FuelType = engineSizeEmbeddabletype.FuelType;
            return this;
        }

        public EngineResource build()
        {
            return new EngineResource(this);
        }
    }
}


