package com.lt.dsandalg.arrayqueue.circle;

import java.util.Scanner;

/**
 * @description:
 * @author: ~Teng~
 * @date: 2022/9/1 23:42
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        // 创建一个队列
        // 其队列的有效数据最大是3
        CircleArray circleArray = new CircleArray(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        System.out.println("s(show):显示队列");
        System.out.println("e(exit):退出程序");
        System.out.println("a(add):添加数据到队列");
        System.out.println("g(get):从队列取数据");
        System.out.println("h(head):查看队列头的数据");
        while (loop) {
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleArray.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数:");
                    int value = scanner.nextInt();
                    circleArray.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = circleArray.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                        continue;
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleArray.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
