package com.scjw.quick;

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

}
