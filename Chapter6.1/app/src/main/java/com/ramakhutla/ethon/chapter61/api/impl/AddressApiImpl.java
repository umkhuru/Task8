package com.ramakhutla.ethon.chapter61.api.impl;

import com.google.gson.Gson;
import com.ramakhutla.ethon.chapter61.api.AddressApi;
import com.ramakhutla.ethon.chapter61.conf.util.AppUtil;
import com.ramakhutla.ethon.chapter61.domain.AddressEmbeddableType;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Ethon on 5/8/2016.
 */
public class AddressApiImpl implements AddressApi{

    private static final String postUrl = AppUtil.getBaserURI() + "api/droid/address/address/post";
    private static final String updateUrl = AppUtil.getBaserURI() + "api/droid/address/address/update";

    @Override
    public AddressEmbeddableType createAddress(AddressEmbeddableType address) throws IOException {
        String json = new Gson().toJson(address);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);
        Request request = new Request.Builder()

                .url(postUrl)
                .post(body)
                .build();
        Response response = AppUtil.getConnection().newCall(request).execute();
        String value = response.body().string();
        AddressEmbeddableType pAddress = new Gson().fromJson(value, AddressEmbeddableType.class);
        return pAddress;
    }

    @Override
    public AddressEmbeddableType updateAddress(AddressEmbeddableType address) throws IOException {
        String json = new Gson().toJson(address);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);
        Request request = new Request.Builder()
                .url(updateUrl)
                .post(body)
                .build();
        Response response = AppUtil.getConnection().newCall(request).execute();
        String value = response.body().string();
        AddressEmbeddableType pAddress = new Gson().fromJson(value, AddressEmbeddableType.class);
        return pAddress;
    }
}
