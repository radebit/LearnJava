package com.radebit.test.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Rade
 * @Date 2021/2/26 15:25:25
 * @Description 工人对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 工资
     */
    private Double wage;
}
