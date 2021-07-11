/*
 * Copyright (c) 2021.  User:Unique66 File:NC11ConvertsAscArrayToBalancedBST.java
 * Date:2021/07/10 22:34:10
 */

package com.autonomic.nowcoder.simpleness;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Unique66
 * @description NC11 将升序数组转化为平衡二叉搜索树
 * @date 2021/7/10 22:34
 *
 * https://www.nowcoder.com/practice/7e5b00f94b254da599a9472fe5ab283d?tpId=117&&tqId=37720&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 给出一个升序排序的数组，将其转化为平衡二叉搜索树（BST）.
 *
 * 示例1
 * 输入：[-1,0,1,2]
 * 返回值：{1,0,2,-1}
 */
public class NC11ConvertsAscArrayToBalancedBST {
    /**
     * @param num int整型一维数组
     * @return TreeNode类
     */
    // 换一种思路：使用分治的逻辑
    public TreeNode sortedArrayToBST(int[] num) {
        // write code here
        if (num == null || num.length == 0) {
            return null;
        }
        return helper(num, 0, num.length - 1);
    }

    public TreeNode helper(int[] num, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l + 1) / 2; // 题目中的示例可以得知，使用此去中方式才合适
//         int mid = (l + r) / 2;
        TreeNode midNode = new TreeNode(num[mid]);
        // 左边分配
        midNode.left = helper(num, l, mid - 1);
        // 右分配
        midNode.right = helper(num, mid + 1, r);
        return midNode;
    }

    // 浪费感情的解法，有问题：没有考虑空子节点
    public TreeNode sortedArrayToBST1(int[] num) {
        // write code here
        if (num == null || num.length == 0) {
            return null;
        }
        // 中序遍历还原二叉树
        LinkedList<Integer> list = new LinkedList<>();
        //
        middlerList(num.length, 0, list);
        int[] result = new int[num.length];
        for (int i = 0; i < list.size(); i++) {
            result[list.get(i)] = num[i];
        }
        System.out.println(Arrays.toString(result));
        // 通过数组创建树
        TreeNode node = new TreeNode(result[0]);
        createTreeByArray(result, 0, node);
        return node;

    }

    // 对数组进行中序遍历，获取数组中序遍历时的取值数组下标顺序
    public void middlerList(int len, int index, LinkedList<Integer> list) {
        // 对result 进行中序遍历
        if (index >= len) {
            return;
        }
        middlerList(len, index * 2 + 1, list);
        list.add(index);
        middlerList(len, index * 2 + 2, list);
    }

    public void createTreeByArray(int[] arr, int index, TreeNode node) {
        if (index >= arr.length) {
            return;
        }
        if (index * 2 + 1 < arr.length) {
            node.left = new TreeNode(arr[index * 2 + 1]);
            createTreeByArray(arr, index * 2 + 1, node.left);
        }
        if (index * 2 + 2 < arr.length) {
            node.right = new TreeNode(arr[index * 2 + 2]);
            createTreeByArray(arr, index * 2 + 2, node.right);
        }
    }
}
