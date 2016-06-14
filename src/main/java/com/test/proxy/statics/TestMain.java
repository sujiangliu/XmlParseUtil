package com.test.proxy.statics;

import com.test.proxy.HelloWorldImpl;
import com.test.proxy.IHelloWorld;

/**
 * Created by Administrator on 2016/5/24.
 */
public class TestMain {

    public static void main(String[] args) {

        IHelloWorld helloWorld = new HelloWorldImpl();
        helloWorld.print();


        IHelloWorld staticProxy = new StaticProxy(helloWorld);
        staticProxy.print();
    }
}
