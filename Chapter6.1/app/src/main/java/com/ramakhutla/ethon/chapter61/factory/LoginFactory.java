package com.ramakhutla.ethon.chapter61.factory;

import com.ramakhutla.ethon.chapter61.domain.LoginEmbeddableType;

/**
 * Created by Dillin on 4/19/2016.
 */
public class LoginFactory {


    public static LoginEmbeddableType getLogin(String username, String password)
    {
        return new LoginEmbeddableType.Builder()
                .username(username)
                .password(password)
                .build();
    }















    /*public static Settings getSettings(String email,String orgCode,String password){
        return new Settings.Builder()
                .username(email)
                .password(password)
                .code(orgCode)
                .build();

    }*/
}
