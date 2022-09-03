package com.lt.dsandalg.stack.array;

import java.util.Scanner;

/**
 * @description:
 * @author: ~Teng~
 * @date: 2022/9/3 12:08
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
// 先创建一个ArrayStack ——> 表示栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        // 控制是否退出菜单
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("show：表示显示栈");
        System.out.println("exit：表示退出程序");
        System.out.println("push：表示添加数据到栈（入栈）");
        System.out.println("pop：表示从栈取出数据（出栈）");
        while (loop) {
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数字：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}
