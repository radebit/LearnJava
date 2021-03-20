package io.github.biezhi.java8.lambda.mytest;

/**
 * @Author Rade
 * @Date 2021/2/2 23:11:11
 * @Description
 */
@FunctionalInterface
public interface MyFun<T> {
    public Integer getValue(T t);
}
