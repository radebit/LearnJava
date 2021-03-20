package io.github.biezhi.java8.lambda.mytest;

/**
 * @Author Rade
 * @Date 2021/2/2 23:09:09
 * @Description
 */
public class Demo2 {
    public static void main(String[] args) {
        Integer operation = operation(100, (x) -> x + 100);
        System.out.println(operation);
    }

    public static Integer operation(Integer num, MyFun<Integer> myFun) {
        return myFun.getValue(num);
    }
}
