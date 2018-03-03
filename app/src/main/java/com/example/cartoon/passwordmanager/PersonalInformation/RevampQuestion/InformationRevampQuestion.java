package com.example.cartoon.passwordmanager.PersonalInformation.RevampQuestion;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cartoon.passwordmanager.BaseActivity;
import com.example.cartoon.passwordmanager.Password.Main.Main;
import com.example.cartoon.passwordmanager.R;

/**
 * Created by cartoon on 2018/2/11.
 */

public class InformationRevampQuestion extends BaseActivity<InformationRevampQuestionPresenter>
        implements IInformationRevampQuestion.View, View.OnClickListener{
    private TextView back;
    private EditText question;
    private EditText answer;
    private TextView confirm;
    @Override
    protected int getLayout(){
        return R.layout.revampquestion;
    }
    @Override
    protected InformationRevampQuestionPresenter initPresent(){
        return new InformationRevampQuestionPresenter(this);
    }
    @Override
    protected void initView(){
        back=findViewById(R.id.toolbarBack);
        question=findViewById(R.id.revampQuestionQuestion);
        answer=findViewById(R.id.revampQuestionAnswer);
        confirm=findViewById(R.id.toolbarTool1);
        confirm.setText("确定");
    }
    @Override
    protected void onPrepare(){
        back.setOnClickListener(this);
        confirm.setOnClickListener(this);
    }
    @Override
    public void showToast(String code){
        Toast.makeText(this,code,Toast.LENGTH_SHORT).show();
    }
    @Override
    public String getInputQuestion(){
        return this.question.getText().toString();
    }
    @Override
    public String getInputAnswer(){
        return this.answer.getText().toString();
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.toolbarBack:{
                Intent intent=new Intent(this,Main.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.toolbarTool1:{
                boolean flag=basePresenter.getInput();
                if(flag){
                    Intent intent=new Intent(this,Main.class);
                    startActivity(intent);
                    finish();
                }
                break;
            }
        }
    }
    @Override
    public void onBackPressed(){
        Intent intent=new Intent(this,Main.class);
        startActivity(intent);
        finish();
    }
}
