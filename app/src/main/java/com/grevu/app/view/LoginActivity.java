package com.grevu.app.view;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.grevu.app.R;
import com.grevu.app.util.DataUtil;

/**
 * Created by jhkim on 2014-10-08.
 */
public class LoginActivity extends FragmentActivity {

    private static final String TAG = "LoginActivity";

    private FacebookFragment facebookFragment;
    private ImageView btn_twitter;
    private ImageView btn_grevu;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            // Add the fragment on initial activity setup
            facebookFragment = new FacebookFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(android.R.id.content, facebookFragment)
                    .commit();
        } else {
            // Or set the fragment from restored state info
            facebookFragment = (FacebookFragment) getSupportFragmentManager()
                    .findFragmentById(android.R.id.content);
        }

        setContentView(R.layout.activity_login);
        btn_twitter = (ImageView) findViewById(R.id.btn_twitter);
        btn_twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        btn_grevu = (ImageView) findViewById(R.id.btn_grevu);
        btn_grevu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    //로그인 상태일 때는 finish
    @Override
    public void onPause(){
        super.onPause();
        boolean isLogin = Boolean.parseBoolean(DataUtil.getPreferences(this, "isLogin"));

        if(isLogin){
            finish();
        }
    }

}