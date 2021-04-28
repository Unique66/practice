/*
 * Copyright (c) 2020.  User:SXH  File:TreeDemo.java
 * Date:2020/11/20 23:22:20
 */

package com.autonomic.datastructures.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        root.getLeft().setLeft(new TreeNode(4, "4"));
        root.getLeft().setRight(new TreeNode(5, "5"));
        root.getRight().setRight(new TreeNode(6, "林冲"));

        tree.setRoot(root);
        System.out.println("--------递归前序遍历$$$$$$$$$$$$$$$$$$$$");
        tree.preList();
        System.out.println("--------递归中序遍历$$$$$$$$$$$$$$$$$$$$");
        tree.innerList();
        System.out.println("--------递归后序遍历$$$$$$$$$$$$$$$$$$$$");
        tree.subList();

        int no = 5;
        TreeNode treeNode = tree.subFind(no);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println(treeNode);

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&");
//        tree.preList();
//        tree.delNode(5);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&");
        tree.preList();

        // test createBinaryTree()
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
        TreeNode treeRoot = Tree.createBinaryTree(inputList);

        System.out.println("--------非递归前序遍历$$$$$$$$$$$$$$$$$$$$");
        tree.preOrderWithStack();

        System.out.println("--------层序遍历$$$$$$$$$$$$$$$$$$$$");
        tree.floorList();
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

    public void preOrderWithStack() {
        if (this.root != null) {
            this.root.preOrderWithStack();
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

    // 广度优先-层序遍历
    public void floorList() {
        if (this.root != null) {
            this.root.floorList();
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

    /***
     * @return
     */
    public void delNode(int no) {
        // 1.首先判断根节点是否为空，为空则报树为空无法删除，不为空，判断根节点no 与待删除no 是否一致，一致删除整个树，不一致向下走
        if (this.root != null) {
            if (this.root.getId() == no) {
                this.root = null;
            } else {
                this.root.delNode(no);
            }
        } else {
            System.out.println("空树，无法delNode");
        }
    }

    /**
     * 使用链表结构递归创建逻辑树结构
     *
     * @return 根节点
     * @param: inputList
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        // 如果一个元素是空，则不再进一步递归
        if (data != null) {
            node = new TreeNode(data, data.toString());
            node.setLeft(createBinaryTree(inputList));
            node.setRight(createBinaryTree(inputList));
        }
        return node;
    }
}

class TreeNode {
    private Integer id;
    private String name;
    private TreeNode left;
    private TreeNode right;

    // 初始化节点信息
    public TreeNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    // 前序遍历，非递归方式
    public void preOrderWithStack() {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = this;
        while (treeNode != null || !stack.isEmpty()) {
            // 迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                System.out.println(treeNode.id);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            // 如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
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

    // 层序遍历，利用队列实现
    public void floorList() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.println(poll.id);
            if (poll.getLeft() != null) {
                queue.offer(poll.getLeft());
            }
            if (poll.getRight() != null) {
                queue.offer(poll.getRight());
            }
        }
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
     *
     * @return TreeNode 如果查找到，返回  没有找到返回空
     * @param: no 待查找的节点 id
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
     *
     * @return TreeNode 如果查找到，返回  没有找到返回空
     * @param: no 待查找的节点 id
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


    /**
     * 递归删除节点
     * 规定：
     * 1）如果删除的节点是叶子节点，则删除该节点
     * 2）如果删除的节点是非叶子节点，则删除该子树
     * <p>
     * 思路：
     * 1.首先判断根节点是否为空，为空则报树为空无法删除，不为空，判断根节点no 与待删除no 是否一致，一致删除整个树，不一致向下走
     * 2.判断左节点是否不为空并且左节点no == 待删除no ，删除并return
     * 3.同理判断右节点是否不为空并且节点no == 待删除节点，相等则删除并return
     * 4.走到这步说明左右都没有找到待删除的节点，那么就拿节点向左递归
     * 5.左递归没有找到，那么就右递归
     *
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

    /**
     * 递归删除节点
     * 规定：
     * 1）如果删除的节点是叶子节点，则删除该节点
     * 2）如果删除的节点是非叶子节点，如果只有左子节点，就用左子节点代替待删除节点
     * 3）如果左右节点都有，那么也是用左子节点代替待删除节点
     * TODO
     */
}
