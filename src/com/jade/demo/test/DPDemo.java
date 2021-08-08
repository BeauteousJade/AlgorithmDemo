package com.jade.demo.test;

import java.util.Arrays;

public class DPDemo {

    public static void main(String[] args) {

    }

    /**
     * 最长递增子序列
     */
    private static int dpV1(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 嵌套信封问题。
     */
    private static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            // 0表示宽，1表示高。
            // 按照宽的升序排序，高的降序。
            // 是因为后面，是通过高来计算子序列的，如果宽相同，后续的高都比前面的高小，
            // 这样就能避免装了相同宽的信封。
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });

        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }
        // 查找高的最长递增序列
        return dpV1(height);
    }

    /**
     * 最大子数组和
     */
    private static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int value : dp) {
            res = Math.max(res, value);
        }
        return res;
    }
}
