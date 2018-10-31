package com.skymxc.example.dagger2.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.skymxc.example.dagger2.R;
import com.skymxc.example.dagger2.ui.second.SecondActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements MainView,View.OnClickListener{


    @Inject MainPresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 要在  super.onCreate(savedInstanceState); 之前 因为 ---

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_to_second).setOnClickListener(this);
        findViewById(R.id.bt_to_third).setOnClickListener(this);

        presenter.loadMain();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_to_second:
                SecondActivity.start(this);
                break;
            case R.id.bt_to_third:

                break;
        }

    }

    @Override
    public void loaded() {
        Log.e(MainActivity.class.getSimpleName()+"","loaded->");
    }
}