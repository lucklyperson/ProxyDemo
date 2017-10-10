package com.example.administrator.proxydemo;


import android.util.Log;

/**
 * Created by $wu on 2017-10-10 下午 12:05.
 */

public class ProxyDao implements IDao {

    private IDao dao;

    public ProxyDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public void method(String str, int age) {
        if (age > 10) {
            dao.method(str, age);
        } else {
            Log.e("111", "你的年龄稍微有点小哈");
        }

    }

}
