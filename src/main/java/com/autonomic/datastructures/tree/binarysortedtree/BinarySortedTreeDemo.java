/*
 * Copyright (c) 2020.  User:SXH  File:BinarySortedTree.java
 * Date:2020/12/07 23:10:07
 */

package com.autonomic.datastructures.tree.binarysortedtree;

/**
 * @author SXH
 * @description 二叉排序树
 * 添加（创建），删除节点功能
 * @date 2020/12/7 23:09
 */
public class BinarySortedTreeDemo {
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 2, 8, 9, 7, 10};
        BinarySortedTree binarySortedTree = new BinarySortedTree();
        for (int a : arr) {
            binarySortedTree.addNode(new Node(a));
        }
        binarySortedTree.infixOrder();
    }
}

class BinarySortedTree {
    private Node root;



    /**
     * 添加节点
     * @param: node 新增节点
     */
    public void addNode(Node node) {
        if (root != null) {
            root.addNode(node);
        } else {
            root = node;
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("null tree");
        }
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    // 中序遍历，验证代码正确性
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 添加节点
     * 思想：当前节点的value 与传入value 对比
     **/
    public void addNode(Node node) {
        if (node == null) {
            return;
        }
        if (this.value > node.value) { // 向左子节点找
            if (this.left != null) { // 当前节点存在左子节点，那么递归找
                this.left.addNode(node);
            } else { // 左子节点为空，那么就直接加到左子节点
                this.left = node;
            }
        } else { // 向右子节点找
            if (this.right != null) { // 当前节点存在右子节点，那么递归找
                this.right.addNode(node);
            } else { // 右子节点为空，那么就直接加到右子节点
                this.right = node;
            }
        }
    }

    /**
     * 删除节点：
     *  前提：①找到要删除的节点
     *          根据二叉排序树的特性，从根节点开始，如果小于根节点value，那么向左递归找；如果大于根节点value，那么向右递归找（也可能没有要删除的节点）
     *       ②要删除节点的父节点
     *          同上，同时是this.left.value == value 或者 是this.right.value == value 返回this，上面两种情况都没有返回null 没有父节点
     * 有3种情况：
     *  1.删除叶子节点 （条件：找到待删除节点，待删除节点的左右子节点都为null）
     *      1）满足前提条件
     *      2）让其父节点的左右子节点value 与待删除节点对比，确认待删除节点时左子节点还是右子节点，
     *          然后parent.left = null 或者 parent.right = null
     *
     *  2.删除只有一个子节点的节点 可以是左子节点或者右子节点 （这个写在else 里面，不满足其他两种情况的就是这种情况了）
     *      1）满足前提条件
     *      2）待删除节点它的子节点是左子节点
     *      2.1）如果待删除节点是父节点的左子节点，那么 parent.left = this.left
     *      2.2）如果待删除节点是父节点的右子节点，那么 parent.right = this.left
     *      3）待删除节点它的子节点是右子节点
     *      3.1）如果待删除节点是父节点的左子节点，那么 parent.left = this.right
     *      3.2）如果待删除节点是父节点的右子节点，那么 parent.right = this.right
     *
     *  3.删除有两个子节点的节点 （条件：找到待删除节点，待删除节点的左右子节点都不为空）
     *      1）满足前提条件
     *      2）因为待删除节点左右子节点都有，可以以该待删除节点为根节点，向左子树开始delNode.left,找其右子节点（也就是最大值）
     *      3）找到最大值后，记录该值，然后将该最大值所在节点置空，替换到待删除节点的位置。
     *
     *      或者
     *      2）因为待删除节点左右子节点都有，可以以该待删除节点为根节点，向右子树开始delNode.right,找其左子节点（也就是最小值）
     *      3）找到最小值后，记录该值，然后将该最小值所在节点置空（删除），替换到待删除节点的位置。
     */
}
