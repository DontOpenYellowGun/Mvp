package com.sven.mvp.model;

/**
 * Created by Sven on 2016/9/12 0012.
 */

public class UserModel {

    String name;
    String passWord;

    public UserModel(String name, String passWord) {
        this.name = name;
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
