package com.sen.stack;

/**
 * @Auther: Sen
 * @Date: 2019/10/17 14:27
 * @Description:
 */
public class StackDemoTest {
    public static void main(String[] args) {
        StackDemo stackDemo = new StackDemo();
        stackDemo.push(9);
        stackDemo.push(8);
        stackDemo.push(7);
        System.out.println(stackDemo.size());
        System.out.println(stackDemo.pop());
        // System.out.println(stackDemo.pop());
        System.out.println(stackDemo.size());
        System.out.println(stackDemo.peek());
        System.out.println(stackDemo.isEmpty());
    }
}
