package io.github.biezhi.java8.lambda.mytest;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author Rade
 * @Date 2021/2/4 22:00:00
 * @Description
 */
public class TestMain {
    @Test
    public void test1() {
        System.out.println("Hello");
    }

    ////////////////// 四大主要函数式接口 //////////////////

    @Test
    public void test2() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
//        numList.forEach(System.out::println);
        numList.stream()
                .filter(x -> x > 50)
                .forEach(System.out::println);
    }

    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    @Test
    public void test3() {
        String str = strHandler("testInfo", String::toUpperCase);
        System.out.println(str);
        String s = strHandler("  test info 123  ", String::trim);
        System.out.println(s);

    }

    public String strHandler(String str, Function<String, String> function) {
        return function.apply(str);
    }

    @Test
    public void test4() {
//        sayInfo("1112222333", x -> System.out.println(x));
        sayInfo("1112222333", System.out::println);
    }

    public void sayInfo(String str, Consumer<String> consumer) {
        consumer.accept(str);
    }

    @Test
    public void test5() {
        System.out.println(predicateNum(-5, x -> x > 0));
    }

    public boolean predicateNum(Integer num, Predicate<Integer> predicate) {
        return predicate.test(num);
    }

    ////////////////// 方法引用 //////////////////

    @Test
    public void test6() {
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("xxxxxxx");

        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("aaaaaaa");

        PrintStream printStream = System.out;
        Consumer<String> consumer3 = printStream::println;
        consumer3.accept("bbbbbb");
    }

    @Test
    public void myTest() {
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);
        numList.add(6);
        numList.add(7);

        for (Integer num : numList) {
//            if (num == 3) {
//                continue;
//            }
//            System.out.println(num);
            if (num != 3) {
                System.out.println(num);
            }
        }
    }
}
