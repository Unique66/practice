/*
 * Copyright (c) 2021.  User:Unique66 File:NC13MaximumDepthOfBinaryTree.java
 * Date:2021/07/06 00:51:06
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC13 二叉树的最大深度 考察点：树、dfs
 * @date 2021/7/6 0:51
 *
 * https://www.nowcoder.com/practice/8a2b2bf6c19b4f23a9bdb9b233eefa73?tpId=117&&tqId=37721&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 求给定二叉树的最大深度，
 * 最大深度是指树的根结点到最远叶子结点的最长路径上结点的数量。
 *
 * 示例1
 * 输入：{1,2}
 * 返回值：2
 *
 * 示例2
 * 输入：{1,2,3,4,#,#,5}
 * 返回值：3
 */
public class NC13MaximumDepthOfBinaryTree {
    /**
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth (TreeNode root) {
        // write code here
        // 其实就是求树的层数
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left); // 以左孩子节点为根节点的的深度
        int right = maxDepth(root.right); // 以右孩子节点为根节点的的深度
        // 取深度大的那一个
        return Math.max(left, right) + 1;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}
