package com.test.proxy.dynamic;

import com.test.proxy.HelloWorldImpl;
import com.test.proxy.IHelloWorld;

/**
 * Created by Administrator on 2016/5/24.
 */
public class DynamicProxyTest {
    public static void main(String[] args) {

        IHelloWorld helloWorld = new HelloWorldImpl();
        helloWorld.print();

        DynamicProxy dynamicProxy = new DynamicProxy();
        IHelloWorld helloWorld1 = (IHelloWorld) dynamicProxy.bindRelation(helloWorld);

        helloWorld1.print();
    }
}
