package com.lt.dsandalg.stack.list;

/**
 * @description:
 * @author: ~Teng~
 * @date: 2022/9/3 12:17
 */
public class LinkedListStackDemo {
    public static void main(String[] args) throws InterruptedException {
        // 初始化栈
        ListStack listStack = new ListStack(5);
        System.out.println("初始化栈，栈大小为：【" + listStack.getSize() + "】");

        listStack.push("节点1");
        System.out.println("push`节点1`，栈顶元素为：【" + listStack.peek() + "】");
        listStack.push("节点2");
        System.out.println("push`节点2`，栈顶元素为：【" + listStack.peek() + "】");
        listStack.push("节点3");
        System.out.println("push`节点3`，栈顶元素为：【" + listStack.peek() + "】");
        System.out.println("当前链表的的元素个数为：" + listStack.getElementCount());

        listStack.push("节点4");
        System.out.println("push`节点4`，栈顶元素为：【" + listStack.peek() + "】");
        listStack.push("节点5");
        System.out.println("push`节点5`，栈顶元素为：【" + listStack.peek() + "】");
        try {
            listStack.push("节点6");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("push`节点6`失败，栈顶元素为：【" + listStack.peek() + "】");
        }

        Thread.sleep(1000);
        System.out.println("当前链表的的元素个数为：" + listStack.getElementCount());

        System.out.println("pop元素为：【" + listStack.pop() + "】，当前栈顶元素为：【" + listStack.peek() + "】");
        System.out.println("pop元素为：【" + listStack.pop() + "】，当前栈顶元素为：【" + listStack.peek() + "】");
        System.out.println("当前链表的的元素个数为：" + listStack.getElementCount());
        System.out.println("pop元素为：【" + listStack.pop() + "】，当前栈顶元素为：【" + listStack.peek() + "】");
        System.out.println("pop元素为：【" + listStack.pop() + "】，当前栈顶元素为：【" + listStack.peek() + "】");
        System.out.println("pop元素为：【" + listStack.pop() + "】");
        System.out.println("当前链表的的元素个数为：" + listStack.getElementCount());
        System.out.println("当前栈顶元素为：");
        listStack.peek();
    }
}
