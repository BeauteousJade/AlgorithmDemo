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
}
