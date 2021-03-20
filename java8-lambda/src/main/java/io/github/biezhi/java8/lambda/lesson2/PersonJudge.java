package io.github.biezhi.java8.lambda.lesson2;

/**
 * @Author Rade
 * @Date 2021/1/25 11:12:12
 * @Description
 */
public interface PersonJudge<T> {
    public boolean check(T t);
}
