package io.github.biezhi.java8.lambda.lesson2;

import io.github.biezhi.java8.lambda.lesson1.builder.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Rade
 * @Date 2021/1/23 17:52:52
 * @Description
 */
public class LanbdaTest {
    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(
                Person.builder()
                        .name("张三").age(19).stars(299).build(),
                Person.builder()
                        .name("李四").age(35).stars(2344).build(),
                Person.builder()
                        .name("王五").age(26).stars(133).build(),
                Person.builder()
                        .name("赵六").age(13).stars(342).build()
        );

//        List<Person> people = filterPerson(personList);

//        List<Person> people = filterPersonVersion2(personList, new PersonJudge<Person>() {
//            @Override
//            public boolean check(Person person) {
////                return person.getAge() < 20;
//                return person.getAge() > 20;
//            }
//        });

//        List<Person> people = filterPersonVersion2(personList, (p) -> p.getAge() < 20 && p.getStars() > 300);
//
//
//        for (Person person : people) {
//            System.out.println(person.toString());
//        }

//        List<Person> people = filterPersonVersion2(personList, (p) -> p.getAge() < 20);
//        people.forEach(System.out::println);

//        personList.stream()
//                .filter(person -> person.getAge() < 20)
//                .forEach(System.out::println);

        personList.stream()
                .map(Person::getName)
                .forEach(System.out::println);
    }

    /**
     * 过滤人员
     *
     * @return
     */
    public static List<Person> filterPerson(List<Person> list) {
        List<Person> resultList = new ArrayList<>();
        for (Person person : list) {
            if (person.getAge() < 20) {
                resultList.add(person);
            }
        }
        return resultList;
    }

    /**
     * 过滤人员,使用设计模式接口
     *
     * @return
     */
    public static List<Person> filterPersonVersion2(List<Person> list, PersonJudge<Person> personJudge) {
        List<Person> resultList = new ArrayList<>();
        for (Person person : list) {
            if (personJudge.check(person)) {
                resultList.add(person);
            }
        }
        return resultList;
    }
}
