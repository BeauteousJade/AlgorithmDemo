package com.jade.demo.test;

import java.util.HashSet;
import java.util.Set;

public class BFSDemo {

    /**
     * 双向BFS
     */
    public int bfsV2(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }
        // 用来存储起点的发散点
        Set<String> q1 = new HashSet<>();
        // 用来存储终点的发散点
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        q1.add("0000");
        q2.add(target);
        int step = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            // 用来存储当前点的发散点
            // 当前点可能是起点，也可能是终点。
            Set<String> temp = new HashSet<>();
            for (String curr : q1) {
                if (deads.contains(curr)) {
                    continue;
                }
                if (q2.contains(curr)) {
                    return step;
                }
                visited.add(curr);
                for (int i = 0; i < 4; i++) {
                    String up = plusOne(curr, i);
                    if (!visited.contains(up)) {
                        temp.add(up);
                    }
                    String down = minusOne(curr, i);
                    if (!visited.contains(down)) {
                        temp.add(down);
                    }
                }
            }
            step++;
            // 这里 将q2赋值给q1，保证下次遍历的终点。
            q1 = q2;
            // 将起点的发散点，赋值给a2，保证下下次能重新遍历起点的发散点。
            q2 = temp;
        }
        return step;
    }

    private String plusOne(String string, int index) {
        char[] ch = string.toCharArray();
        if (ch[index] == '9') {
            ch[index] = '0';
        } else {
            ch[index] += 1;
        }
        return new String(ch);
    }

    private String minusOne(String string, int index) {
        char[] ch = string.toCharArray();
        if (ch[index] == '0') {
            ch[index] = '9';
        } else {
            ch[index] = '0';
        }
        return new String(ch);
    }
}
