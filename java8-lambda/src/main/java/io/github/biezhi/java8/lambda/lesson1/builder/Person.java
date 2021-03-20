package io.github.biezhi.java8.lambda.lesson1.builder;

import lombok.Builder;
import lombok.Data;

/**
 * @Author Rade
 * @Date 2021/1/23 15:51:51
 * @Description
 */
@Data
@Builder
public class Person {
    private String name;

    private Integer age;

    private Integer stars;

    private String birth;
}
