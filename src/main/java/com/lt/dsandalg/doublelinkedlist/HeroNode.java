package com.lt.dsandalg.doublelinkedlist;

import lombok.Data;

/**
 * @description:
 * @author: ~Teng~
 * @date: 2022/9/3 9:42
 */
@Data
public class HeroNode {
    private int no;
    private String name;
    private String nickname;

    /**
     * 后继节点
     */
    private HeroNode next;

    /**
     * 前驱节点
     */
    private HeroNode prev;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}
