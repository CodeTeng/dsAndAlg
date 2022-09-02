package com.lt.dsandalg.linkedlist;

/**
 * @description:
 * @author: ~Teng~
 * @date: 2022/9/2 0:13
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        // 先创建节点
        HeroNode her1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode her2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode her3 = new HeroNode(3, "吴用", "智多星");
        HeroNode her4 = new HeroNode(4, "林冲", "豹子头");

        // 创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 无顺序加入节点
//        singleLinkedList.add(her1);
//        singleLinkedList.add(her2);
//        singleLinkedList.add(her3);
//        singleLinkedList.add(her4);
        // singleLinkedList.add(her4); （不考虑排序）如果重复添加一个对象就会死循环，因为第一次添加到队尾的时候next还为空，再次添加next就为自己本身就死循环了

        // 按照编号顺序加入节点
        singleLinkedList.addByOrder(her1);
        singleLinkedList.addByOrder(her4);
        singleLinkedList.addByOrder(her2);
        singleLinkedList.addByOrder(her3);
        singleLinkedList.addByOrder(her3); // 不能重复插入

        // 显示
        singleLinkedList.list();

        // 测试修改节点
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList.update(newHeroNode);
        System.out.println("修改之后的链表存储情况：");
        singleLinkedList.list();

        // 删除节点
//        singleLinkedList.delete(1);
//        singleLinkedList.delete(4);
//        singleLinkedList.delete(3);
//        singleLinkedList.delete(2);
//        System.out.println("删除之后的链表存储情况：");
//        singleLinkedList.list();

        // 算法题测试
        System.out.println("=============================");
        HeroNode head = new HeroNode(0, "", "");
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        head.setNext(hero1);
        hero1.setNext(hero2);
        hero2.setNext(hero3);
        hero3.setNext(hero4);
        System.out.println(head);

        System.out.println("反转打印");
        SingleLinkedList.reversePrint(head);

        System.out.println(SingleLinkedList.getLength(head)); // 4

        System.out.println(SingleLinkedList.findLastIndexNode1(head, 2));

//        SingleLinkedList.reverseList1(head);
        HeroNode reverseHerNode = SingleLinkedList.reverseList2(head);
        System.out.println(reverseHerNode);
    }
}
