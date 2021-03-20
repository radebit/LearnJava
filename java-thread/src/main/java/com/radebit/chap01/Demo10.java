package com.radebit.chap01;

/**
 * @Author Rade
 * @Date 2021/3/19 21:39:39
 * @Description
 */
public class Demo10 {
    public static void main(String[] args) {
        User user = new User("a", "aa");
        Thread t = new Demo10Thread(user);
        t.start();
        try {
            Thread.sleep(500);
//            t.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main:" + user.toString());
    }
}

class Demo10Thread extends Thread {
    private User user;

    public Demo10Thread(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        System.out.println("before:" + this.user.toString());
        user.updateUsernameAndPassword("b", "bb");
        System.out.println("after:" + this.user.toString());
    }
}

class User {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    synchronized public void updateUsernameAndPassword(String username, String password) {
        this.username = username;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}