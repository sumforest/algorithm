package com.sen.queue;

/**
 * @Auther: Sen
 * @Date: 2019/10/17 14:53
 * @Description:
 */
public class QueueDemoTest {
    public static void main(String[] args) {
        QueueDemo queue = new QueueDemo();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.poll());
        System.out.println(queue.size());
    }
}
