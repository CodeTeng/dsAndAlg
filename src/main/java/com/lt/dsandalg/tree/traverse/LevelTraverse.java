package com.lt.dsandalg.tree.traverse;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: 层次遍历
 * @author: ~Teng~
 * @date: 2022/9/3 23:33
 */
public class LevelTraverse {
    public void levelOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.print(treeNode.val + "->");

            if (treeNode.leftChild != null) {
                queue.push(treeNode.leftChild);
            }
            if (treeNode.rightChild != null) {
                queue.push(treeNode.rightChild);
            }
        }
    }
}
