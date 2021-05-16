package org.loose.fis.sre.controllers;

public class UserModel {

    public String username;
    public String password;
    public String name;
    public String adress;
    public String phone;
    public int permissions;

    public UserModel()
    {

    }
    public UserModel( String username, String password, String name, String adress, String phone, int permissions) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.permissions = permissions;
    }
}
