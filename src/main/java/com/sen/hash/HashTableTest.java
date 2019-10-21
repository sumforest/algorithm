package com.sen.hash;

/**
 * @Auther: Sen
 * @Date: 2019/10/21 22:11
 * @Description:
 */
public class HashTableTest {
    public static void main(String[] args) {
        StudentInfo s1 = new StudentInfo(16, 3);
        StudentInfo s2 = new StudentInfo(17, 5);
        StudentInfo s3 = new StudentInfo(18, 20);
        StudentInfo s4 = new StudentInfo(19, 19);
        StudentInfo s5 = new StudentInfo(20, 4);

        HashTable hashTable = new HashTable();
        hashTable.put(s1);
        hashTable.put(s2);
        hashTable.put(s3);
        hashTable.put(s4);
        hashTable.put(s5);

        System.out.println(hashTable);
        System.out.println(hashTable.get(new StudentInfo(16)).getCount());
    }
}
