package com.example.administrator.proxydemo;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by $wu on 2017-10-10 下午 1:44.
 * 代理工厂类
 */

public class ProxyFactory {

    //维护一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //给目标对象生成代理对象
    public Object getProxyInstance() {

        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Log.e("111", "开始事务1");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        Log.e("111", "开始事务2");
                        return returnValue;
                    }
                }
        );

    }

}
