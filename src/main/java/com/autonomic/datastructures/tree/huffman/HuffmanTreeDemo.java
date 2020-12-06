/*
 * Copyright (c) 2020.  User:SXH  File:HuffmanDemo.java
 * Date:2020/12/03 23:04:03
 */

package com.autonomic.datastructures.tree.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author SXH
 * @description 赫夫曼树
 * @date 2020/12/3 23:04
 */
public class HuffmanTreeDemo {
    public static void main(String[] args) {
//        int[] arr = {13, 3, 7, 8};  // 简单示例用来写代码时捋思路
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        HuffmanTree huffmanTree = new HuffmanTree();
        HuffmanNode root = huffmanTree.getHuffmanTree(arr);
        huffmanTree.root = root;
        // 调用前序遍历，检查生成的赫夫曼树是否符合预期
        huffmanTree.preOrder();
    }
}

/** 赫夫曼树 **/
class HuffmanTree {
    public HuffmanNode root;

    // 组赫夫曼树， 原始节点始终是在叶子节点上的
    public HuffmanNode getHuffmanTree(int[] arr) {
        // 1)创建一个链表，存放数组对应的节点
        List<HuffmanNode> nodes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nodes.add(new HuffmanNode(arr[i]));
        }

        // 测试排序
//        System.out.println(nodes.toString());
//        Collections.sort(nodes);
//        System.out.println(nodes.toString());

        while (nodes.size() > 1) { // 只要节点列表中还有节点，就继续循环处理，直到剩下一个节点
            // 2)将节点按从小到大顺序排序
            Collections.sort(nodes);

            // 3) 取前两个节点（较小） 相加得到父节点的value
            HuffmanNode leftNode = nodes.get(0);
            HuffmanNode rightNode = nodes.get(1);
            HuffmanNode parent = new HuffmanNode(leftNode.value + rightNode.value);
            // 4)将左右节点加到父节点
            parent.left = leftNode;
            parent.right = rightNode;

            // 5)将新生成父节点加到列表中，之前的节点从列表中移出
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
            // 接下来循环此操作
        }
        return nodes.get(0);
    }

    // 前序遍历
    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树");
        }
    }
}

/** 节点 实现Comparable 接口，以便排序 **/
class HuffmanNode implements Comparable<HuffmanNode> {
    public int value; // 权重
    public char contain; // 代表的符号
    public HuffmanNode left; // 左子节点
    public HuffmanNode right; // 右子节点

    public HuffmanNode(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "value=" + value +
                ", contain=" + contain +
                '}';
    }

    // 前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
