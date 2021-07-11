/*
 * Copyright (c) 2021.  User:Unique66 File:NC98T1SubtreeSameTopologyAsTheT2Tree.java
 * Date:2021/07/10 22:27:10
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC98 判断t1树中是否有与t2树拓扑结构完全相同的子树
 * @date 2021/7/10 22:27
 *
 * https://www.nowcoder.com/practice/4eaccec5ee8f4fe8a4309463b807a542?tpId=117&&tqId=37821&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 给定彼此独立的两棵二叉树，判断 t1 树是否有与 t2 树拓扑结构完全相同的子树。
 * 设 t1 树的边集为 E1，t2 树的边集为 E2，若 E2 等于 E1 ，则表示 t1 树和t2 树的拓扑结构完全相同。
 *
 * 示例1
 * 输入：{1,2,3,4,5,6,7,#,8,9},{2,4,5,#,8,9}
 * 返回值：true
 *
 * 备注：
 * 1 ≤ n ≤ 500000
 */
public class NC98T1SubtreeSameTopologyAsTheT2Tree {
    /**
     * @param root1 TreeNode类
     * @param root2 TreeNode类
     * @return bool布尔型
     */
    public boolean isContains(TreeNode root1, TreeNode root2) {
        // write code here
        if (root1 == null) {
            return false;
        }
        return isContains(root1.left, root2) || isContains(root1.right, root2)
                || isSubTree(root1, root2);
    }

    public boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return isSubTree(root1.left, root2.left)
                && isSubTree(root1.right, root2.right);
    }

    // 该方法只能通过9成用例， {23,4,56,8,9,7,#},{4,8,#} 不通过
    public boolean isContains1(TreeNode root1, TreeNode root2) {
        // write code here
        StringBuffer res1 = new StringBuffer();
        StringBuffer res2 = new StringBuffer();
        middleList(root1, res1);
        middleList(root2, res2);
        return res1.toString().contains(res2.toString());
    }

    public void middleList(TreeNode root, StringBuffer res) {
        if (root == null) {
            return;
        }
        middleList(root.left, res);
        res.append(root.val);
        middleList(root.right, res);
    }
}
