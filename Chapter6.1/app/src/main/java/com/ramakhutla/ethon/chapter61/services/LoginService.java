package com.ramakhutla.ethon.chapter61.services;

import android.content.Context;

import com.ramakhutla.ethon.chapter61.api.resource.LoginResource;
import com.ramakhutla.ethon.chapter61.domain.LoginEmbeddableType;

/**
 * Created by Ethon on 5/8/2016.
 */
public interface LoginService {

    boolean isValiduser(LoginEmbeddableType login);


    //boolean isValiduser(LoginEmbeddableType mylogin);
}
