package com.jade.demo.test;

import com.jade.demo.dataStructure.Node;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class FastAndSlowPointerDemo {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Node node = new Node(list.get(0));
        Node head = node;
        for (int i = 1; i < list.size(); i++) {
            node.next = new Node(list.get(i));
            node = node.next;
        }
        System.out.println(testFastAndSlowPointer(head));

        Node newHead = testReverseLink(head);
        StringBuilder sb = new StringBuilder();
        while (newHead != null) {
            sb.append(newHead.value);
            newHead = newHead.next;
        }
        System.out.println(sb);
    }


    /**
     * 快慢指针Demo
     */
    private static Node testFastAndSlowPointer(Node node) {
        Node slow = node;
        Node fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 链表反转
     */
    private static Node testReverseLink(Node node) {
        Node currentNode = node; // 1
        Node nextNode = node.next; // 2
        currentNode.next = null;
        while (nextNode != null) {
            Node nextNext = nextNode.next; // 3, 4,5
            nextNode.next = currentNode; // 3 -> 2 -> 1
            currentNode = nextNode; // 2, 3
            nextNode = nextNext; // 3, 4
        }
        return currentNode;
    }
}
