package com.ramakhutla.ethon.chapter61.factory;

import com.ramakhutla.ethon.chapter61.domain.LoginEmbeddableType;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by Dillin on 4/19/2016.
 */
public class LoginTest {


    @Test
    public void testcreatelogin() throws Exception {

        LoginEmbeddableType login = LoginFactory.getLogin("211162213","123456");
        Assert.assertEquals("211162213",login.getUsername());
        Assert.assertEquals("123456",login.getPassword());

    }

    @Test
    public void testupdatelogin() throws Exception {

        LoginEmbeddableType login = LoginFactory.getLogin("211162213","123456");

        LoginEmbeddableType newlogin = new LoginEmbeddableType
                .Builder()
                .copy(login)
                .password("123457")
                .build();

        Assert.assertEquals("123456",login.getPassword());
        Assert.assertEquals("123457",newlogin.getPassword());


    }

}
