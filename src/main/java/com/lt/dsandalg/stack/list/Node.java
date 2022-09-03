package com.lt.dsandalg.stack.list;

/**
 * @description: 表示链表的一个节点
 * @author: ~Teng~
 * @date: 2022/9/3 12:17
 */
public class Node {
    Object element;
    Node next;

    public Node(Object element) {
        this(element, null);
    }

    /**
     * 头插法插入节点
     *
     * @param element 新增节点的value
     * @param n       原来的头节点
     */
    public Node(Object element, Node n) {
        this.element = element;
        next = n;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
