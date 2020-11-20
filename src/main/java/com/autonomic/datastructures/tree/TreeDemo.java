/*
 * Copyright (c) 2020.  User:SXH  File:TreeDemo.java
 * Date:2020/11/20 23:22:20
 */

package com.autonomic.datastructures.tree;

/**
 * @author SXH
 * @description 树结构   前序、中序、后序遍历
 * @date 2020/11/20 23:22
 */
public class TreeDemo {
    /**
     * 思路：树有根节点、左子树、右子树
     */
    public static void main(String[] args) {
        Tree tree = new Tree();

        TreeNode root = new TreeNode(1, "宋江");
        root.setLeft(new TreeNode(2, "吴用"));
        root.setRight(new TreeNode(3, "卢俊义"));
        root.getRight().setRight(new TreeNode(4, "林冲"));
        root.getRight().setLeft(new TreeNode(5, "关胜"));

        tree.setRoot(root);

        tree.preList();
        System.out.println("$$$$$$$$$$$$$$$$$$$$");
        tree.innerList();
        System.out.println("$$$$$$$$$$$$$$$$$$$$");
        tree.subList();

        int no = 5;
        TreeNode treeNode = tree.subFind(no);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println(treeNode);
    }
}

class Tree {
    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void preList() {
        if (this.root != null) {
            this.root.preList();
        } else {
            System.out.println("树空");
        }
    }

    public void innerList() {
        if (this.root != null) {
            this.root.innerList();
        } else {
            System.out.println("树空");
        }
    }

    public void subList() {
        if (this.root != null) {
            this.root.subList();
        } else {
            System.out.println("树空");
        }
    }

    public TreeNode preFind(int no) {
        if (this.root != null) {
            return this.root.preFind(no);
        } else {
            System.out.printf("没有编号%d的节点", no);
            return null;
        }
    }

    public TreeNode innerFind(int no) {
        if (this.root != null) {
            return this.root.innerFind(no);
        } else {
            System.out.printf("没有编号%d的节点", no);
            return null;
        }
    }

    public TreeNode subFind(int no) {
        if (this.root != null) {
            return this.root.subFind(no);
        } else {
            System.out.printf("没有编号%d的节点", no);
            return null;
        }
    }
}

class TreeNode {
    private int id;
    private String name;
    private TreeNode left;
    private TreeNode right;

    // 初始化节点信息
    public TreeNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // 前序遍历  根节点、左节点、右节点
    public void preList() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preList();
        }
        if (this.right != null) {
            this.right.preList();
        }
    }

    // 中序遍历  左节点、根节点、右节点
    public void innerList() {
        if (this.left != null) {
            this.left.innerList();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.innerList();
        }
    }

    // 后序遍历  左节点、右节点、根节点
    public void subList() {
        if (this.left != null) {
            this.left.subList();
        }
        if (this.right != null) {
            this.right.subList();
        }
        System.out.println(this);
    }

    /***
     * 前序查找
     * @param: no 待查找的节点 id
     * @return TreeNode 如果查找到，返回  没有找到返回空
     */
    public TreeNode preFind(int no) {
        System.out.println("遍历@@@");
        if (this.getId() == no) { // 退出递归条件
            return this;
        }

        TreeNode resultNode = null;
        if (this.left != null) {
            resultNode = this.left.preFind(no);
        }
        if (resultNode != null) {
            return resultNode;
        }
        if (this.right != null) {
            resultNode = this.right.preFind(no);
        }
        return resultNode;
    }

    /**
     * 中序查找
     * @param: no 待查找的节点 id
     * @return TreeNode 如果查找到，返回  没有找到返回空
     */
    public TreeNode innerFind(int no) {
        TreeNode resultNode = null;
        if (this.left != null) {
            resultNode = this.left.innerFind(no);
        }
        if (resultNode != null) {
            return resultNode;
        }

        System.out.println("遍历@@@");
        if (this.getId() == no) { // 退出递归条件
            return this;
        }

        if (this.right != null) {
            resultNode = this.right.innerFind(no);
        }
        return resultNode;
    }

    /**
     * 后序查找
     * @param: no 待查找的节点 id
     * @return TreeNode 如果查找到，返回  没有找到返回空
     */
    public TreeNode subFind(int no) {
        TreeNode resultNode = null;
        if (this.left != null) {
            resultNode = this.left.subFind(no);
        }
        if (resultNode != null) {
            return resultNode;
        }

        if (this.right != null) {
            resultNode = this.right.subFind(no);
        }

        if (resultNode != null) {
            return resultNode;
        }

        System.out.println("遍历@@@");
        if (this.getId() == no) { // 退出递归条件
            return this;
        }
        return null;
    }
}
