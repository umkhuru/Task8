package com.ramakhutla.ethon.chapter61.factory;

import com.ramakhutla.ethon.chapter61.domain.LoginEmbeddableType;

/**
 * Created by Dillin on 4/19/2016.
 */
public class LoginFactory {


    public static LoginEmbeddableType getLogin(String username, String password)
    {
         LoginEmbeddableType mylogin = new LoginEmbeddableType.Builder()
                .username(username)
                .password(password)
                .build();

        return mylogin;
    }

}
