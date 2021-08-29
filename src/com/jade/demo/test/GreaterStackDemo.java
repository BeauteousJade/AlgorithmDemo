package com.jade.demo.test;

import java.util.Arrays;
import java.util.Stack;

/**
 * 单调栈的Demo
 */
public class GreaterStackDemo {

    public static void main(String[] args) {
        int[] array = {2, 1, 2, 4, 3};
        System.out.println(Arrays.toString(nextGreaterElement(array)));
    }


    /**
     * 下一个更大的元素。
     */
    public static int[] nextGreaterElement(int[] array) {
        int[] ans = new int[array.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = ans.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= array[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(array[i]);
        }
        return ans;
    }
}
