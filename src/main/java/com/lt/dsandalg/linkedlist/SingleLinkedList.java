package com.lt.dsandalg.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: 定义SingleLinkedList 管理我们的英雄
 * @author: ~Teng~
 * @date: 2022/9/2 0:13
 */
public class SingleLinkedList {

    /**
     * 初始化头节点---不存放任何数据
     */
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 初始化一个尾节点，指向最后一个元素，默认等于head
     */
    private HeroNode tail = head;

    /**
     * 添加节点到单向链表
     * 不考虑编号顺序时
     * 1. 找到当前链表的最后节点
     * 2. 将最后这个节点的next指向新的节点
     *
     * @param heroNode 节点
     */
    public void add(HeroNode heroNode) {
        tail.setNext(heroNode);
        tail = heroNode;
    }

    /**
     * 第二种方式在添加英雄时， 根据排名将英雄插入到指定位置(如果有这个排名，则添加失败，并给出提示)
     *
     * @param heroNode 节点
     */
    public void addByOrder(HeroNode heroNode) {
        HeroNode currentNode = head;
        boolean flag = false;

        // 寻找插入的位置
        while (true) {
            if (currentNode.getNext() == null) {
                // 说明已经指向链表的最后
                break;
            }
            if (currentNode.getNext().getNo() > heroNode.getNo()) {
                // 说明已经找到位置
                break;
            } else if (currentNode.getNext().getNo() == heroNode.getNo()) {
                // 有该编号 表名重复
                flag = true;
                break;
            }
            // 上述情况都不满足 后移
            currentNode = currentNode.getNext();
        }

        // 插入
        if (flag) {
            // 表名重复 不能重复添加
            System.out.printf("准备插入的英雄编号%d已经存在了\n", heroNode.getNo());
        } else {
            heroNode.setNext(currentNode.getNext());
            currentNode.setNext(heroNode);
        }
    }

    /**
     * 修改节点的信息，根据编号来修改
     *
     * @param heroNode 节点
     */
    public void update(HeroNode heroNode) {
        // 判断是否为空
        if (isEmpty()) {
            System.out.println("链表为空！！！");
            return;
        }
        // 寻找该节点
        HeroNode currentNode = head.getNext();
        boolean flag = false;
        while (true) {
            if (currentNode == null) {
                // 遍历完毕 没有找到
                break;
            }
            if (currentNode.getNo() == heroNode.getNo()) {
                flag = true;
                break;
            }
            currentNode = currentNode.getNext();
        }
        // 进行修改
        if (flag) {
            // 找到该节点 进行修改
            currentNode.setName(heroNode.getName());
            currentNode.setNickname(heroNode.getNickname());
        } else {
            // 没有找到
            System.out.printf("没有找到编号为 %d 的节点，不能修改\n", heroNode.getNo());
        }
    }

    private boolean isEmpty() {
        return head.getNext() == null;
    }

    /**
     * 根据编号 删除节点
     *
     * @param no 英雄节点编号
     */
    public void delete(int no) {
        // 判断是否为空
        if (isEmpty()) {
            System.out.println("链表为空！！！");
            return;
        }
        // 寻找该节点的前一个节点
        HeroNode currentNode = head;
        boolean flag = false;
        while (true) {
            if (currentNode.getNext() == null) {
                break;
            }
            if (currentNode.getNext().getNo() == no) {
                // 找到待删除节点的前一个节点temp
                flag = true;
                break;
            }
            currentNode = currentNode.getNext();
        }

        // 判断是否找到
        if (flag) {
            // 找到 进行删除
            currentNode.setNext(currentNode.getNext().getNext());
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }

    /**
     * 显示链表
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        HeroNode currentNode = head.getNext();
        while (currentNode != null) {
            System.out.println(currentNode);
            currentNode = currentNode.getNext();
        }
    }

    /**
     * 方法：获取单链表的节点个数（如果是带头结点的链表，需求不统计头节点）
     *
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.getNext() == null) {
            return 0;
        }
        int count = 0;
        HeroNode currentNode = head.getNext();
        while (currentNode != null) {
            count++;
            currentNode = currentNode.getNext();
        }
        return count;
    }

    /**
     * 查找单链表的倒数第k个节点【新浪面试题】
     * 两次遍历方法
     *
     * @param head  链表的头节点
     * @param index 倒数位置索引
     * @return 倒数index的节点
     */
    public static HeroNode findLastIndexNode1(HeroNode head, int index) {
        if (head.getNext() == null) {
            return null;
        }
        // 首先得到链表的长度
        HeroNode currentNode = head.getNext();
        int length = 0;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }
        if (index <= 0 || index > length) {
            return null;
        }
        currentNode = head.getNext();
        // 进行寻找
        for (int i = 0; i < length - index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    /**
     * 查找单链表的倒数第k个节点
     * 快慢指针方法
     *
     * @param head  链表的头节点
     * @param index 倒数位置索引
     * @return 倒数index的节点
     */
    public static HeroNode findLastIndexNode2(HeroNode head, int index) {
        // 调用方法 找到正数第index个节点
        HeroNode quick = findFirstIndexNode(head, index);
        if (quick == null) {
            // 如果为空，说明链表长度太短，直接返回
            return null;
        }
        HeroNode slow = head.getNext();
        while (quick.getNext() != null) {
            quick = quick.getNext();
            slow = slow.getNext();
        }
        return slow;
    }

    /**
     * @param head  链表的头节点
     * @param index 正数位置索引
     * @return 正数index的节点
     */
    public static HeroNode findFirstIndexNode(HeroNode head, int index) {
        if (index <= 0) {
            return null;
        }
        if (head.getNext() == null) {
            return null;
        }
        // 这里需要获得正数第index节点，所以这里遍历从head.getNext()起，与findFirstIndexNode从head起不一致
        HeroNode temp = head;
        for (int i = 0; i < index; i++) {
            if (temp == null) {
                return null;
            }
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * 将单链表反转
     *
     * @param head 头节点
     */
    public static void reverseList1(HeroNode head) {
        // 如果当前链表为空，或者只有一个节点，则无需反转，直接返回
        if (head.getNext() == null || head.getNext().getNext() == null) {
            return;
        }
        // 定义一个辅助的指针（变量），帮助我们遍历原来的链表
        HeroNode currentNode = head.getNext();
        // 定义当前节点currentNode的下一个节点
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (currentNode != null) {
            // 先暂时保存当前节点的下一个节点，方便后面使用
            next = currentNode.getNext();
            // 将currentNode的下一个节点指向新链表的最前端
            currentNode.setNext(reverseHead.getNext());
            // 将currentNode插入到新链表的最前端
            reverseHead.setNext(currentNode);
            // 然后currentNode后移
            currentNode = next;
        }
        // 将head的next指向reverseHead的next
        head.setNext(reverseHead.getNext());
    }

    public static HeroNode reverseList2(HeroNode head) {
        if (head.getNext() == null || head.getNext().getNext() == null) {
            return head;
        }
        HeroNode currentNode = head.getNext();
        // 记录前驱节点
        HeroNode prevNode = null;
        HeroNode newHeroNode = new HeroNode(0, "", "");
        while (currentNode != null) {
            // 保存currentNode下一个节点的位置
            HeroNode temp = currentNode.getNext();
            currentNode.setNext(prevNode);
            prevNode = currentNode;
            currentNode = temp;
        }
        newHeroNode.setNext(prevNode);
        return newHeroNode;
    }

    /**
     * 从尾到头打印单链表---用栈实现
     *
     * @param head 头节点
     */
    public static void reversePrint(HeroNode head) {
        if (head.getNext() == null) {
            System.out.println("链表为空，无法反转");
            return;
        }
        HeroNode currentNode = head.getNext();
        Deque<HeroNode> stack = new ArrayDeque<>();
        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.getNext();
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 合并两个有序链表，合并后，链表仍是有序的
     * 方法1：以其中一个链表为主，依次向这个链表中插入另一个链表的元素
     *
     * @param head1 头节点1
     * @param head2 头节点2
     * @return 合并后的有序链表
     */
    public static HeroNode mergeList1(HeroNode head1, HeroNode head2) {
        // 以head1 为主
        HeroNode newHead = head1;
        HeroNode currentNode = head2.getNext();
        while (currentNode != null) {
            HeroNode temp = currentNode.getNext();
            // 首先将下个节点为null 然后进行比较插入
            currentNode.setNext(null);
            addByOrder(newHead, currentNode);
            currentNode = temp;
        }
        return newHead;
    }

    /**
     * 将节点按照顺序新增到链表之中
     *
     * @param head     链表的头节点
     * @param heroNode 代新增的头节点
     */
    private static void addByOrder(HeroNode head, HeroNode heroNode) {
        HeroNode currentNode = head;
        boolean flag = false;
        while (true) {
            if (currentNode.getNext() == null) {
                // 说明已经是链表的最后
                break;
            }
            if (currentNode.getNext().getNo() > heroNode.getNo()) {
                // 已经找到了
                break;
            }
            if (currentNode.getNext().getNo() == heroNode.getNo()) {
                // 不能重复插入
                flag = true;
                break;
            }
            currentNode = currentNode.getNext();
        }

        if (flag) {
            System.out.printf("准备插入的英雄编号【%d】已经存在了\n", heroNode.getNo());
        } else {
            heroNode.setNext(currentNode.getNext());
            currentNode.setNext(heroNode);
        }
    }

    /**
     * 方法二---直接将两个有序链表合并成一个新的有序链表
     *
     * @param head1 有序链表1
     * @param head2 有序链表2
     * @return 合并之后的链表
     */
    public static HeroNode mergeList2(HeroNode head1, HeroNode head2) {
        HeroNode newHead = new HeroNode(0, "", "");
        HeroNode tail = newHead;
        newHead.setNext(tail);
        HeroNode temp1 = head1.getNext();
        HeroNode temp2 = head2.getNext();
        while (temp1 != null && temp2 != null) {
            Integer flag = compareNode(temp1, temp2);
            if (flag.equals(1)) { // 说明节点1大于节点2
                HeroNode next = temp2.getNext(); // 暂时存储temp2的下一个节点
                temp2.setNext(null); // 将temp2的next设为null
                tail.setNext(temp2); // 将temp2加入新的链表中
                tail = temp2; // tail变成了新增的节点temp2
                temp2 = next; // temp2后移
            } else if (flag.equals(0)) { // 说明节点1小于节点2
                HeroNode next = temp1.getNext(); // 暂时存储temp1的下一个节点
                temp1.setNext(null); // 将temp1的next设为null
                tail.setNext(temp1); // 将temp1加入到新的链表中
                tail = temp1; // tail变成了新增的节点temp1
                temp1 = next; // temp1后移
            } else { // 说明节点1和节点2的no相等，新增其中一个就行了
                HeroNode next1 = temp1.getNext();
                HeroNode next2 = temp2.getNext();
                tail.setNext(temp1);
                tail = temp1;
                temp1 = next1;
                temp2 = next2;
            }
        }
        if (temp1 == null) { // 说明是链表1先遍历到最后一个
            tail.setNext(temp2); // 不用考虑tail的值会和temp2的值相等，上面相等的话同时后移
        } else { // 说明是链表2先遍历到最后一个
            tail.setNext(temp1); // 不用考虑tail的值会和temp2的值相等，上面相等的话同时后移
        }
        return newHead;
    }

    /**
     * 比较两个节点的no值，-1表示相等，1表示节点1大于节点2，0表示节点1小于节点2
     *
     * @param node1 节点1
     * @param node2 节点2
     * @return result
     */
    public static Integer compareNode(HeroNode node1, HeroNode node2) {
        if (node1.getNo() == node2.getNo()) {
            return -1;
        }
        return node1.getNo() > node2.getNo() ? 1 : 0;
    }
}
