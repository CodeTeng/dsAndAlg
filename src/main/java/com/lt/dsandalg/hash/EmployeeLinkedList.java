package com.lt.dsandalg.hash;

/**
 * @description: 雇员链表EmployeeLinkedList类
 * @author: ~Teng~
 * @date: 2022/9/3 22:31
 */
public class EmployeeLinkedList {
    /**
     * 头指针，指向第一个Emp，因此我们这个链表的head是直接指向第一个Emp，默认为null
     */
    private Employee head;
    /**
     * 尾指针，指向最后一个Emp
     */
    private Employee tail;

    /**
     * 假定当添加雇员的时候，id是自增长的，直接加入到链表的最后就行
     */
    public void add(Employee employee) {
        // 如果是第一个雇员
        if (head == null) {
            head = employee;
            tail = head;
        } else {
            tail.setNext(employee);
            tail = employee;
        }
    }

    /**
     * 显示员工
     */
    public void list(int i) {
        if (head == null) {
            System.out.println("第" + i + "条链表为空");
            return;
        } else {
            System.out.print("第" + i + "条链表信息为：");
            Employee temp = head;
            while (temp != null) {
                System.out.printf("=> id = %d, name = %s\t", temp.getId(), temp.getName());
                temp = temp.getNext();
            }
            System.out.println();
        }
    }

    /**
     * 删除员工
     */
    public void delete(int id) {
        // 判断链表是否为空
        if (head == null) {
            System.out.println("该元素不存在");
            return;
        }
        if (head.getId() == id) {
            head = head.getNext();
            return;
        }
        Employee temp = head;
        while (temp.getNext() != null) {
            if (temp.getNext().getId() == id) {
                temp.setNext(temp.getNext().getNext());
            }
            temp = temp.getNext();
        }
    }

    /**
     * 查找员工
     */
    public Employee find(int id) {
        // 判断链表是否为空
        if (head == null) {
            System.out.println("该元素不存在");
            return null;
        }
        Employee temp = head;
        while (temp != null) {
            if (temp.getId() == id) {
                return temp;
            }
            temp = temp.getNext();
        }
        System.out.println("该元素不存在");
        return null;
    }
}
