package com.example.administrator.proxydemo;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by $wu on 2017-10-10 下午 12:04.
 */

public class Dao implements IDao {

    private Context context;

    public Dao(Context context) {
        this.context = context;
    }

    @Override
    public void method(String str, int age) {
        Toast.makeText(context, "method方法" + str, Toast.LENGTH_SHORT).show();
    }
}
