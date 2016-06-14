package com.test.sync;

/**
 * Created by Administrator on 2016/5/31.
 */
public class SyncClass {

    public synchronized void one(){

        System.out.println("one ===  1");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("one === 2");
    }

    public synchronized  void two() {
        System.out.println("two ===  1");
    }

    public int cnt = 1;

    public static void main(String[] args) {
        SyncClass sc = new SyncClass();


        System.out.println("create thread 0ne");
        ThreadMain tm = new ThreadMain();
        sc.cnt = 1;
        tm.setSc(sc);

        System.out.println("create thread two");
        ThreadMain tm2 = new ThreadMain();
        sc.cnt = 2;
        tm2.setSc(sc);

        Thread t1 = new Thread(tm);
        Thread t2 = new Thread(tm2);

        System.out.println("thread run ============");
        t1.start();
        t2.start();
        //System.out.println("thread end");
    }
}
