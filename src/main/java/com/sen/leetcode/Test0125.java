package com.sen.leetcode;

/**
 * @Auther: Sen
 * @Date: 2019/12/3 02:18
 * @Description: 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 */
public class Test0125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        for(int left = 0, right = chars.length - 1; left < right; left++,right--){
            boolean leftFlag = chars[left] >= '0' && chars[left] <= '9' || chars[left] >= 'a' && chars[left] <= 'z' ||                      chars[left] >= 'A' && chars[left] <= 'Z';
            boolean rightFlag = chars[right] >= '0' && chars[right] <= '9' || chars[right] >= 'a'
                    && chars[right] <= 'z' || chars[right] >= 'A' && chars[right] <= 'Z';
            if(!leftFlag && rightFlag) right++;
            if(leftFlag && !rightFlag) left--;
            if(leftFlag && rightFlag){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
            }
        }
        return s.equalsIgnoreCase(String.valueOf(chars));
    }
}
