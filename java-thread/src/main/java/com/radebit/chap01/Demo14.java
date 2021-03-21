package com.radebit.chap01;

/**
 * @Author Rade
 * @Date 2021/3/21 23:38:38
 * @Description
 */
public class Demo14 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Demo14Thread();
        t.setDaemon(true);      // 把指定线程设定为守护线程
        t.start();
        Thread.sleep(3000);
        System.out.println("主线程结束了！");

    }
}

class Demo14Thread extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("time:" + System.currentTimeMillis());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
