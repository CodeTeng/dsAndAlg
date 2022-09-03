package com.lt.dsandalg.tree.traverse;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: 前序遍历的两种方式
 * @author: ~Teng~
 * @date: 2022/9/3 22:52
 */
public class PreTraverse {
    /**
     * 递归实现
     *
     * @param root 树的根节点
     */
    public void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "->");
            preOrderTraverse1(root.leftChild);
            preOrderTraverse1(root.rightChild);
        }
    }

    /**
     * 非递归实现
     *
     * @param root 根节点
     */
    public void preOrderTraverse2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                System.out.print(node.val + "->");
                stack.push(node);
                node = node.leftChild;
            } else {
                // 已经到咋最左边
                TreeNode treeNode = stack.pop();
                // 指向右节点l
                node = treeNode.rightChild;
            }
        }
    }
}
