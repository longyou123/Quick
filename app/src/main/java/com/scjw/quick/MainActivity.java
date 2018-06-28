package com.scjw.quick;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.scjw.quick.base.BaseActivity;

public class MainActivity extends BaseActivity {
    private Button add;
    private Button toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button) findViewById(R.id.add);
        toast = (Button) findViewById(R.id.toast);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(MainActivity.this,"这是对话框");
            }
        });
    }




}
