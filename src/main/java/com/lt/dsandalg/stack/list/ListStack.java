package com.lt.dsandalg.stack.list;

/**
 * @description: 链表模拟栈
 * @author: ~Teng~
 * @date: 2022/9/3 12:17
 */
public class ListStack {

    /**
     * 栈顶元素
     */
    private Node header;

    /**
     * 栈内元素个数
     */
    private int elementCount;

    /**
     * 栈的大小
     */
    private int size;

    public ListStack() {
        header = null;
        elementCount = 0;
        size = 0;
    }

    public ListStack(int size) {
        header = null;
        elementCount = 0;
        this.size = size;
    }

    /**
     * 设置堆栈大小
     *
     * @param size 堆栈大小
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 设置栈顶元素
     *
     * @param header 栈顶元素
     */
    public void setHeader(Node header) {
        this.header = header;
    }

    /**
     * 获取堆栈长度
     *
     * @return 堆栈长度
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回栈中元素的个数
     *
     * @return 栈中元素的个数
     */
    public int getElementCount() {
        return elementCount;
    }

    /**
     * 判断栈空
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return elementCount == 0;
    }

    /**
     * 判断栈满
     *
     * @return true or false
     */
    public boolean isFull() {
        return elementCount == size;
    }

    /**
     * 把对象入栈
     *
     * @param value 对象
     */
    public void push(Object value) {
        if (isFull()) {
            throw new RuntimeException("Stack is Full");
        }
        header = new Node(value, header);
        elementCount++;
    }

    /**
     * 出栈，并返回被出栈的元素
     *
     * @return 出栈的元素
     */
    public Object pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        Object value = header.getElement();
        header = header.getNext();
        elementCount--;
        return value;
    }

    /**
     * 返回栈顶元素
     *
     * @return 栈顶元素
     */
    public Object peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return header.getElement();
    }
}
