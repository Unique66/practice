/*
 * Copyright (c) 2020.  User:SXH  File:AvlTreeDemo.java
 * Date:2020/12/08 23:01:08
 */

package com.autonomic.datastructures.tree.avltree;

/**
 * @author SXH
 * @description 平衡二叉树
 * @date 2020/12/8 23:01
 */
public class AvlTreeDemo {
    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8}; // 验证单次左旋转
//        int[] arr = {10, 12, 8, 9, 7, 6}; // 验证单次右旋转
        int[] arr = {10, 11, 7, 6, 8, 9}; // 验证双旋转
        AvlTree avlTree = new AvlTree();
        for (int a : arr) {
            avlTree.addNode(new Node(a));
        }

        avlTree.infixOrder();
        System.out.println("树的高度：" + avlTree.getRoot().getHeight());
        System.out.println("树的左子树高度：" + avlTree.getRoot().left.getHeight());
        System.out.println("树的右子树高度：" + avlTree.getRoot().right.getHeight());
        System.out.println("验证双旋转后，节点位置是否正确：" + avlTree.getRoot().right.left); // 9
    }
}

class AvlTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

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

    // 封装获取待删除节点方法
    public Node getDelNode(int value) {
        if (root != null) {
            return root.getDelNode(value);
        } else {
            System.out.println("空树");
            return null;
        }
    }

    // 封装获取待删除节点的父节点方法
    public Node getDelNodeParent(int value) {
        if (root != null) {
            return root.getDelNodeParent(value);
        } else {
            return null;
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
     * 当前节点左旋转
     * 1.创建新的节点，value == 当前节点 的值
     * 2.让新节点的左子节点指向当前节点的左子节点
     * 3.新节点的右子节点指向当前节点的右子节点的左子节点
     * 4.当前节点的值替换为其右子节点的值
     * 5.当前节点的右子节点指向当前节点的右子节点的右子节点
     * 6.当前节点的左子节点指向新创建的节点
     */
    public void leftRotate() {
        // 1.创建新的节点，value == 当前节点 的值
        Node newNode = new Node(this.value);
        // 2.让新节点的左子节点指向当前节点的左子节点
        newNode.left = this.left;
        // 3.新节点的右子节点指向当前节点的右子节点的左子节点
        newNode.right = this.right.left;
        // 4.当前节点的值替换为其右子节点的值
        this.value = this.right.value;
        // 5.当前节点的右子节点指向当前节点的右子节点的右子节点
        this.right = this.right.right;
        // 6.当前节点的左子节点指向新创建的节点
        this.left = newNode;
    }

    /**
     * 当前节点右旋转
     * 1.创建一个新的节点，value == this.value
     * 2.新节点的右子节点指向当前节点的右子节点
     * 3.新节点的左子节点指向当前节点的左子节点的右子节点
     * 4.当前节点的值替换为其左子节点的值
     * 5.当前节点的左子节点指向当前节点的左子节点的左子节点
     * 6.当前节点的右子节点指向新创建的节点
     */
    public void rightRotate() {
        // 1.创建一个新的节点，value == this.value
        Node newNode = new Node(this.value);
        // 2.新节点的右子节点指向当前节点的右子节点
        newNode.right = this.right;
        // 3.新节点的左子节点指向当前节点的左子节点的右子节点
        newNode.left = this.left.right;
        // 4.当前节点的值替换为其左子节点的值
        this.value = this.left.value;
        // 5.当前节点的左子节点指向当前节点的左子节点的左子节点
        this.left = this.left.left;
        // 6.当前节点的右子节点指向新创建的节点
        this.right = newNode;
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

        // 添加左旋转 右子树高度 高于 左子树高度 且差值大于1
        if (this.rightHeight() - this.leftHeight() > 1) {
            /** ※如果当前节点的右子树的左子树高度大于其右子树高度，需要先对当前节点的右子树进行右旋转，然后再左旋转 **/
            if (this.right != null && this.right.leftHeight() > this.right.rightHeight()) {
                this.right.rightRotate();
                this.leftRotate();
            } else {
                this.leftRotate();
            }
            return;
        }

        // 添加右旋转  左子树高度 高于 右子树高度  且差值大于1
        if (this.leftHeight() - this.rightHeight() > 1) {
            /** ※如果当前节点的左子树的右子树高度大于其左子树高度，需要先对当前节点的左子树进行左旋转，然后再对当前节点右旋转 **/
            if (this.left != null && this.left.rightHeight() > this.left.leftHeight()) {
                this.left.leftRotate();
                this.rightRotate();
            } else {
                this.rightRotate();
            }
        }
    }


    /**
     * ①获得待删除节点信息
     *
     * @return Node 待删除节点
     * @param: value 待删除节点的value
     */
    public Node getDelNode(int value) {
        // 比较待删除value 与当前节点的value 大小，小了向左，大了向右
        if (this.value > value) {
            if (this.left != null) {
                return this.left.getDelNode(value);
            } else {
                return null;
            }
        } else if (this.value < value) {
            if (this.right != null) {
                return this.right.getDelNode(value);
            } else {
                return null;
            }
        } else {
            return this;
        }
    }

    /**
     * ②得到待删除节点的父节点
     *
     * @return Node 待删除节点的父节点
     * @param: value 待删除节点的value 值
     */
    public Node getDelNodeParent(int value) {
        if (this.value == value) {
            return null;
        }

        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.getDelNodeParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.getDelNodeParent(value);
            } else {
                return null;
            }
        }
    }

    /**
     * 计算以当前节点为根节点，树的高度
     */
    public int getHeight() {
        return Math.max(this.left == null ? 0 : this.left.getHeight(), this.right == null ? 0 : this.right.getHeight()) + 1;
    }

    /**
     * 获取左子树高度
     */
    public int leftHeight() {
        if (this.left != null) {
            return this.left.getHeight();
        } else {
            return 0;
        }
    }

    /**
     * 获取右子树高度
     */
    public int rightHeight() {
        if (this.right != null) {
            return this.right.getHeight();
        } else {
            return 0;
        }
    }
}