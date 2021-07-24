package com.jade.demo.test;

public class BinarySearchDemo {
    public static void main(String[] args) {

        int arrayV1[] = {1, 2, 3, 4, 5, 6};
        System.out.println(binarySearch(arrayV1, 6));
        int arrayV2[] = {1, 2, 3, 3, 3, 4, 5, 5, 6};
        System.out.println(binarySearchV2(arrayV2, 5));
    }

    /**
     * 普通二分
     */
    private static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 寻找左侧边界的target.（双闭区间的写法）
     */
    private static int binarySearchV2(int[] array, int target) {
        int left = 0;
        // 如果right 为 array.length - 1, 那么 left <= right.
        int right = array.length - 1;
        // 如果是 left <= right， left和right 都不能为mid,至少前进或者后退一步。
        // 否则会死循环
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                right = mid - 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            }
        }
        return array[left] == target ? left : -1;
    }
}
