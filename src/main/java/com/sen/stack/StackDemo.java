package com.sen.stack;

/**
 * @Auther: Sen
 * @Date: 2019/10/17 14:17
 * @Description: 自我实现栈结构
 */
public class StackDemo {

    private int[] stack;

    public StackDemo() {
        stack = new int[0];
    }

    /**
     * 压栈
     * @param element 元素
     */
    public void push(int element) {
        //创建一个新的数组
        int[] newArrary = new int[stack.length + 1];
        //把原数组的值复制到新数组
        for (int i = 0; i < stack.length; i++) {
            newArrary[i] = stack[i];
        }
        newArrary[newArrary.length - 1] = element;
        stack = newArrary;
    }

    /**
     * 出栈
     * @return 栈顶元素
     */
    public int pop() {
        if (stack.length == 0) {
            throw new RuntimeException("Stack is empty");
        }
        //创建一个新的数组
        int[] newArrary = new int[stack.length - 1];
        Integer popElement = null;
        //把原数组的值复制到新数组
        for (int i = 0; i < newArrary.length; i++) {
            newArrary[i] = stack[i];
        }
        popElement = stack[stack.length - 1];
        stack = newArrary;
        return popElement;
    }

    /**
     * 获取栈的大小
     * @return 大小
     */
    public int size() {
        return stack.length;
    }

    /**
     * 查看栈顶元素
     * @return
     */
    public int peek() {
        if (stack.length == 0) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[stack.length - 1];
    }

    /**
     * 查看栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return stack.length == 0;
    }
}
