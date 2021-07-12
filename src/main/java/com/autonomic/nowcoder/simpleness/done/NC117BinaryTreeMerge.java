/*
 * Copyright (c) 2021.  User:Unique66 File:NC117BinaryTreeMerge.java
 * Date:2021/07/13 00:57:13
 */

package com.autonomic.nowcoder.simpleness.done;

/**
 * @author Unique66
 * @description NC117 合并二叉树
 * @date 2021/7/10 22:28
 *
 * https://www.nowcoder.com/practice/7298353c24cc42e3bd5f0e0bd3d1d759?tpId=117&&tqId=37841&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 已知两颗二叉树，将它们合并成一颗二叉树。合并规则是：都存在的结点，就将结点值加起来，
 * 否则空的位置就由另一个树的结点来代替。例如：
 * 两颗二叉树是:
 * Tree 1
 *      1
 *     / \
 *    3   2
 *   /
 *  5
 *
 * Tree 2
 *    2
 *   / \
 *  1   3
 *   \   \
 *    4   7
 *
 * 合并后的树为
 *     3
 *    / \
 *   4   5
 *  / \    \
 * 5  4    7
 *
 * 示例1
 * 输入：{1,3,2,5},{2,1,3,#,4,#,7}
 * 返回值：{3,4,5,5,4,#,7}
 */
public class NC117BinaryTreeMerge {
    /**
     *
     * @param t1 TreeNode类
     * @param t2 TreeNode类
     * @return TreeNode类
     */
    // 题解中较为简洁的写法（我的写法）
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        TreeNode tempNode = new TreeNode(t1.val + t2.val);
        tempNode.left = mergeTrees(t1.left, t2.left);
        tempNode.right = mergeTrees(t1.right, t2.right);
        return tempNode;
    }

    // 题解中较为简洁的写法（题解中看到的）
    public TreeNode mergeTrees2 (TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    // 自己的写法，初次
    public TreeNode mergeTrees1 (TreeNode t1, TreeNode t2) {
        // write code here
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode mergeTree;
        if (t1 == null || t2 == null) {
            mergeTree = t1 == null ? t2 : t1;
        } else {
            mergeTree = new TreeNode(t1.val + t2.val);
        }
        if (t1 == null) {
            mergeTree.left = mergeTrees1(null, t2.left);
            mergeTree.right = mergeTrees1(null, t2.right);
        } else if (t2 == null) {
            mergeTree.left = mergeTrees1(t1.left, null);
            mergeTree.right = mergeTrees1(t1.right, null);
        } else {
            mergeTree.left = mergeTrees1(t1.left, t2.left);
            mergeTree.right = mergeTrees1(t1.right, t2.right);
        }
        return mergeTree;
    }
}
