package com.lt.dsandalg.arrayqueue.circle;

/**
 * @description: 数组模拟实现循环队列
 * @author: ~Teng~
 * @date: 2022/9/1 23:42
 */
public class CircleArray {

    /**
     * 循环队列的最大容量
     */
    private int maxSize;

    /**
     * 循环队列的头指针---直接指向头部
     */
    private int front;

    /**
     * 循环队列的尾指针---指向尾部的下一个位置
     */
    private int rear;

    /**
     * 用于存储队列中的元素
     */
    private int[] arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        front = rear = 0;
        arr = new int[maxSize];
    }

    /**
     * 判断循环队列是否已满
     *
     * @return true or false
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断循环队列是否为空
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 向队列添加元素
     *
     * @param n 添加的元素
     */
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，无法添加！！！");
            return;
        } else {
            arr[rear] = n;
            rear = (rear + 1) % maxSize;
        }
    }

    /**
     * 移除队列元素
     *
     * @return 移除的元素
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法移除！！！");
        } else {
            int temp = arr[front];
            front = (front + 1) % maxSize;
            return temp;
        }
    }

    /**
     * 显示队列
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        // 从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            // 加上size之后可能会超过数组范围，需要进行取模
            int index = i % maxSize;
            System.out.printf("arr[%d]=%d\n", index, arr[index]);
        }
    }

    /**
     * 求出当前队列的有效数据个数
     */
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    /**
     * 显示队列的头数据
     *
     * @return 队列的头数据
     */
    public int headQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列为空，没有数据~~");
        }
        return arr[front];
    }
}
