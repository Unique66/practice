/*
 * Copyright (c) 2020.  User:SXH  File:ThreadBinaryTreeDemo.java
 * Date:2020/12/01 22:42:01
 */

package com.autonomic.datastructures.tree.threadbinarytree;

/**
 * @author SXH
 * @description TODO
 * @date 2020/12/1 22:42
 */
public class ThreadBinaryTreeDemo {
    public static void main(String[] args) {
        // 测试中序线索二叉树功能
        ThreadTreeNode root = new ThreadTreeNode(1, "tom");
        ThreadTreeNode node2 = new ThreadTreeNode(3, "jack");
        ThreadTreeNode node3 = new ThreadTreeNode(6, "smith");
        ThreadTreeNode node4 = new ThreadTreeNode(8, "mary");
        ThreadTreeNode node5 = new ThreadTreeNode(10, "king");
        ThreadTreeNode node6 = new ThreadTreeNode(14, "dim");

        // 二叉树手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        // 测试线索化
        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();
        threadBinaryTree.setRoot(root);
        // 线索化二叉树前
        System.out.println("线索化二叉树前");
        threadBinaryTree.innerList();
        threadBinaryTree.threadedNodes();
        // 线索化二叉树后 （递归方式）
        System.out.println("线索化二叉树后（递归方式）");
        threadBinaryTree.innerList();
        // 线索化二叉树后 非递归方式中序遍历
        System.out.println("线索化二叉树后（非递归方式）");
        threadBinaryTree.threadedInnerList();

        // 测试
        ThreadTreeNode leftNode = node5.getLeft();
        System.out.println("10号节点的前驱节点是：" + leftNode);
        ThreadTreeNode rightNode = node5.getRight();
        System.out.println("10号节点的后继节点是：" + rightNode);
    }
}

// 定义ThreadedBinaryTree 实现了线索化功能的二叉树
class ThreadBinaryTree {
    private ThreadTreeNode root;

    // 为了实现线索化，需要创建要给指向当前节点的前驱节点的指针
    // 在递归进行线索化时，pre 总是保留前一个节点
    private ThreadTreeNode pre;

    public void setRoot(ThreadTreeNode root) {
        this.root = root;
    }

    // 中序遍历线索化二叉树方法（非递归方式）
    public void threadedInnerList() {
        // 定义一个变量，存储当前遍历的节点，从root 开始
        ThreadTreeNode node = root;
        while (node != null) {
            // 循环的找到leftType == 1 的节点，第一个找到的是8
            // 后面随遍历而变化，因为当leftType == 1时，说明该节点是按照线索化处理后的有效节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            // 打印当前节点
            System.out.println(node);

            // 如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType() == 1) {
                // 获取到当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            // 退出上面的循环说明rightType == 0  替换这个遍历的节点
            node = node.getRight();
        }
    }

    public void threadedNodes() {
        this.threadedNodes(root);
    }

    // 编写对二叉树进行中序线索化方法
    public void threadedNodes(ThreadTreeNode node) {
        // 如果node == null,不能线索化
        if (node == null) {
            return;
        }

        // 1.中序线索化先线索化左子树
        threadedNodes(node.getLeft());
        // 2.再线索化当前结点
        // 例如：{1, 3, 6, 8, 10, 14} 完全二叉树 中序遍历结果{8, 3, 10, 1, 14, 6}
        // 此时node 假设是8，那么pre 就是null了，leftType == 1
        if (node.getLeft() == null) {
            // 让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            // 修改当前结点的左指针类型，指向前驱节点
            node.setLeftType(1);
        }

        // 处理后继节点
        if (pre != null && pre.getRight() == null) {
            // 前驱节点的右指针指向当前节点
            pre.setRight(node);
            // 修改前驱结点的右指针类型
            pre.setRightType(1);
        }
        // ！！！每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;

        // 3.最后线索化右子树
        threadedNodes(node.getRight());
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

    public ThreadTreeNode preFind(int no) {
        if (this.root != null) {
            return this.root.preFind(no);
        } else {
            System.out.printf("没有编号%d的节点", no);
            return null;
        }
    }

    public ThreadTreeNode innerFind(int no) {
        if (this.root != null) {
            return this.root.innerFind(no);
        } else {
            System.out.printf("没有编号%d的节点", no);
            return null;
        }
    }

    public ThreadTreeNode subFind(int no) {
        if (this.root != null) {
            return this.root.subFind(no);
        } else {
            System.out.printf("没有编号%d的节点", no);
            return null;
        }
    }

    /***
     * @return
     */
    public void delNode(int no) {
        // 1.首先判断根节点是否为空，为空则报树为空无法删除，不为空，判断根节点no 与待删除no 是否一致，一致删除整个树，不一致向下走
        if (this.root != null) {
            if (this.root.getId() == no) {
                this.root = null;
                return;
            } else {
                this.root.delNode(no);
            }
        } else {
            System.out.println("空树，无法delNode");
        }
    }
}

class ThreadTreeNode {
    private int id;
    private String name;
    private ThreadTreeNode left;
    private ThreadTreeNode right;

    // 如果leftType == 0 表示指向的是左子树，如果 == 1 表示指向前驱节点
    private int leftType;
    // 如果rightType == 0 表示指向的是右子树，如果 == 1 表示指向后继节点
    private int rightType;

    // 初始化节点信息
    public ThreadTreeNode(int id, String name) {
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

    public ThreadTreeNode getLeft() {
        return left;
    }

    public void setLeft(ThreadTreeNode left) {
        this.left = left;
    }

    public ThreadTreeNode getRight() {
        return right;
    }

    public void setRight(ThreadTreeNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "ThreadTreeNode{" +
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
        if (this.left != null && this.getLeftType() == 0) {
            this.left.innerList();
        }
        System.out.println(this);
        if (this.right != null && this.getRightType() == 0) {
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
     * @return ThreadTreeNode 如果查找到，返回  没有找到返回空
     */
    public ThreadTreeNode preFind(int no) {
        System.out.println("遍历@@@");
        if (this.getId() == no) { // 退出递归条件
            return this;
        }

        ThreadTreeNode resultNode = null;
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
     * @return ThreadTreeNode 如果查找到，返回  没有找到返回空
     */
    public ThreadTreeNode innerFind(int no) {
        ThreadTreeNode resultNode = null;
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
     * @return ThreadTreeNode 如果查找到，返回  没有找到返回空
     */
    public ThreadTreeNode subFind(int no) {
        ThreadTreeNode resultNode = null;
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


    /**
     * 递归删除节点
     * 规定：
     * 1）如果删除的节点是叶子节点，则删除该节点
     * 2）如果删除的节点是非叶子节点，则删除该子树
     *
     * 思路：
     * 1.首先判断根节点是否为空，为空则报树为空无法删除，不为空，判断根节点no 与待删除no 是否一致，一致删除整个树，不一致向下走
     * 2.判断左节点是否不为空并且左节点no == 待删除no ，删除并return
     * 3.同理判断右节点是否不为空并且节点no == 待删除节点，相等则删除并return
     * 4.走到这步说明左右都没有找到待删除的节点，那么就拿节点向左递归
     * 5.左递归没有找到，那么就右递归
     * @param no 待删除节点ID
     */

    public void delNode(int no) {
        // 2.判断左节点是否不为空并且左节点no == 待删除no ，删除并return
        if (this.left != null && this.left.getId() == no) {
            this.left = null;
            return;
        }
        // 3.同理判断右节点是否不为空并且节点no == 待删除节点，相等则删除并return
        if (this.right != null && this.right.getId() == no) {
            this.right = null;
            return;
        }
        // 4.走到这步说明左右都没有找到待删除的节点，那么就拿节点向左递归
        if (this.left != null) {
            this.left.delNode(no);
        }

        // 5.左递归没有找到，那么就右递归
        if (this.right != null) {
            this.right.delNode(no);
        }
    }
}