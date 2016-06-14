package com.test.proxy;

import com.test.proxy.IHelloWorld;

/**
 * Created by Administrator on 2016/5/24.
 */
public class HelloWorldImpl implements IHelloWorld{

    public void print() {

        System.out.println("Hello world!");
    }
}

