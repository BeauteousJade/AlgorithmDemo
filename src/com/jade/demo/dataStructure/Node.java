package com.jade.demo.dataStructure;

public class Node {
    public Node next;
    public int value;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "value=" + value;
    }
}