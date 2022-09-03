package com.lt.dsandalg.doublelinkedlist;

/**
 * @description:
 * @author: ~Teng~
 * @date: 2022/9/3 9:41
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试:");
        // 创建节点
        HeroNode her1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode her2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode her3 = new HeroNode(3, "吴用", "智多星");
        HeroNode her4 = new HeroNode(4, "林冲", "豹子头");
        // 创建一个双向链表对象
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(her1);
        doubleLinkedList.add(her2);
        doubleLinkedList.add(her3);
        doubleLinkedList.add(her4);
        doubleLinkedList.list();

        // 修改
        HeroNode newHeroNode = new HeroNode(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况:");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.delete(3);
        System.out.println("删除之后的链表情况：");
        doubleLinkedList.list();

        // 测试有序新增
        DoubleLinkedList doubleLinkedList1 = new DoubleLinkedList();
        doubleLinkedList1.addByOrder(her3);
        doubleLinkedList1.addByOrder(her2);
        doubleLinkedList1.addByOrder(her2);
        doubleLinkedList1.addByOrder(her4);
        doubleLinkedList1.addByOrder(her4);
        doubleLinkedList1.addByOrder(her2);
        doubleLinkedList1.addByOrder(her1);
        System.out.println("测试有序增加链表：");
        doubleLinkedList1.list();
    }
}
