package com.test.sync;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

/**
 * Created by Administrator on 2016/5/31.
 */
public class ThreadMain implements Runnable {

    private SyncClass sc;

    private int c = 0;

    public void setSc(SyncClass sc){
        this.sc = sc;
        this.c = sc.cnt;
    }

    @Override
    public void run() {

        if (this.c == 1) {
            sc.one();
        }
        else {
            sc.two();
        }

    }
}
