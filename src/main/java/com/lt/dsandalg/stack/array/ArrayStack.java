package com.lt.dsandalg.stack.array;

/**
 * @description: 数组模拟栈
 * @author: ~Teng~
 * @date: 2022/9/3 12:09
 */
public class ArrayStack {

    /**
     * 表示的最大容量
     */
    private int maxSize;

    /**
     * 存储栈元素
     */
    private int[] arr;

    /**
     * 栈顶---初始化为-1
     */
    private int top;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        top = -1;
        arr = new int[maxSize];
    }

    /**
     * 栈满
     *
     * @return true or false
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈空
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     *
     * @param value 入栈元素
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        arr[++top] = value;
    }

    /**
     * 出栈
     *
     * @return 出栈元素
     */
    public int pop() {
        if (isEmpty()) {
            // 抛出异常
            throw new RuntimeException("栈空");
        }
        int value = arr[top];
        top--;
        return value;
    }

    /**
     * 显示栈的情况，遍历时需要从栈顶开始显示数据
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据~");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack【%d】 = %d\n", i, arr[i]);
        }
    }
}
