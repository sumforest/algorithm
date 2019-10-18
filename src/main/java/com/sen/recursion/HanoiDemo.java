package com.sen.recursion;

/**
 * @Auther: Sen
 * @Date: 2019/10/17 22:01
 * @Description: 递归解决汉诺塔问题
 */
public class HanoiDemo {
    public static void main(String[] args) {
        hanoi(3, 'A', 'B', 'C');
    }

    /**
     * 汉诺塔问题
     * @param n 盘子个数
     * @param from 开始柱子
     * @param in 中间柱子
     * @param to 目标柱子
     */
    public static void hanoi(int n, char from, char in, char to) {
        if (n == 1) {
            System.out.println("把第1个盘子从" + from + "移到" + to);
        }
        //无论多少个盘子都看成两个盘子组成，上面所有盘子和最下盘的盘子
        else {
            //把上面所有的盘子移到中间柱子
            hanoi(n-1, from, to, in);
            //把最下面的盘子移到目标柱子
            System.out.println("把第" + n + "个盘子从" + from + "移动到" + to);
            //把中间柱子的盘子移动到目标柱子
            hanoi(n-1, in, from, to);
        }
    }
}
