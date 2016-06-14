package com.test.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2016/5/24.
 */
public class DynamicProxy implements InvocationHandler {

    private Object object;

    public Object bindRelation(Object object) {
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        System.out.print("This is dynamic proxy.       ");
        Object result = method.invoke(object, args);
        return result;
    }
}
