package com.lt.dsandalg.tree.traverse;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: 后序遍历
 * @author: ~Teng~
 * @date: 2022/9/3 23:04
 */
public class PostTraverse {

    /**
     * 递归实现
     */
    public void postTraverse1(TreeNode node) {
        if (node != null) {
            postTraverse1(node.leftChild);
            postTraverse1(node.rightChild);
            System.out.print(node.val + "->");
        }
    }

    /**
     * 非递归实现
     *
     * @param node 根节点
     */
    public void postTraverse2(TreeNode node) {
        TreeNode cur, pre = null;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            // 当为叶子节点 或者当前节点的子节点为pre
            if ((cur.leftChild == null && cur.rightChild == null) || (pre != null && (pre == cur.leftChild || pre == cur.rightChild))) {
                System.out.print(cur.val + "->");
                stack.pop();
                // 更改指向
                pre = cur;
            } else {
                if (cur.rightChild != null) {
                    stack.push(cur.rightChild);
                }
                if (cur.leftChild != null) {
                    stack.push(cur.leftChild);
                }
            }
        }
    }
}
