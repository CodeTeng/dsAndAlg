package com.lt.dsandalg.tree.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: 二叉树前、中、后序的验证
 * @author: ~Teng~
 * @date: 2022/9/4 17:01
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(new Hero(0, "根节点"));
        TreeNode node1 = new TreeNode(new Hero(1, "节点1"));
        TreeNode node2 = new TreeNode(new Hero(2, "节点2"));
        TreeNode node3 = new TreeNode(new Hero(3, "节点3"));
        TreeNode node4 = new TreeNode(new Hero(4, "节点4"));
        TreeNode node5 = new TreeNode(new Hero(5, "节点5"));
        TreeNode node6 = new TreeNode(new Hero(6, "节点6"));
        root.setLeftChild(node1);
        root.setRightChild(node2);
        node1.setLeftChild(node3);
        node1.setRightChild(node4);
        node3.setLeftChild(node5);
        node3.setRightChild(node6);

        // 前序遍历
        System.out.println("\n递归实现前序遍历：");
        preOrderTraverse1(root);
        System.out.println("\n非递归实现前序遍历：");
        preOrderTraverse2(root);

        // 中序遍历
        System.out.println("\n递归实现中序遍历：");
        inOrderTraverse1(root);
        System.out.println("\n非递归实现中序遍历：");
        inOrderTraverse2(root);

        // 后序遍历
        System.out.println("\n递归实现后序遍历：");
        postOrderTraverse1(root);
        System.out.println("\n非递归实现后序遍历：");
        postOrderTraverse2(root);

        // 前序查找
        System.out.println("递归前序查找：" + preOrderSearch1(root, 2));
        System.out.println("非递归前序查找：" + preOrderSearch2(root, 2));

        // 中序查找
        System.out.println("递归中序查找：" + inOrderSearch1(root, 2));
        System.out.println("非递归中序查找：" + inOrderSearch2(root, 2));

        // 后序查找
        System.out.println("递归后序查找：" + postOrderSearch1(root, 2));
        System.out.println("非递归后序查找：" + postOrderSearch2(root, 2));
    }

    private static String postOrderSearch2(TreeNode root, int i) {
        return null;
    }

    private static String postOrderSearch1(TreeNode root, int i) {
        return null;
    }

    private static String inOrderSearch2(TreeNode root, int i) {
        return null;
    }

    private static String inOrderSearch1(TreeNode root, int i) {
        return null;
    }

    private static Hero preOrderSearch2(TreeNode root, int id) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                Hero hero = (Hero) node.getData();
                if (hero.getId() == id) {
                    return hero;
                }
                stack.push(node);
                node = node.getLeftChild();
            } else {
                TreeNode treeNode = stack.pop();
                node = treeNode.getRightChild();
            }
        }
        return null;
    }

    private static Hero preOrderSearch1(TreeNode root, int id) {
        if (root != null) {
            Hero hero = (Hero) root.getData();
            if (hero.getId() == id) {
                return hero;
            }
            hero = preOrderSearch1(root.getLeftChild(), id);
            if (hero != null) {
                return hero;
            }
            hero = preOrderSearch1(root.getRightChild(), id);
            if (hero != null) {
                return hero;
            }
        }
        return null;
    }

    private static void postOrderTraverse2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur, prev = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if ((cur.getLeftChild() == null && cur.getRightChild() == null) || (prev != null && (prev == cur.getLeftChild() || prev == cur.getRightChild()))) {
                System.out.print(cur.getData() + "->");
                stack.pop();
                prev = cur;
            } else {
                if (cur.getRightChild() != null) {
                    stack.push(cur.getRightChild());
                }
                if (cur.getLeftChild() != null) {
                    stack.push(cur.getLeftChild());
                }
            }
        }
    }

    private static void postOrderTraverse1(TreeNode root) {
        if (root != null) {
            postOrderTraverse1(root.getLeftChild());
            postOrderTraverse1(root.getRightChild());
            System.out.print(root.getData() + "->");
        }
    }

    private static void inOrderTraverse2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.getLeftChild();
            } else {
                TreeNode treeNode = stack.pop();
                System.out.print(treeNode.getData() + "->");
                node = treeNode.getRightChild();
            }
        }
    }

    private static void inOrderTraverse1(TreeNode root) {
        if (root != null) {
            inOrderTraverse1(root.getLeftChild());
            System.out.print(root.getData() + "->");
            inOrderTraverse1(root.getRightChild());
        }
    }

    private static void preOrderTraverse2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                System.out.print(node.getData() + "->");
                stack.push(node);
                node = node.getLeftChild();
            } else {
                TreeNode treeNode = stack.pop();
                node = treeNode.getRightChild();
            }
        }
    }

    private static void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.getData() + "->");
            preOrderTraverse1(root.getLeftChild());
            preOrderTraverse1(root.getRightChild());
        }
    }


}
