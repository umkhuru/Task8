package com.ramakhutla.ethon.chapter61.api;

import com.ramakhutla.ethon.chapter61.domain.AddressEmbeddableType;

import java.io.IOException;

/**
 * Created by Ethon on 5/8/2016.
 */
public interface AddressApi {

    AddressEmbeddableType createAddress(AddressEmbeddableType address) throws IOException;

    AddressEmbeddableType updateAddress(AddressEmbeddableType address) throws IOException;
}
