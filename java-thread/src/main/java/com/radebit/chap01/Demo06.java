package com.radebit.chap01;

/**
 * @Author Rade
 * @Date 2021/3/17 20:18:18
 * @Description
 */
public class Demo06 {
    public static void main(String[] args) {
        Thread t1 = new Demo06Thread();
        Thread t2 = new Demo06Thread();
        Thread t3 = new Demo06Thread();
        Thread t4 = new Demo06Thread();
        Thread t5 = new Demo06Thread();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class Demo06Thread extends Thread {
    private int count = 5;

    @Override
    public void run() {
        while (count > 0) {
            System.out.println(Thread.currentThread().getName() + ":count=" + count);
            count--;
        }
    }
}
