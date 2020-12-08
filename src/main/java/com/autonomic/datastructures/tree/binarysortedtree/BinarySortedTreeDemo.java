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
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
//        int[] arr = {7, 3, 5, 1, 9};
        BinarySortedTree binarySortedTree = new BinarySortedTree();
        for (int a : arr) {
            binarySortedTree.addNode(new Node(a));
        }
        // 测试删除叶子节点
//        binarySortedTree.delNode(1);
//        // 测试删除节点只有一个子节点
//        binarySortedTree.delNode(3);

        // 测试删除节点有两个子节点
//        binarySortedTree.delNode(9);


        binarySortedTree.delNode(1);
        binarySortedTree.delNode(5);
        binarySortedTree.delNode(9);
        binarySortedTree.delNode(12);
        binarySortedTree.delNode(3);
        binarySortedTree.delNode(7);

        System.out.println("二叉排序树中序遍历结果：");
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

    /****
     * 删除节点
     *
     * @param: value 待删除节点的value
     */
    public void delNode(int value) {
        if (root == null) {
            System.out.println("null tree");
            return;
        } else {
            Node delNode = this.getDelNode(value); // 待删除节点
            // 没有要删除的节点，那么就不处理了
            if (delNode == null) {
                System.out.println("has no del Node");
                return;
            }
            // 如果树只有一个根节点
            if (root.left == null && root.right == null) {
                // 上面的if 判断过后，说明找到了要删除的节点，此时树只有一个根节点，
                // 那么就删除这个根节点即可
                root = null;
                return;
            }
            Node delNodeParent = this.getDelNodeParent(value); // 得到待删除节点的父节点
            if (delNode.left == null && delNode.right == null) { // 是叶子节点
                System.out.println("待删除节点是叶子节点");
                // 判断待删除节点是父节点的左子节点还是右子节点
                if (delNodeParent.left != null && delNodeParent.left.value == value) {
                    delNodeParent.left = null;
                } else if (delNodeParent.right != null && delNodeParent.right.value == value) {
                    delNodeParent.right = null;
                }
            } else if (delNode.left != null && delNode.right != null) {
                // 待删除节点有左右两个子节点
                System.out.println("待删除节点有两个子节点");
                // 待删除节点的左边子节点 向右找出最大值替换
                // 或待删除节点的右子节点，向左找最小值替换
                Node temp = delNode.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                // 走出循环，找到了最大值，填补到

                // 可以使用下面方法删除移动的节点
//                Node delNodeParent1 = getDelNodeParent(temp.value);
//                delNodeParent1.right = null;

                // 也可以使用delNode 方法删除
                delNode(temp.value);

                delNode.value = temp.value;
            } else {
                // 待删除节点只有一个节点，左子节点 或 右子节点
                // 如果待删除节点的子节点是左子节点
                System.out.println("待删除节点只有一个子节点");
                if (delNode.left != null) {
                    // 判断待删除节点是父节点的左子节点还是右子节点
                    // 如果是左子节点
                    if (delNodeParent != null) {
                        if (delNodeParent.left != null &&
                                delNodeParent.left.value == delNode.value) {
                            delNodeParent.left = delNode.left;
                        }
                        if (delNodeParent.right != null &&
                                delNodeParent.right.value == delNode.value) {
                            delNodeParent.right = delNode.left;
                        }
                    } else {
                        root = delNode.left;
                    }
                } else { // 如果待删除节点的子节点是右子节点
                    // 判断待删除节点是父节点的左子节点还是右子节点
                    // 如果是左子节点
                    if (delNodeParent != null) {
                        if (delNodeParent.left != null &&
                                delNodeParent.left.value == delNode.value) {
                            delNodeParent.left = delNode.right;
                        }
                        if (delNodeParent.right != null &&
                                delNodeParent.right.value == delNode.value) {
                            delNodeParent.right = delNode.right;
                        }
                    } else {
                        root = delNode.right;
                    }
                }
            }
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

    /**
     * ①获得待删除节点信息
     *
     * @param: value 待删除节点的value
     * @return Node 待删除节点
     */
    public Node getDelNode(int value) {
        // 比较待删除value 与当前节点的value 大小，小了向左，大了向右
        if (this.value > value) {
            if (this.left != null) {
                return this.left.getDelNode(value);
            } else {
                return  null;
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

    /***
     * 得到待删除节点的父节点
     *
     * @param: value 待删除节点的value 值
     * @return Node 待删除节点的父节点
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
}
