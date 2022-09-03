package com.lt.dsandalg.hash;

import lombok.Data;

/**
 * @description: 实体类
 * @author: ~Teng~
 * @date: 2022/9/3 22:30
 */
@Data
public class Employee {
    private int id;

    private String name;

    private Employee next;

    public Employee(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
