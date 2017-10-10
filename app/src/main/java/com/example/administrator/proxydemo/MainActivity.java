package com.example.administrator.proxydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //静态代理
//        Dao dao = new Dao(this);
//        ProxyDao proxyDao = new ProxyDao(dao);
//        proxyDao.method("wzq", 20);

        //动态代理

        //目标对象
        IDao target = new Dao(this);
        //原始的类型
        Log.e("222", "class=" + target.getClass());

        //给目标对象，创建代理对象
        IDao proxy = (IDao) new ProxyFactory(target).getProxyInstance();

        proxy.method("张学友", 20);

    }
}
