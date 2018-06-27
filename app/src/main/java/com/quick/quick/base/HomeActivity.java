package com.quick.quick.base;

import android.app.Activity;
import android.os.Bundle;


import com.quick.quick.R;

/**
 * Created by 蒋文龙 on 2018/6/25.
 *
 */

public class HomeActivity  extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home_layout);
    }
}
