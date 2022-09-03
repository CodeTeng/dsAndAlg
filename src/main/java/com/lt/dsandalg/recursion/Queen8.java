package com.lt.dsandalg.recursion;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 8皇后问题
 * @author: ~Teng~
 * @date: 2022/9/3 22:00
 */
public class Queen8 {
    /**
     * 定义一个max表示有多少个皇后
     */
    final static int MAX = 8;

    /**
     * 定义一个Array数组，保存皇后放置位置的结果，比如array = {0,4,7,5,2,6,1,3}
     */
    static int[] array = new int[MAX];

    /**
     * 如果是多线程，使用原子类能确保得到最终的情况数
     */
    static AtomicInteger count = new AtomicInteger(0);

    /**
     * 统计判断的次数
     */
    static AtomicInteger judgeCount = new AtomicInteger(0);

    public static void main(String[] args) {
        check(0);
        System.out.println("总共有【" + count + "】情况");
        System.out.println("总共有【" + judgeCount + "】次判断冲突的次数");
    }

    /**
     * 放置第n + 1个皇后，递归
     *
     * @param n 第 n + 1个皇后
     */
    public static void check(int n) {
        // 递归出口 说明8个皇后已经放好
        if (n == MAX) {
            print();
            // 打印一次 就代表一种解法
            count.getAndIncrement();
            return;
        }

        for (int i = 0; i < MAX; i++) {
            // 把第n个皇后放置在第i列
            array[n] = i;
            // 判断是否冲突
            if (judge(n)) {
                // 不冲突的话 递归
                check(n + 1);
            }
            // 冲突的话 将第n个皇后移动一列
        }
    }

    /**
     * 判断第 n + 1个皇后是否和前面皇后冲突
     *
     * @param n 表示第 n + 1个皇后
     * @return 是否可以摆放
     */
    public static boolean judge(int n) {
        judgeCount.getAndIncrement();
        for (int i = 0; i < n; i++) {
            // 代表不能放在同一列 和同一斜线上（斜率相同）
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印皇后的位置
     */
    public static void print() {
        for (int arr : array) {
            System.out.print(arr + " ");
        }
        System.out.println();
    }
}
