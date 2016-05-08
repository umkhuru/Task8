package com.ramakhutla.ethon.chapter61.conf.security;

import org.mindrot.jbcrypt.BCrypt;
/**
 * Created by Ethon on 5/8/2016.
 */
public class LoginSecurity {

    public static boolean checkLogin(String username, String password) {


        return BCrypt.checkpw(password, "hashed");
    }
}
