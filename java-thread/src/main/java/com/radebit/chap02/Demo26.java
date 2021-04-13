package com.radebit.chap02;

/**
 * volatile主要作用是使变量可以在多个线程间可见。
 *
 * volatile是线程同步的轻量级实现，它的性能比synchronized要好，并且volatile只能修饰变量。而synchronized可以修饰方法及代码块。
 * 随着JDK的版本更新，synchronized在执行效率上也得到了很大的提升，因此在实际开发中synchronized的使用率还是比较高的。
 *
 * 多线程访问volatile不会发生阻塞，而synchronized会出现阻塞。
 *
 * volatile能保证数据的可见性，但是不能保证原子性，可能会出现脏读，而synchronized可以保证原子性，也可以间接保证可见性，
 * 因为它会将私有内存和公关内存中的数据做同步。
 *
 * volatile解决的是变量在多个线程间的可见性，而synchronized是解决多个线程之间访问资源的同步性。
 */
public class Demo26 {
    public static void main(String[] args) throws InterruptedException {
        Demo26Service service = new Demo26Service();
//        service.foo();
        service.start();
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + "准备停止foo方法的循环");
        service.flag = false;
    }
}

class Demo26Service extends Thread{
    // 标志，控制循环
    volatile public boolean flag = true;

    public void run(){
        foo();
    }

    public void foo(){
        System.out.println("foo开始运行");
        while(flag) {

        }
        System.out.println("foo运行结束");
    }
}