package com.jade.demo.test;

import com.jade.demo.dataStructure.TreeNode;

public class BinarySearchTreeDemo {

    public static void main(String[] args) {

    }


    /**
     * 向BST里面增加一个Node。
     */
    private static TreeNode add(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = add(root.left, val);
        }
        if (root.val < val) {
            root.right = add(root.right, val);
        }
        return root;
    }

    /**
     * 向BST里面删除一个Node。
     */
    private static TreeNode delete(TreeNode root, int val) {
        // 找到了，进行删除
        if (root.val == val) {
            // 1. left 为空，那么返回right;
            if (root.left == null) {
                return root.right;
            }
            // 2. right为空，那么就返回left;
            if (root.right == null) {
                return root.left;
            }
            // 3. 如果left 和 right都不为空，那么就找到一个
            // right中最小的node,将其作为root进行返回。
            TreeNode minNode = getMinNode(root.right);
            root.val = minNode.val;
            root.right = delete(root.right, minNode.val);

        } else if (root.val > val) {
            root.left = delete(root.left, val);
        } else {
            root.right = delete(root.right, val);
        }
        return root;
    }

    private static TreeNode getMinNode(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return getMinNode(root.left);
    }
}
