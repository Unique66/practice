/*
 * Copyright (c) 2021.  User:Unique66 File:NC62BalancedBinaryTree.java
 * Date:2021/07/07 00:12:07
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC62 平衡二叉树 考察点：树、dfs
 * @date 2021/7/7 0:12
 *
 * https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=117&&tqId=37757&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，
 * 并且左右两个子树都是一棵平衡二叉树。
 *
 * 注：我们约定空树是平衡二叉树。
 *
 * 示例1
 * 输入：{1,2,3,4,5,6,7}
 * 返回值：true
 */
public class NC62BalancedBinaryTree {
    boolean flag = true; // 判断是否是平衡二叉树
    public boolean IsBalanced_Solution(TreeNode root) {
        // 空树也是平衡二叉树
        if (root == null) {
            return true;
        }
        depth(root);
        return flag;
    }

    // 获取深度的方法
    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right); // 向右递归
        // 比较左右子树的深度差值
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return Math.max(left, right) + 1;
    }
}
