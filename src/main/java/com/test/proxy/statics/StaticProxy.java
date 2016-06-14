package com.test.proxy.statics;

import com.test.proxy.IHelloWorld;

/**
 * Created by Administrator on 2016/5/24.
 */
public class StaticProxy implements  IHelloWorld {

    private IHelloWorld helloWorld;

    public StaticProxy(IHelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public void print() {
        System.out.print("I'm static proxy.  ");
        helloWorld.print();
    }
}
