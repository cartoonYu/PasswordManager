package com.example.cartoon.passwordmanager.data;

import org.litepal.crud.DataSupport;

/**
 * Created by cartoon on 2018/1/27.
 */

public class Password extends DataSupport{
    private String name;
    private String account;
    private String password;
    public Password(String name,String account,String password){
        this.name=name;
        this.account=account;
        this.password=password;
    }

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }
}
