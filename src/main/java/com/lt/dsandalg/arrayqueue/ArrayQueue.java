package com.lt.dsandalg.arrayqueue;


/**
 * @description: 数组模拟队列实现---非循环队列
 * @author: ~Teng~
 * @date: 2022/9/1 23:19
 */
public class ArrayQueue {

    /**
     * 表示数组的最大容量
     */
    private int maxSize;

    /**
     * 模拟队列的头指针---指向队列头部的数据的前一个位置
     */
    private int front;

    /**
     * 模拟队列的尾指针---指向队列尾部的数据
     */
    private int rear;

    /**
     * 用于存储队列元素
     */
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        rear = front = -1;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否已满
     *
     * @return true or false
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 显示队列当前元素个数
     *
     * @return 队列当前元素个数
     */
    public int size() {
        return arr.length;
    }

    /**
     * 添加数据到队列尾部
     *
     * @param n 添加数据
     */
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，无法插入");
            return;
        } else {
            arr[++rear] = n;
        }
    }

    /**
     * 数据出队列
     *
     * @return 移除的数据
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据！！！");
        } else {
            return arr[++front];
        }
    }

    /**
     * 显示队列的所有内容
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空的，没有数据！！！");
            return;
        }
        for (int i = 0; i < size(); i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    /**
     * 显示队列的头数据
     *
     * @return 队列的头数据
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据！！！");
        }
        return arr[++front];
    }
}
