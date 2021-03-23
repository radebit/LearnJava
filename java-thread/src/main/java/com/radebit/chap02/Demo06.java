package com.radebit.chap02;

/**
 * @Author Rade
 * @Date 2021/3/23 19:09:09
 * @Description 关键字synchronized 拥有锁重入的功能，就是说再使用synchronized 时，当一个线程得到一个对象锁后，再次请求这个对象锁时是可以再次得到该对象锁。
 * 可重入的锁也支持父子类继承的环境中。
 */
public class Demo06 {
    public static void main(String[] args) {
        Thread t = new Demo06Thread();
        t.start();
    }
}

class Demo06Service {
    synchronized public void foo1() {
        System.out.println("foo1方法");
        foo2();
    }

    synchronized public void foo2() {
        System.out.println("foo2方法");
        foo3();
    }

    synchronized public void foo3() {
        System.out.println("foo3方法");
    }
}

class Demo06Thread extends Thread {
    @Override
    public void run() {
//        Demo06Service demo06Service = new Demo06Service();
//        demo06Service.foo1();
        Demo06ServiceB demo06ServiceB = new Demo06ServiceB();
        demo06ServiceB.foo4();
    }
}

class Demo06ServiceB extends Demo06Service {
    synchronized public void foo4() {
        System.out.println("foo4方法");
        super.foo1();
    }
}