package com.lt.dsandalg.hash;

/**
 * @description: 用于管理多条table--哈希表MyHashTable类
 * @author: ~Teng~
 * @date: 2022/9/3 22:33
 */
public class MyHashTable {

    private EmployeeLinkedList[] employeeLinkedListArray;

    private int size;

    public MyHashTable(int size) {
        this.size = size;
        employeeLinkedListArray = new EmployeeLinkedList[size];
        // 分别初始化每个链表
        for (int i = 0; i < size; i++) {
            employeeLinkedListArray[i] = new EmployeeLinkedList();
        }
    }

    /**
     * 编写散列函数，使用一个简单取模法
     *
     * @param id 员工id
     * @return 索引
     */
    public int hashFun(int id) {
        return id % size;
    }

    /**
     * 新增员工
     *
     * @param employee 员工实体
     */
    public void add(Employee employee) {
        int index = hashFun(employee.getId());
        employeeLinkedListArray[index].add(employee);
    }

    /**
     * 删除员工
     *
     * @param id 员工id
     */
    public void delete(int id) {
        int index = hashFun(id);
        employeeLinkedListArray[index].delete(id);
    }

    /**
     * 查找员工
     *
     * @param id 员工id
     * @return 员工
     */
    public Employee find(int id) {
        int index = hashFun(id);
        return employeeLinkedListArray[index].find(id);
    }

    /**
     * 打印链表
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            employeeLinkedListArray[i].list(i);
        }
    }
}
