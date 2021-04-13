package com.radebit.chap02;

/**
 * 线程A的锁是123，50ms后线程B得到的锁是456，所以线程之间就是异步。如果我们没有Thread.sleep(50)，线程A和线程B的锁都是123，虽然代码里将锁改成了456，
 * 但是结果还是同步，因为线程A和线程B争抢的锁是123，而不是456。
 */
public class Demo24 {
    public static void main(String[] args) throws InterruptedException {
        Demo24Service service = new Demo24Service();
        Thread t1 = new Demo24Thread(service);
        t1.setName("A");
        t1.start();

        Thread.sleep(50);

        Thread t2 = new Demo24Thread(service);
        t2.setName("B");
        t2.start();
    }
}

class Demo24Service{
    private String lockObject = "123";

    public void foo(){
        try {
            synchronized (lockObject) {
                System.out.println(Thread.currentThread().getName() + "开始于" + System.currentTimeMillis());
                lockObject = "456";
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "结束于" + System.currentTimeMillis());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Demo24Thread extends Thread{
    private Demo24Service service;
    public Demo24Thread(Demo24Service service){
        this.service = service;
    }

    @Override
    public void run() {
        service.foo();
    }
}