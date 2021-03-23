package com.radebit.chap02;

/**
 * @Author Rade
 * @Date 2021/3/23 18:50:50
 * @Description 当A线程调用使用synchronized 关键字修饰的方法时，A线程就获得到一个方法锁，准确来说获得到对象锁，所以其他线程必须等A线程执行完毕后才可以调用
 * 其他使用synchronized 修饰的方法。这是A线程已经执行完一个完整的任务，也就是说username和password两个成员变量已将被同时赋值了，所以不存在脏读的。
 */
public class Demo05 {
    public static void main(String[] args) throws InterruptedException {
        Demo05User demo05User = new Demo05User();
        Thread t = new Demo05Thread(demo05User);
        t.start();
        Thread.sleep(200);
        demo05User.getUsernameAndPassword();
    }
}

class Demo05User {
    private String username = "a";
    private String password = "aaaaa";

    synchronized public void setUsernameAndPassword(String username, String password) {
        this.username = username;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password = password;
        System.out.println("setUsernameAndPassword方法结束,线程名称=" + Thread.currentThread().getName() + ",username=" + username + ",password=" + password);
    }

    public void getUsernameAndPassword() {
        System.out.println("getUsernameAndPassword方法,线程名称=" + Thread.currentThread().getName() + ",username=" + username + ",password=" + password);
    }
}

class Demo05Thread extends Thread {
    private Demo05User demo05User;

    public Demo05Thread(Demo05User demo05User) {
        this.demo05User = demo05User;
    }

    @Override
    public void run() {
        demo05User.setUsernameAndPassword("b", "bbbbb");
    }
}