package io.github.biezhi.java8.lambda.lesson1.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Rade
 * @Date 2021/1/23 15:53:53
 * @Description
 */
public class DemoMain {
    public static void main(String[] args) {
        // 用builder模式创建对象集合
        List<Person> personList = new ArrayList<>();
        // 添加对象到集合
        personList.add(
                Person.builder()
                        .name("张三")
                        .age(18)
                        .birth("2020-10-10")
                        .build()
        );

        personList.add(
                Person.builder()
                        .name("李四")
                        .age(20)
                        .birth("2023-10-10")
                        .build()
        );

        personList.add(
                Person.builder()
                        .name("王五")
                        .age(8)
                        .birth("2016-10-10")
                        .build()
        );

        personList.add(
                Person.builder()
                        .name("赵六")
                        .build()
        );

        for (Person person : personList) {
            System.out.println(person.toString());
        }

        System.out.println("======");
        Person zhangsan = Person.builder()
                .name("张三")
                .age(18)
                .birth("2020-10-10")
                .build();

        System.out.println(zhangsan.toString());

        System.out.println("==== change ====");

        zhangsan.setAge(29);

        System.out.println(zhangsan.toString());
    }
}
