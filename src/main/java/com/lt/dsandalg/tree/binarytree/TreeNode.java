package com.lt.dsandalg.tree.binarytree;

import lombok.Data;

/**
 * @description: 二叉树节点类
 * @author: ~Teng~
 * @date: 2022/9/4 17:02
 */
@Data
public class TreeNode {
    /**
     * 数据域
     */
    private Object data;

    /**
     * 左孩子指针
     */
    private TreeNode leftChild;

    /**
     * 右孩子指针
     */
    private TreeNode rightChild;

    public TreeNode(Object data) {
        this.data = data;
        leftChild = null;
        rightChild = null;
    }
}
