package com.sen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/12/4 23:53
 * @Description: 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class Test0022 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
        int[][] table = new int[5][10];
        System.out.println(table.length);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, n, n, "");
        return res;
    }
    private static void backtrack(List<String> res ,int left ,int right, String cur){
        //递归结束条件
        if(left == 0 && right == 0){
            res.add(cur);
            return;
        }
        if(left > 0){
            backtrack(res, left - 1, right, cur + "(");
        }
        if(right > 0 && left < right){
            backtrack(res, left, right - 1,cur + ")");
        }
    }
}
