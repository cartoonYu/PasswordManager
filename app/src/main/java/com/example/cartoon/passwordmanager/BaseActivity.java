package com.example.cartoon.passwordmanager;

import android.app.Activity;
import android.os.Bundle;

import com.example.cartoon.passwordmanager.BasePresenter;

/**
 * Created by cartoon on 2018/1/27.
 */

public abstract class BaseActivity<T extends BasePresenter> extends Activity{
    protected T basePresenter;
    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(getLayout());
        initView();
        basePresenter=initPresent();
        onPrepare();
    }
    protected abstract T initPresent();
    protected abstract int getLayout();
    protected abstract void initView();
    protected abstract void onPrepare();
}
