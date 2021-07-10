/*
 * Copyright (c) 2021.  User:Unique66 File:NC81TheKTHNodeOfBinaryTree.java
 * Date:2021/07/08 01:22:08
 */

package com.autonomic.nowcoder.simpleness;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Unique66
 * @description NC81 二叉搜索树的第k个结点 考察点：树
 * @date 2021/7/8 1:22
 *
 * https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a?tpId=117&&tqId=37783&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 给定一棵二叉搜索树，请找出其中的第k小的TreeNode结点。
 *
 * 示例1
 * 输入：{5,3,7,2,4,6,8},3
 * 返回值：4
 * 说明：按结点数值大小顺序第三小结点的值为4
 */
public class NC81TheKTHNodeOfBinaryTree {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 1) {
            return null;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 使用临时变量来处理遍历
        TreeNode cur = pRoot;
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
            list.add(cur);
            // 处理右子节点
            if (cur != null && cur.right != null) {
                stack.add(cur.right);
                cur = cur.right;
            } else {
                cur = null;
            }
        }
        return k <= list.size() ? list.get(k - 1) : null;
    }
}
