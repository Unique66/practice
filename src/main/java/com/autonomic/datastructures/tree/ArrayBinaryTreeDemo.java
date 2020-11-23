/*
 * Copyright (c) 2020.  User:SXH  File:ArrayBinaryTreeDemo.java
 * Date:2020/11/23 22:39:23
 */

package com.autonomic.datastructures.tree;

/**
 * @author SXH
 * @description 数组实现的顺序存储二叉树
 * @date 2020/11/23 22:39
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preList(0);
    }


}

class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 从数据存储来看，数组存储方式和树的存储方式可以互相转换，即数组可以转换成树，树也可以转换成数组
     * 实现前序遍历 ： 父节点、左子节点、右子节点
     *
     * @param index 数组实现的树的下标
     */
    public void preList(int index) {
        System.out.println(arr[index]);
        // 左子树
        if ((2 * index + 1) < arr.length) {
            preList(2 * index + 1);
        }

        // 右子树
        if ((2 * index + 2) < arr.length) {
            preList(2 * index + 2);
        }
    }

}
