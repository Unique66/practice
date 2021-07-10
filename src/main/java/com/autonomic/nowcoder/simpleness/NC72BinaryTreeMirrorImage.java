/*
 * Copyright (c) 2021.  User:Unique66 File:NC72BinaryTreeMirrorImage.java
 * Date:2021/07/10 22:23:10
 */

package com.autonomic.nowcoder.simpleness;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Unique66
 * @description NC72 二叉树的镜像 考察点：树
 * @date 2021/7/10 22:23
 *
 * https://www.nowcoder.com/practice/a9d0ecbacef9410ca97463e4a5c83be7?tpId=117&&tqId=37769&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 比如：    源二叉树
 *              8
 *            /  \
 *           6   10
 *          / \  / \
 *         5  7 9  11
 *         镜像二叉树
 *              8
 *            /  \
 *           10   6
 *          / \  / \
 *         11 9 7   5
 * 示例1
 * 输入：{8,6,10,5,7,9,11}
 * 返回值：{8,10,6,11,9,7,5}
 */
public class NC72BinaryTreeMirrorImage {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pRoot TreeNode类
     * @return TreeNode类
     */

    // 利用层序遍历
    public TreeNode Mirror (TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        // 创建队列，存储层序遍历的数据
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 交换左右子节点
            TreeNode cur = node.left;
            node.left = node.right;
            node.right = cur;
            // 交换完毕后，两左右子节点压入队列
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return pRoot;
    }

    // 利用递归的方式，对对象做相关操作
    public TreeNode Mirror1 (TreeNode pRoot) {
        reverse(pRoot);
        return pRoot;
    }

    // 本质就是交换所有的左右子节点
    public void reverse (TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        // write code here
        if (pRoot.left == null && pRoot.right == null) {
            return;
        }
        // 此时交换左右节点
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        // 此时左右子节点都不为空
        reverse(pRoot.left);
        reverse(pRoot.right);
    }
}
