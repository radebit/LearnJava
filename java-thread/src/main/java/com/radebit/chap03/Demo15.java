package com.radebit.chap03;

/**
 * @Author Rade
 * @Date 2021/4/18 00:07:07
 * @Description join方法
 * 方法join的作用就是使所属的线程对象x(子线程)执行run方法中的任务，而使得当前线程z(主线程)进行无限期的阻塞，
 * 等待线程x销毁后再继续 执行线程z后面的代码。方法join具有线程排队运行的作用，有些类似于同步代码运行的效果。
 * join与synchronized区别：join的内部使用wait方法进行等待，而synchronized关键字使用的是『对象锁』的机制作为同步。
 */
public class Demo15 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Demo15Thread();
        t.start();
        t.join();
        System.out.println("子线程结束后再执行");
    }
}

class Demo15Thread extends Thread {
    @Override
    public void run() {
        try {
            int value = 3000;
            System.out.println("需要等待" + value + "毫秒");
            Thread.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}