package com.lt.dsandalg.tree.traverse;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: 中序遍历
 * @author: ~Teng~
 * @date: 2022/9/3 22:58
 */
public class InTraverse {

    /**
     * 递归实现
     *
     * @param root 根节点
     */
    public void inOrderTraverse1(TreeNode root) {
        if (root != null) {
            inOrderTraverse1(root.leftChild);
            System.out.print(root.val + "->");
            inOrderTraverse1(root.rightChild);
        }
    }

    /**
     * 非递归实现
     *
     * @param root 根节点
     */
    public void inOrderTraverse2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.leftChild;
            } else {
                // 到达最左边
                TreeNode treeNode = stack.pop();
                System.out.print(treeNode.val + "->");
                node = treeNode.rightChild;
            }
        }
    }
}
