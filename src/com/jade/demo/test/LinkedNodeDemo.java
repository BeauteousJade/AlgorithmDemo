package com.jade.demo.test;

import com.jade.demo.dataStructure.Node;

public class LinkedNodeDemo {

    private static Node left;

    public static void main(String[] args) {
        Node node = buildLinkedNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(postTraverse(node));

        Node newHead = testReverseLink(node);
        StringBuilder sb = new StringBuilder();
        while (newHead != null) {
            sb.append(newHead.value);
            newHead = newHead.next;
        }
        System.out.println(sb);

        sb.delete(0, sb.length());
        node = buildLinkedNode(new int[]{1, 2, 3, 4, 5});
        newHead = testReverseLinkV2(node);
        while (newHead != null) {
            sb.append(newHead.value);
            newHead = newHead.next;
        }
        System.out.println(sb);

        System.out.println(isPalindrome(buildLinkedNode(new int[]{1, 2, 3, 2, 1})));
        System.out.println(isPalindrome(buildLinkedNode(new int[]{1, 2, 3, 2, 2})));

    }

    private static Node buildLinkedNode(int[] array) {
        Node node = new Node(array[0]);
        Node head = node;
        for (int i = 1; i < array.length; i++) {
            node.next = new Node(array[i]);
            node = node.next;
        }
        return head;
    }

    /**
     * 后续遍历链表，即反向遍历链表
     */
    private static Node postTraverse(Node node) {
        if (node == null) {
            return null;
        }
        Node last = postTraverse(node.next);
        System.out.print(node.value + " ");
        return last;
    }

    /**
     * 链表反转，非递归版本
     */
    private static Node testReverseLink(Node node) {
        Node currentNode = node; // 1
        Node nextNode;
        Node preNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        return preNode;
    }

    /**
     * 链表反转，递归版本
     */
    private static Node testReverseLinkV2(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node last = testReverseLink(node.next);
        node.next.next = node;
        node.next = null;
        return last;
    }

    /**
     * 使用链表反序遍历判断是否是回文链表。
     */
    private static boolean isPalindrome(Node node) {
        left = node;
        return isPalindromeInternal(node);
    }

    private static boolean isPalindromeInternal(Node node) {
        if (node == null) {
            return true;
        }
        boolean res = isPalindromeInternal(node.next);
        res = res && (node.value == left.value);
        left = left.next;
        return res;
    }
}
