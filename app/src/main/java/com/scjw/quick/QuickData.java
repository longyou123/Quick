package com.scjw.quick;

import android.content.Context;
import android.content.SharedPreferences;

import com.scjw.quick.application.Application;

/**
 * Created by 蒋文龙 on 2018/6/28.
 * copyright：Copyright © 2015 - 2020. All Rights Reserved
 * description： 公共数据
 */

public class QuickData {
    private static QuickData database = null;

    private QuickData() {

    }

    public static QuickData instance() {
        if (database == null) {
            synchronized (QuickData.class) {
                database = new QuickData();
            }
        }
        return database;
    }

    /**
     * 缓存数据
     * Boolean
     * @param msg
     * @param type
     */
    public void saveCacheData(boolean msg, String type) {
        SharedPreferences sharedPreferences = Application.getInstance()
                .getSharedPreferences("appstorexml", Context.MODE_PRIVATE | Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(type, msg);
        editor.commit();
    }

    /**
     * 获取缓存数据
     * Boolean
     * @param type
     * @return
     */
    public boolean getCacheBData(String type) {
        SharedPreferences sharedPreferences = null;
        boolean mac;
        sharedPreferences = Application.getInstance().getSharedPreferences(
                "appstorexml", Context.MODE_PRIVATE | Context.MODE_MULTI_PROCESS);
        mac = sharedPreferences.getBoolean(type, false);
        return mac;
    }

    /**
     * 缓存数据
     * String
     * @param msg
     * @param type
     */
    public void saveCacheData(String msg, String type) {
        SharedPreferences sharedPreferences = Application.getInstance()
                .getSharedPreferences("appstorexml", Context.MODE_PRIVATE | Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(type, msg);
        editor.commit();
    }


    /**
     *获取缓存数据
     * String
     * @param type
     * @return
     */
    public String getCacheData(String type) {
        SharedPreferences sharedPreferences = null;
        String mac;
        sharedPreferences = Application.getInstance().getSharedPreferences(
                "appstorexml", Context.MODE_PRIVATE | Context.MODE_MULTI_PROCESS);
        mac = sharedPreferences.getString(type, "");
        return mac;
    }
}
