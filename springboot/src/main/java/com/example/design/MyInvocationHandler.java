package com.example.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

    Object obj;
    public Object blind(Object obj){

        this.obj=obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method方法的返回值时returnVal
        System.out.println("我是百变经纪人,我是都能干!!");

        Object returnVal = method.invoke(proxy, args);
        return returnVal;

    }
}
