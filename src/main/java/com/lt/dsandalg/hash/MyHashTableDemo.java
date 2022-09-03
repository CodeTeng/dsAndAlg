package com.lt.dsandalg.hash;

import java.util.Scanner;

/**
 * @description:
 * @author: ~Teng~
 * @date: 2022/9/3 22:38
 */
public class MyHashTableDemo {
    public static void main(String[] args) {
        // 创建哈希表
        MyHashTable hashTable = new MyHashTable(7);

        // 写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("add：   【添加员工】");
        System.out.println("list：  【显示员工】");
        System.out.println("find：  【查找员工】");
        System.out.println("delete：【删除员工】");
        System.out.println("exit：  【退出系统】");
        int id;
        Employee employee;
        while (true) {
            key = scanner.next();
            switch (key) {
                case "add" -> {
                    System.out.println("输入id：");
                    id = scanner.nextInt();
                    System.out.println("输入名字：");
                    String name = scanner.next();
                    // 创建雇员
                    employee = new Employee(id, name);
                    hashTable.add(employee);
                    System.out.println("添加成功，请重新输入选择菜单：");
                }
                case "list" -> hashTable.list();
                case "find" -> {
                    System.out.println("请输入要查找的id：");
                    id = scanner.nextInt();
                    employee = hashTable.find(id);
                    if (employee != null) {
                        System.out.println("查找成功，信息为：" + employee);
                    }
                    System.out.println("请重新输入选择菜单：");
                }
                case "delete" -> {
                    System.out.println("请输入要删除的id：");
                    id = scanner.nextInt();
                    hashTable.delete(id);
                    System.out.println("删除成功，请重新输入选择菜单：");
                }
                case "exit" -> {
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("你的输入有误！请重写输入：");
            }
        }
    }
}
