package com.radebit.chap03;

/**
 * @Author Rade
 * @Date 2021/4/18 00:19:19
 * @Description join方法与异常
 * join与interrupt方法如果彼此遇到，则会出现异常，但进程并没有结束，原因是ThreadA还在继续运行，线程A并没有出现 异常，是正常状态下继续 执行。
 */
public class Demo16 {
    public static void main(String[] args) throws InterruptedException {
        Demo16ThreadB t = new Demo16ThreadB();
        t.start();
        Thread.sleep(10);
        Thread t2 = new Demo16ThreadC(t);
        t2.start();
    }
}

class Demo16ThreadA extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            // 耗时操作
            String s = new String();
            Math.random();
        }
        System.out.println("A线程结束");
    }
}

class Demo16ThreadB extends Thread {
    @Override
    public void run() {
        try {
            Thread t = new Demo16ThreadA();
            t.start();
            t.join();
            System.out.println("B线程正常结束");
        } catch (InterruptedException e) {
            System.out.println("B线程异常结束");
            e.printStackTrace();
        }
    }
}

class Demo16ThreadC extends Thread {
    private Demo16ThreadB t;

    public Demo16ThreadC(Demo16ThreadB t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.interrupt();
    }
}