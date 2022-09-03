package com.lt.dsandalg.circlelinkedlist;

import lombok.Data;

/**
 * @description: 创建一个Boy类，表示一个节点
 * @author: ~Teng~
 * @date: 2022/9/3 10:21
 */
@Data
public class Boy {
    private int no;

    private Boy next;

    public Boy(int no) {
        this.no = no;
    }
}
