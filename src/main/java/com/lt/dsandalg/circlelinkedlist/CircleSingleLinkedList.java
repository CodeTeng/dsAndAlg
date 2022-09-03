package com.lt.dsandalg.circlelinkedlist;

/**
 * @description: 单向循环链表
 * @author: ~Teng~
 * @date: 2022/9/3 10:21
 */
public class CircleSingleLinkedList {

    /**
     * 创建一个first节点，当前没有编号
     */
    private Boy first = null;

    /**
     * 添加小孩节点，构建一个环形链表
     *
     * @param nums 共多少个节点
     */
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不正确");
        }
        Boy temp = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if (i == 1) {
                first = boy;
                // 构成环
                first.setNext(first);
                temp = first;
            } else {
                temp.setNext(boy);
                boy.setNext(first);
                temp = boy;
            }
        }
    }

    /**
     * 遍历当前的环形链表
     */
    public void showBoy() {
        if (first == null) {
            System.out.println("没有任何小孩~");
            return;
        }
        // 因为first不能动，所以我们还需要使用一个辅助指针完成遍历
        Boy temp = first;
        while (true) {
            System.out.printf("小孩的编号%d \n", temp.getNo());
            // 说明遍历完毕
            if (temp.getNext() == first) {
                break;
            }
            // temp后移
            temp = temp.getNext();
        }
    }

    /**
     * 根据用户的输入，计算出小孩出圈的顺序
     *
     * @param firstNo  表示小孩从第几个小孩开始报数
     * @param countNum 表示一次数几下
     * @param nums     表示最初有多少个小孩在圈中
     */
    public void countBoy(int firstNo, int countNum, int nums) {
        // 先对数据进行校验
        if (first == null || firstNo < 1 || firstNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        // 1. 创建一个前驱指针 用来指向环形链表的first的前一个节点
        Boy prev = first;
        while (prev.getNext() != first) {
            prev = prev.getNext();
        }
        // 2. 事先先让prev 和 first 移动firstNo-1次
        for (int i = 0; i < firstNo - 1; i++) {
            first = first.getNext();
            prev = prev.getNext();
        }
        // 开始循环报数出圈
        while (prev != first) {
            // 如果剩下一个节点 结束循环
            // 3. 小孩报数 让first和prev分别移动countNum-1次
            for (int i = 0; i < countNum - 1; i++) {
                prev = prev.getNext();
                first = first.getNext();
            }
            // 这时出圈的是first节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            first = first.getNext();
            prev.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d\n", first.getNo());
    }
}
