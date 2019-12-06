package com.sen.leetcode;

import java.util.*;

/**
 * @Auther: Sen
 * @Date: 2019/12/6 01:47
 * @Description: 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Test0105 {

    public static void main(String[] args) {
        myBuildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        List<Integer> list = new ArrayList<>();
        list.add(-3);
        list.add(-9);
        list.add(10);
        int[] temp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            temp[i] = list.get(i);
        }
        Arrays.sort(temp);
        System.out.println(Arrays.toString(temp));
    }
    static int prd_index = 0;

    public static TreeNode myBuildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildHelper(preorder, map, 0, preorder.length);
    }

    private static TreeNode buildHelper(int[] preorder,Map<Integer,Integer> map, int left, int right){
        if(left == right){
            return null;
        }
        int val = preorder[prd_index];
        TreeNode root = new TreeNode(val);
        //前序遍历的数组下标右移
        prd_index++;
        //获取中序遍历的下标确定递归结束的条件
        int index = map.get(val);
        //左子树递归
        root.left = buildHelper(preorder, map, left, index);
        //右子树递归
        root.right = buildHelper(preorder, map, index + 1, right);
        return root;
    }

     static int pre_idx = 0;
     static int[] preorder;
     static int[] inorder;
     static HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public static TreeNode helper(int in_left, int in_right) {
        if (in_left == in_right)
            return null;

        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);

        int index = idx_map.get(root_val);

        pre_idx++;
        root.left = helper(in_left, index);
        root.right = helper(index + 1, in_right);
        return root;
    }
    public static TreeNode buildTree(int[] preorder1, int[] inorder1) {
        preorder = preorder1;
        inorder = inorder1;

        int idx = 0;
        for (Integer val : inorder)
            idx_map.put(val, idx++);
        return helper(0, inorder.length);
    }

}
