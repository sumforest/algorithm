package com.sen.leetcode;

import java.util.*;

/**
 * @Auther: Sen
 * @Date: 2019/12/5 15:15
 * @Description: 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 示例 1:
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 */
public class Test0048 {

    public static void main(String[] args) {
        rotate2(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        });
        int[] arr = {1, 2, 3, 4};
    }
    public static void rotate(int[][] matrix) {
        Queue<Stack<Integer>> queue = new LinkedList<>();
        for(int x= 0; x < matrix.length; x++){
            Stack<Integer> stack = new Stack<>();
            for(int y = 0; y < matrix.length; y++){
                stack.push(matrix[y][x]);
            }
            queue.add(stack);
        }
        for(int x = 0; x < matrix.length; x++){
            Stack<Integer> stack = queue.poll();
            for(int y = 0; y < matrix.length; y++){
                matrix[x][y] = stack.pop();
            }
        }
    }
    public static void rotate2(int[][] matrix) {
        //先翻转
        for(int x= 0; x < matrix.length; x++){
            for(int y = x; y < matrix.length; y++){
                int temp = matrix[x][y];
                matrix[x][y] = matrix[y][x];
                matrix[y][x] = temp;
            }
        }
        //再旋转
        for(int x = 0; x < matrix.length; x++){
            for(int y = 0; y < matrix.length / 2; y++){
                int temp = matrix[x][matrix.length - y -1];
                matrix[x][matrix.length - y - 1] = matrix[x][y];
                matrix[x][y] = temp;
            }
        }
    }
}
