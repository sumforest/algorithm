package com.sen.queue;

/**
 * @Auther: Sen
 * @Date: 2019/10/17 14:46
 * @Description:
 */
public class QueueDemo {

    private int[] elements;

    public QueueDemo() {
        elements = new int[0];
    }

    /**
     * 入队
     * @param element
     */
    public void add(int element) {
        //创建一个新的数组
        int[] newArrary = new int[elements.length + 1];
        //把原数组的值复制到新数组
        for (int i = 0; i < elements.length; i++) {
            newArrary[i] = elements[i];
        }
        newArrary[newArrary.length - 1] = element;
        elements = newArrary;
    }

    /**
     * 出队
     * @return
     */
    public int poll() {
        int element = elements[0];
        //创建一个新的数组
        int[] newArrary = new int[elements.length - 1];
        for (int i = 0; i < newArrary.length; i++) {
            newArrary[i] = elements[i + 1];
        }
        elements = newArrary;
        return element;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return elements.length == 0;
    }
    /**
     * 获取队列的大小
     * @return
     */
    public int size() {
        return elements.length;
    }
}
