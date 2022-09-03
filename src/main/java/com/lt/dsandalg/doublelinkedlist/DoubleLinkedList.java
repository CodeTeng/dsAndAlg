package com.lt.dsandalg.doublelinkedlist;

/**
 * @description: 双向链表
 * @author: ~Teng~
 * @date: 2022/9/3 9:41
 */
public class DoubleLinkedList {

    /**
     * 初始化一个头节点，头节点不动，不存放具体的数据
     */
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 初始化一个尾节点，指向最后一个元素，默认等于head
     */
    private HeroNode tail = head;

    public HeroNode getHead() {
        return head;
    }

    /**
     * 链表是否为空
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    /**
     * 修改一个节点的内容
     *
     * @param heroNode 修改的节点
     */
    public void update(HeroNode heroNode) {
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        HeroNode currentNode = head.getNext();
        boolean flag = false;
        while (true) {
            if (currentNode == null) {
                break;
            }
            if (currentNode.getNo() == heroNode.getNo()) {
                // 找到节点
                flag = true;
                break;
            }
            currentNode = currentNode.getNext();
        }
        if (flag) {
            // 找到 进行修改
            currentNode.setName(heroNode.getName());
            currentNode.setNickname(heroNode.getNickname());
        } else {
            System.out.printf("没有找到编号为 %d 的节点，不能修改\n", heroNode.getNo());
        }
    }

    /**
     * 双向链表删除节点
     *
     * @param no 节点编号
     */
    public void delete(int no) {
        if (isEmpty()) {
            System.out.println("链表为空，无法删除！！！");
            return;
        }
        HeroNode currentNode = head.getNext();
        boolean flag = false;
        while (true) {
            if (currentNode == null) {
                // 没有该节点
                break;
            }
            if (currentNode.getNo() == no) {
                // 找到
                flag = true;
                break;
            }
            currentNode = currentNode.getNext();
        }
        if (flag) {
            // 找到 进行删除
            currentNode.getPrev().setNext(currentNode.getNext());
            // 如果是最后一个节点，就不需要指向下面这句话，否则会出现空指针 temp.getNext().setPre(null.getPre())
            if (currentNode.getNext() != null) {
                currentNode.getNext().setPrev(currentNode.getPrev());
            }
        }
    }

    /**
     * 直接新增节点
     *
     * @param heroNode 节点
     */
    public void add(HeroNode heroNode) {
        tail.setNext(heroNode);
        heroNode.setPrev(tail);
        tail = heroNode;
    }

    /**
     * 有序新增节点
     *
     * @param heroNode 节点
     */
    public void addByOrder(HeroNode heroNode) {
        HeroNode currentNode = head;
        boolean flag = false;   // 代表是否有重复
        while (true) {
            if (currentNode.getNext() == null) {
                break;
            }
            // 位置已经找到，应该在currentNode和currentNode.getNext()之间
            if (currentNode.getNext().getNo() > heroNode.getNo()) {
                break;
            }
            if (currentNode.getNext().getNo() == heroNode.getNo()) {
                flag = true;
                break;
            }
            currentNode = currentNode.getNext();
        }
        if (flag) {
            System.out.printf("准备插入的英雄编号【%d】已经存在了\n", heroNode.getNo());
        } else {
            heroNode.setNext(currentNode.getNext());
            // 判断链表是否在最后
            if (currentNode.getNext() != null) {
                currentNode.getNext().setPrev(heroNode);
            }
            currentNode.setNext(heroNode);
            heroNode.setPrev(currentNode);
        }
    }

    /**
     * 遍历打印双向链表的方法
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("链表为空！！！");
            return;
        }
        HeroNode temp = head.getNext();
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}
