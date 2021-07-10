/*
 * Copyright (c) 2021.  User:Unique66 File:NC16BinaryTreeIsSymmetric.java
 * Date:2021/07/08 01:09:08
 */

package com.autonomic.nowcoder.simpleness;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Unique66
 * @description NC16 判断二叉树是否对称 考察点：树、dfs、bfs
 * @date 2021/7/8 1:09
 *
 * https://www.nowcoder.com/practice/1b0b7f371eae4204bc4a7570c84c2de1?tpId=117&&tqId=37724&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
 * 例如：下面这棵二叉树是对称的
 * 1
 * /  \
 * 2    2
 * / \    / \
 * 3 4  4  3
 * 下面这棵二叉树不对称。
 * 1
 * / \
 * 2   2
 * \    \
 * 3    3
 *
 * 备注：
 * 希望你可以用递归和迭代两种方法解决这个问题
 *
 * 示例1
 * 输入：{1,2,2}
 * 返回值：true
 *
 * 示例2
 * 输入：{1,2,3,3,#,2,#}
 * 返回值：false
 */
public class NC16BinaryTreeIsSymmetric {
    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,2,3,4,4,3};
        int[] arr = new int[]{1,2,3,3,-1,2,-1};
        TreeNode root = new TreeNode(arr[0]);
        // 用数组创建二叉树
        creatTreeByArray(arr, 0, root);
        // 验证非递归实现的中序遍历
        middleList(root);
    }
    /**
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    // 迭代方式
    public boolean isSymmetric (TreeNode root) {
        // write code here
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null)
                continue;
            if(left == null || right == null)
                return false;
            if(left.val != right.val)
                return false;

            q.offer(left.left);
            q.offer(right.right);
            q.offer(left.right);
            q.offer(right.left);
        }
        return true;
    }

    // 递归方式
    public boolean isSymmetric1 (TreeNode root) {
        // write code here
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }


    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false; // 左右只有其中一个不为null
        }
        // 两个都不为null
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

    public static void middleList(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        // 使用临时变量来处理遍历
        TreeNode cur = root;
        // 将root 放入到栈中
        stack.add(cur);
        // 中序遍历：左子节点、根节点、右子节点
        while (!stack.isEmpty()) {
            while (cur != null && cur.left != null) {
                stack.add(cur.left);
                cur = cur.left;
            }
            // 中间节点
            cur = stack.pop();
            System.out.println(cur);
            // 处理右子节点
            if (cur != null && cur.right != null) {
                stack.add(cur.right);
                cur = cur.right;
            } else {
                cur = null;
            }
        }
    }

    /***
     * @param: arr 待处理数组
     * @param: curIndex 当前待处理元素的下标
     * @param: curNode  当前待处理的树
     * @return com.autonomic.nowcoder.simpleness.TreeNode
     */
    public static void creatTreeByArray(int[] arr, int curIndex, TreeNode curNode) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (curIndex * 2 + 1 < arr.length) {
            curNode.left = new TreeNode(arr[curIndex * 2 + 1]);
            creatTreeByArray(arr, curIndex * 2 + 1, curNode.left);
            if (curIndex * 2 + 2 < arr.length) {
                curNode.right = new TreeNode(arr[curIndex * 2 + 2]);
                creatTreeByArray(arr, curIndex * 2 + 2, curNode.right);
            }
        }
    }
}
