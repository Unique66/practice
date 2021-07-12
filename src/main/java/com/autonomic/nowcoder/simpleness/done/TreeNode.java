/*
 * Copyright (c) 2021.  User:Unique66 File:TreeNode.java
 * Date:2021/07/13 01:05:13
 */

package com.autonomic.nowcoder.simpleness.done;

/**
 * @author Unique66
 * @description TreeNode
 * @date 2021/7/13 1:05
 */
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
