package com.lt.dsandalg.linkedlist;

import lombok.Data;

/**
 * @description: 英雄节点--每个HeroNode对象就是一个节点
 * @author: ~Teng~
 * @date: 2022/9/2 0:13
 */
@Data
public class HeroNode {
    /**
     * 英雄编号
     */
    private int no;

    /**
     * 英雄名称
     */
    private String name;

    /**
     * 英雄昵称
     */
    private String nickname;

    /**
     * 指向下一个节点
     */
    private HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
}
