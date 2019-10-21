package com.sen.hash;

/**
 * @Auther: Sen
 * @Date: 2019/10/21 22:04
 * @Description: 学生信息
 */
public class StudentInfo {

    private int age;

    private int count;

    /**
     * 获取hash码
     *
     * @return
     */
    public int getHashCode() {
        return this.age % 10;
    }

    public StudentInfo(int age, int count) {
        this.age = age;
        this.count = count;
    }

    public StudentInfo(int age) {
        this.age = age;
    }

    public StudentInfo() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "age=" + age +
                ", count=" + count +
                '}';
    }
}
