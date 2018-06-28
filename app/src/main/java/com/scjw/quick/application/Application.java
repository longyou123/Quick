package com.scjw.quick.application;

/**
 * Created by 蒋文龙 on 2018/6/28.
 */

public class Application extends android.app.Application{

    private static Application mInstance;
    public static Application getInstance() {
        return mInstance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
    }
}
