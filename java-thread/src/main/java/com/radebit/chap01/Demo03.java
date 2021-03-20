package com.radebit.chap01;

/**
 * @Author Rade
 * @Date 2021/3/17 14:11:11
 * @Description
 */
public class Demo03 {
    public static void main(String[] args) {
        Thread t = new Demo03Thread();
        t.start();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("运行Main方法：i=" + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Demo03Thread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("运行Run方法：i=" + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}