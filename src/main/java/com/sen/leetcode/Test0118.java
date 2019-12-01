package com.sen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Sen
 * @Date: 2019/11/24 16:14
 * @Description: 杨辉三角形
 */
public class Test0118 {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> rowList = new ArrayList<>();
            for(int j = i + 1; j > 0; j--){
                if(j == 1){
                    rowList.add(1);
                    break;
                }
                if(j == i + 1){
                    rowList.add(1);
                    continue;
                }
                if(resultList.size() > 1){
                    List<Integer> tempList = resultList.get( i - 1);
                    for(int k = 0; k < tempList.size(); k++){
                        if(k < tempList.size() - 1){
                            rowList.add(tempList.get(k) + tempList.get(k + 1));
                            if (k > 0) {
                                j --;
                            }
                        }
                    }
                }
            }
            resultList.add(rowList);
        }
        return resultList;
    }
}
