package com.example.cartoon.passwordmanager.Password.Revamp;

import com.example.cartoon.passwordmanager.data.TablePassword.Password;

/**
 * Created by cartoon on 2018/2/13.
 */

interface IPasswordRevamp {
    interface View{
        void handleClickBack(int flag);
        void handleClickSave();
        void showToast(String code);
        String getName();
        String getAccount();
        String getPassword();
        Password getOldPassword();
    }
    interface Presenter{
        void getInput();
    }
}
