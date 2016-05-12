package com.ramakhutla.ethon.chapter61.api.resource;

import java.io.Serializable;

/**
 * Created by Ethon on 5/8/2016.
 */
public class LoginResource implements Serializable {

    private Long id;
    private String username;
    private String password;

    //constructors
    private LoginResource()
    {

    }

    public LoginResource(Builder builder)
    {
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
    }

    //getters
    public Long getId() {
        return id;
    }
    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public static class Builder
    {
        private Long id;
        private String username;
        private String password;

        public Builder username(String username)
        {
            this.username = username;
            return this;
        }

        public Builder password(String password)
        {
            this.password = password;
            return this;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder copy(LoginResource loginEmbedabletype)
        {
            this.id = loginEmbedabletype.id;
            this.username = loginEmbedabletype.username;
            this.password = loginEmbedabletype.password;
            return this;
        }

        public LoginResource build()
        {
            return new LoginResource(this);
        }
    }
}
