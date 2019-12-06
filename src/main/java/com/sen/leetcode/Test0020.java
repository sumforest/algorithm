package com.sen.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Auther: Sen
 * @Date: 2019/12/3 16:06
 * @Description: 判断有效括号(栈实现)
 */
public class Test0020 {

    public static void main(String[] args) {
        isValid("()");
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        // map.containsKey("(");
        // stack.pop();
        String str = "hello";
        // str.charAt()
        str.length();
        System.out.println(str.indexOf("ll"));
        char[] chs = {'a', 'b'};
        String s = chs.toString();
        s.substring(0, 2);
        s.length();
    }
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        for(int i = 0, j = chars.length - 1; i < j; i++, j--){
            if(chars[i] != chars[i + 1] && chars[i] != chars[j]){
                return false;
            }
        }
        return true;
    }
}
