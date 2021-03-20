package io.github.biezhi.java8.lambda.mytest;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @Author Rade
 * @Date 2021/1/26 11:17:17
 * @Description
 */
public class Demo01 {
    public static void main(String[] args) {
//        Consumer<String> consumer = System.out::println;
//        consumer.accept("测试");
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("函数式接口");
//            return x.compareTo(y);
            return Integer.compare(x, y);
        };

//        System.out.println(comparator.compare(10,2));
        System.out.println(Integer.compare(1, 5));
    }
}
