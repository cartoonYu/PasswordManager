package com.example.cartoon.passwordmanager.Password.AddPassword;

import com.example.cartoon.passwordmanager.BaseActivity;
import com.example.cartoon.passwordmanager.Password.Main.Main;
import com.example.cartoon.passwordmanager.R;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by cartoon on 2018/1/29.
 */

public class AddPassword extends BaseActivity<AddPasswordPresenter> implements IAddPasswordContract.View,View.OnClickListener{
    private TextView back;
    private EditText decription;
    private EditText account;
    private EditText password;
    private TextView confirm;

    private String inputDecription;
    private String inputAccount;
    private String inputPassword;

    private Intent intent;



    public String getInputDecription(){
        inputDecription=decription.getText().toString();
        return inputDecription;
    }
    public String getInputAccount(){
        inputAccount=account.getText().toString();
        return inputAccount;
    }
    public String getInputPassword(){
        inputPassword=password.getText().toString();
        return inputPassword;

    }

    @Override
    protected AddPasswordPresenter initPresent() {
        return new AddPasswordPresenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.newpassword;
    }

    @Override
    protected void initView() {
        back=(TextView)findViewById(R.id.toolbarBack);
        decription=(EditText)findViewById(R.id.newPasswordDescription);
        account=(EditText)findViewById(R.id.newPasswordAccount);
        password=(EditText)findViewById(R.id.newPasswordPassword);
        confirm=(TextView)findViewById(R.id.toolbarTool1);
        confirm.setText("保存");
    }

    @Override
    protected void onPrepare() {
        back.setOnClickListener(this);
        confirm.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbarBack:{
                this.intent=new Intent(this, Main.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.toolbarTool1:{
                boolean flag=basePresenter.addPassword();
                if(flag){
                    this.intent=new Intent(this, Main.class);
                    startActivity(intent);
                    finish();
                }
                break;
            }
        }
    }

    @Override
    public void showToast(String code) {
        Toast.makeText(this,code,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onBackPressed(){
        this.intent=new Intent(this,Main.class);
        startActivity(intent);
        finish();
    }
}
