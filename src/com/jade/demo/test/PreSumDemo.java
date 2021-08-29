package com.jade.demo.test;

/**
 * 前缀和的Demo。
 */
public class PreSumDemo {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(subArraySum(array, 5));
    }

    /**
     * 子数组和。
     */
    private static int subArraySum(int[] array, int n) {
        int[] preSum = new int[array.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < array.length; i++) {
            preSum[i + 1] = preSum[i] + array[i];
        }
        int ans = 0;
        for (int i = 1; i <= array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (preSum[i] - preSum[j] == n) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
