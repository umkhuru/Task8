package com.ramakhutla.ethon.chapter61.services;

import android.content.Context;

import com.ramakhutla.ethon.chapter61.api.resource.LoginResource;

/**
 * Created by Ethon on 5/8/2016.
 */
public interface LoginService {

    void addLogin(Context context, LoginResource loginResource);

    void deleteLogin(Context context, LoginResource loginResource);


}
