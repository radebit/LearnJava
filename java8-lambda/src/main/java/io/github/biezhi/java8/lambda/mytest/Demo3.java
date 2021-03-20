package io.github.biezhi.java8.lambda.mytest;

import java.util.function.Predicate;

/**
 * @Author Rade
 * @Date 2021/2/2 23:35:35
 * @Description
 */
public class Demo3 {
    public static void main(String[] args) {
        boolean b = checkNumBigThanZero(88, x -> x > 0);
        System.out.println(b);
    }

    public static boolean checkNumBigThanZero(Integer num, Predicate<Integer> predicate) {
        return predicate.test(num);
    }
}
