package com.sen.hash;

import java.util.Arrays;

/**
 * @Auther: Sen
 * @Date: 2019/10/21 22:05
 * @Description: 散列表
 */
public class HashTable {

    private StudentInfo[] data = new StudentInfo[100];

    /**
     * 存入散列表
     * @param studentInfo
     */
    public void put(StudentInfo studentInfo) {
        int index = studentInfo.getHashCode();
        data[index] = studentInfo;
    }

    /**
     * 获取散列表的数据
     * @param studentInfo
     * @return
     */
    public StudentInfo get(StudentInfo studentInfo) {
        return data[studentInfo.getHashCode()];
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
