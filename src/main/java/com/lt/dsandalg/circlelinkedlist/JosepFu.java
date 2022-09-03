package com.lt.dsandalg.circlelinkedlist;

/**
 * @description: 解决约瑟夫问题
 * @author: ~Teng~
 * @date: 2022/9/3 10:20
 */
public class JosepFu {
    public static void main(String[] args) {
        // 测试构建环形链表和遍历
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        // 加入7个小孩
        circleSingleLinkedList.addBoy(7);
        circleSingleLinkedList.showBoy();

        // 测试小孩出圈 3->6->2->7->5->1->4
        circleSingleLinkedList.countBoy(1, 3, 7);
    }
}
