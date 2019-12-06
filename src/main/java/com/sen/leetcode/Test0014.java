package com.sen.leetcode;

/**
 * @Auther: Sen
 * @Date: 2019/12/4 00:03
 * @Description: 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 */
public class Test0014 {

    public static void main(String[] args) {
        String parttern = "abc";

        System.out.println(longestCommonPrefix(new String[]{"abb","abb","zzacd"}));
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            int temp = strs[i].indexOf(prefix);
            while (strs[i].indexOf(prefix) != 0) {
                temp = strs[i].indexOf(prefix);
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
