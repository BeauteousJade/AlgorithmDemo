package com.jade.demo.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SlideWindowDemo {

    public static void main(String[] args) {
        String s = "ADBECFEBANC";
        String t = "ABC";
        System.out.println(slideWindowV1(s, t));
    }


    /**
     * 滑动窗口。
     * 在S中找一个最小子串，字串内包括字符串t的所有字符。
     */
    private static String slideWindowV1(String s, String t) {
        // 记录当前需要的字符
        Map<Character, Integer> need = new HashMap<>();
        char[] ch = t.toCharArray();
        for (char c : ch) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // 记录窗口包含的字符
        Map<Character, Integer> windows = new HashMap<>();
        // 记录满足要求的字符数量
        int validCount = 0;
        int left = 0;
        int right = 0;
        int start = 0;
        int length = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (Objects.equals(windows.get(c), need.get(c))) {
                    validCount++;
                }
            }
            // 当前窗口里面的子串已经包含所有t的字符
            // 需要从左边收缩窗口
            // 滑动窗口的最重要一点就是,判断何时收缩窗口？
            while (validCount == need.size()) {
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (Objects.equals(windows.get(d), need.get(d))) {
                        validCount--;
                    }
                    windows.put(d, windows.getOrDefault(d, 0) - 1);
                }
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }
}
