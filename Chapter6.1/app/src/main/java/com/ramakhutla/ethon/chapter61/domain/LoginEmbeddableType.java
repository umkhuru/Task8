package com.ramakhutla.ethon.chapter61.domain;

import java.io.Serializable;

/**
 * Created by Dillin on 4/19/2016.
 */
public class LoginEmbeddableType implements Serializable {

    private Long id;
    private String username;
    private String password;

    //constructors
    private LoginEmbeddableType()
    {

    }

    public LoginEmbeddableType(Builder builder)
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

        public Builder copy(LoginEmbeddableType loginEmbedabletype)
        {
            this.id = loginEmbedabletype.id;
            this.username = loginEmbedabletype.username;
            this.password = loginEmbedabletype.password;
            return this;
        }

        public LoginEmbeddableType build()
        {
            return new LoginEmbeddableType(this);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginEmbeddableType that = (LoginEmbeddableType) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null)
            return false;
        return password != null ? password.equals(that.password) : that.password == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public String toString()
    {
        return String.format("Id : %d\nUsername :%s\nPassWord :%s",id,username,password);
    }
}
