package com.radebit.chap01;

/**
 * @Author Rade
 * @Date 2021/3/19 20:10:10
 * @Description
 */
public class Demo08 {
    public static void main(String[] args) {
        Thread t = new Demo08Thread();
        t.start();
        System.out.println("main：" + Thread.currentThread().getName());
    }
}

class Demo08Thread extends Thread {
    public Demo08Thread() {
        System.out.println("构造方法：" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run：" + Thread.currentThread().getName());
    }
}
