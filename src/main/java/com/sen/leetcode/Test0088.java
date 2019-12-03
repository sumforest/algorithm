package com.sen.leetcode;

/**
 * @Auther: Sen
 * @Date: 2019/12/2 17:04
 * @Description: 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */
public class Test0088 {

    public static void main(String[] args) {
        // int[] nums1 = {-10,-10,-9,-9,-9,-8,-8,-7,-7,-7,-6,-6,-6,-6,-6,-6,-6,-5,-5,-5,-4,-4,-4,-3,-3,-2,-2,-1,-1,0,1,1,1,2,2,2,3,3,3,4,5,5,6,6,6,6,7,7,7,7,8,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        // int[] nums2 = {-10,-10,-9,-9,-9,-9,-8,-8,-8,-8,-8,-7,-7,-7,-7,-7,-7,-7,-7,-6,-6,-6,-6,-5,-5,-5,-5,-5,-4,-4,-4,-4,-4,-3,-3,-3,-2,-2,-2,-2,-2,-2,-2,-1,-1,-1,0,0,0,0,0,1,1,1,2,2,2,2,2,2,2,2,3,3,3,3,4,4,4,4,4,4,4,5,5,5,5,5,5,6,6,6,6,6,7,7,7,7,7,7,7,8,8,8,8,9,9,9,9};
        // int[] nums1 = {-10, -1, 0, 3, 3, 3, 0, 0, 0};
        // int[] nums2 = {-9, 2, 2};
        // int[] nums1 = {-1, 0, 0, 3, 3, 3, 0, 0, 0};
        // int[] nums2 = {1, 2, 2};
        int[] nums1 = {-30, -20, 0, 0, 0, 0};
        int[] nums2 = {-1, 0};
        merge(nums1, 4, nums2, 2);
        // System.arraycopy(nums2, 0, nums1, 4, 2);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        int maxLen = Integer.MIN_VALUE;
        //寻找数组中的最大位数
        for (int i = 0; i < m + n; i++) {
            if (nums1[i] > maxLen) {
                maxLen = nums1[i];
            }
        }
        maxLen = String.valueOf(maxLen).length();
        //创建一个二维数组用于村粗每次排序的结果
        int[][] bucket = new int[20][m + n];
        //创建一个一维数组记录二维数组中行的元素总数
        int[] row = new int[20];
        for (int i = 0, c = 1; i < maxLen; i++, c *= 10) {
            //比较每个元素的每一位的大小，并存进桶
            for (int j = 0; j < m + n; j++) {
                int mod = nums1[j] / c % 10;
                if (nums1[j] < 0 && mod == 0) {
                    mod = 0;
                } else if (mod >= 0) {
                    mod = 10 + mod;
                } else {
                    mod = -mod;
                }
                bucket[mod][row[mod]] = nums1[j];
                row[mod]++;
            }
            //每比较一轮后将桶中的元素取出
            int index = 0;

            for (int k = 0; k < 20; k++) {
                if (k > 0 && k < 10) {
                    if (row[10 - k] != 0) {
                        for (int l = 0; l < row[10 - k]; l++) {
                            nums1[index] = bucket[10 - k][l];
                            index++;
                            //把count的k个元素置零

                        }
                        row[10 - k] = 0;
                    }
                } else {
                    if (row[k] != 0) {
                        for (int l = 0; l < row[k]; l++) {
                            nums1[index] = bucket[k][l];
                            index++;
                        }
                        //把count的k个元素置零
                        row[k] = 0;
                    }
                }
            }
        }
    }
}
