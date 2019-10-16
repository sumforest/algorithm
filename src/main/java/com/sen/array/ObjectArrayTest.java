package com.sen.array;

/**
 * @Auther: Sen
 * @Date: 2019/10/17 00:13
 * @Description:
 */
public class ObjectArrayTest {
    public static void main(String[] args) {
        ObjectArray objectArray = new ObjectArray();
        //新增元素
        objectArray.add(1);
        objectArray.add(2);
        objectArray.add(3);
        objectArray.add(4);
        objectArray.add(5);
        System.out.println(objectArray.Size());
        objectArray.show();
        //删除指定下标的元素
        objectArray.delete(1);
        objectArray.show();
        System.out.println(objectArray.get(0));
        //往指定位置插入元素
        objectArray.insert(0, 123);
        objectArray.show();
        //替换指定位置的元素
        objectArray.set(0, 111);
        objectArray.show();
    }
}
