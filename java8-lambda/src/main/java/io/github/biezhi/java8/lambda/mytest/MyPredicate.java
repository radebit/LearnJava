package io.github.biezhi.java8.lambda.mytest;

/**
 * @Author Rade
 * @Date 2021/2/2 23:05:05
 * @Description 函数式接口
 */
@FunctionalInterface
public interface MyPredicate<T> {
    public boolean test(T t);
}
