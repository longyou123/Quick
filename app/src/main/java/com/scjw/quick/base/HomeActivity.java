package com.scjw.quick.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import com.scjw.quick.R;

/**
 * Created by 蒋文龙 on 2018/6/25.
 *
 */

public class HomeActivity  extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);

        new Thread(){

            @Override
            public void run() {
                super.run();
                try {
                    sleep(1500);

                    startActivity(new Intent(HomeActivity.this,WelcomeActivity.class));
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
    }
}