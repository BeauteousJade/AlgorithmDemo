package com.jade.demo.test;

import com.jade.demo.dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeDemo {

    public static void main(String[] args) {

    }

    /**
     * 前序遍历
     */
    private static void preSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        preSerialize(root.left, sb);
        preSerialize(root.right, sb);
    }

    /**
     * 后序遍历
     */
    private static void postSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        postSerialize(root.left, sb);
        postSerialize(root.right, sb);
        sb.append("#").append(",");
    }

    /**
     * 前序列表构造二叉树
     */
    private static TreeNode preDeserialize(LinkedList<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        Integer value = list.removeFirst();
        TreeNode root = new TreeNode(value);
        root.left = preDeserialize(list);
        root.right = preDeserialize(list);
        return root;
    }

    /**
     * 后序列表构造二叉树
     */
    private static TreeNode postDeserialize(LinkedList<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        Integer value = list.removeLast();
        TreeNode root = new TreeNode(value);
        root.right = postDeserialize(list);
        root.left = postDeserialize(list);
        return root;
    }

    /**
     * 计算树的高度
     */
    private static int countTreeDeepV1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countTreeDeepV1(root.left);
        int right = countTreeDeepV1(root.right);
        return left > right ? left + 1 : right + 1;
    }

    /**
     * 计算树的高度
     */
    private static int countTreeDeepV2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int queueSize = queue.size();
        int deep = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count++;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (count == queueSize) {
                queueSize = queue.size();
                count = 0;
                deep++;
            }
        }
        return deep;
    }

    /**
     * 最近公共祖先
     */
    private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

}
