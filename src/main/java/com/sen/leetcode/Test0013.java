package com.sen.leetcode;


/**
 * @Auther: Sen
 * @Date: 2019/11/24 19:25
 * @Description:
 */
public class Test0013 {

    public static void main(String[] args) {
        // Queue<String> queue = new LinkedList<>();
        // queue.isEmpty();
    }
    public int romanToInt(String s) {
        char[] ch = s.toCharArray();
        int count = 0;
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == 'I' && ch[ i + 1] == 'V'){
                i++;
                count += 4;
            }else if(ch[i] == 'I' && ch[i + 1] == 'X'){
                i++;
                count += 9;
            }else if(ch[i] == 'X' && ch[ i + 1] == 'L'){
                i++;
                count +=40;
            }else if(ch[i] == 'X' && ch[ i + 1] == 'C'){
                i++;
                count +=90;
            }else if(ch[i] == 'C' && ch[ i + 1] == 'D'){
                i++;
                count +=500;
            }else if(ch[i] == 'C' && ch[ i + 1] == 'M'){
                i++;
                count +=900;
            }else if(ch[i] == 'I'){
                count ++;
            }else if(ch[i] == 'V'){
                count += 5;
            }else if(ch[i] == 'X'){
                count += 10;
            }else if(ch[i] == 'L'){
                count += 50;
            }else if(ch[i] == 'C'){
                count += 100;
            }else if(ch[i] == 'D'){
                count += 500;
            }else if(ch[i] == 'M'){
                count += 1000;
            }
        }
        return count;
    }
}
