package com.radebit.chap01;

/**
 * @Author Rade
 * @Date 2021/3/21 22:59:59
 * @Description
 */
public class Demo13 {
    public static void main(String[] args) {
        System.out.println("主线程的优先级：" + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(8);
        System.out.println("设置主线程优先级后：" + Thread.currentThread().getPriority());
        Thread t = new Demo13Thread();
        t.start();
        System.out.println(Thread.currentThread().getId() + "--===---" + Thread.currentThread().getName());
    }
}

class Demo13Thread extends Thread {
    @Override
    public void run() {
        System.out.println("当前线程的优先级：" + this.getPriority());
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(this.getId() + "==" + this.getName());
        System.out.println(Thread.currentThread().getId() + "===" + Thread.currentThread().getName());
    }
}
