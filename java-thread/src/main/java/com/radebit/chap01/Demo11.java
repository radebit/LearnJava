package com.radebit.chap01;

/**
 * @Author Rade
 * @Date 2021/3/20 13:47:47
 * @Description
 */
public class Demo11 {
    public static void main(String[] args) throws InterruptedException {
        Demo11Thread t = new Demo11Thread();
        t.start();
        Thread.sleep(1000);
        System.out.println("before_suspend_01:" + System.currentTimeMillis() + "=====" + t.getI());
        t.suspend();    // 暂停
        System.out.println("after_suspend_01:" + System.currentTimeMillis() + "=====" + +t.getI());
        Thread.sleep(1000);
        System.out.println("before_resume_01:" + System.currentTimeMillis() + "=====" + +t.getI());
        t.resume();     // 恢复
        Thread.sleep(1000);
        System.out.println("after_resume_01:" + System.currentTimeMillis() + "=====" + +t.getI());
        t.suspend();    // 再次暂停
        System.out.println("after_suspend_02_1:" + System.currentTimeMillis() + "=====" + +t.getI());
        Thread.sleep(1000);
        System.out.println("after_suspend_02_2:" + System.currentTimeMillis() + "=====" + +t.getI());
    }
}

class Demo11Thread extends Thread {
    int i = 1;

    @Override
    public void run() {
        while (true) {
            this.setI(this.getI() + 1);
        }
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}