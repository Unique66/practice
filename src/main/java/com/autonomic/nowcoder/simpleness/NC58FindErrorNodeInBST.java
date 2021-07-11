/*
 * Copyright (c) 2021.  User:Unique66 File:NC58FindErrorNodeInBST.java
 * Date:2021/07/10 22:31:10
 */

package com.autonomic.nowcoder.simpleness;

import java.util.LinkedList;

/**
 * @author Unique66
 * @description NC58 找到搜索二叉树中两个错误的节点
 * @date 2021/7/10 22:31
 * <p>
 * https://www.nowcoder.com/practice/4582efa5ffe949cc80c136eeb78795d6?tpId=117&&tqId=37820&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，
 * 请按升序输出这两个错误节点的值。(每个节点的值各不相同)
 * <p>
 * 示例1
 * 输入：{1,2,3}
 * 返回值：[1,2]
 * <p>
 * 备注：
 * 1 ≤ n≤ 5 * 10^5
 */
public class NC58FindErrorNodeInBST {
    /**
     * @param root TreeNode类 the root
     * @return int整型一维数组
     */
    public int[] findError(TreeNode root) {
        // write code here
        // 中序遍历获得有序数组
        LinkedList<Integer> list = new LinkedList<>();
        middleList(root, list);
        int[] result = new int[2];
        int i, j;
        for (i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                result[1] = list.get(i);
                break;
            }
        }
        for (j = list.size() - 1; j > i; j--) {
            if (list.get(j) < list.get(j - 1)) {
                result[0] = list.get(j);
                break;
            }
        }
        return result;
    }

    public void middleList(TreeNode root, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        middleList(root.left, list);
        list.add(root.val);
        middleList(root.right, list);
    }
}
