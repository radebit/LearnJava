package com.radebit.test.stream;

import com.radebit.test.common.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Rade
 * @Date 2021/2/26 14:50:50
 * @Description
 */
public class StreamTest {
    List<Employee> employeeList = Arrays.asList(
            new Employee("张三", 18, 999.99),
            new Employee("李四", 25, 555.55),
            new Employee("王五", 69, 1320.31),
            new Employee("赵六", 12, 27.98),
            new Employee("田七", 36, 132.99)
    );

    @Test
    public void test01() {
        employeeList.stream()
                .filter((employee) -> employee.getAge() > 30)
                .forEach(System.out::println);
    }
}
