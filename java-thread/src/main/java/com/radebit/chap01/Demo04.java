package com.radebit.chap01;

/**
 * @Author Rade
 * @Date 2021/3/17 14:38:38
 * @Description
 */
public class Demo04 {
    public static void main(String[] args) {
        Thread t1 = new Demo04Thread(1);
        Thread t2 = new Demo04Thread(2);
        Thread t3 = new Demo04Thread(3);
        Thread t4 = new Demo04Thread(4);
        Thread t5 = new Demo04Thread(5);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class Demo04Thread extends Thread {
    private final int val;
    public Demo04Thread(int val) {
        this.val = val;
    }

    @Override
    public void run() {
        System.out.println("val:" + val);
    }
}
