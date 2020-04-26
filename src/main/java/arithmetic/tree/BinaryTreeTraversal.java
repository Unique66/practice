package arithmetic.tree;/**
 * Created by SXH on 2019/12/23 22:54.
 */

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author SXH
 * @description 二叉树的前序、中序、后序遍历  （递归方式）
 * @date 2019/12/23 22:54.
 */
public class BinaryTreeTraversal {
	/**
	 * @Description // 构建二叉树
	 * @param inputList
	 **/
	public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
		TreeNode node = null;
		if (inputList == null || inputList.isEmpty()) {
			return null;
		}
		// 这里判空很关键：如果元素是空，则不再进一步递归
		Integer data = inputList.removeFirst();
		if (data != null) {
			node = new TreeNode(data);
			node.leftChild = createBinaryTree(inputList);
			node.rightChild = createBinaryTree(inputList);
		}
		return node;
	}

	/**
	 * @Description // 二叉树前序遍历
	 * @param node 二叉树节点
	 **/
	public static void preOrderTraveral(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data);
		preOrderTraveral(node.leftChild);
		preOrderTraveral(node.rightChild);
	}

	/**
	 * @Description // 二叉树中序遍历
	 * @param node 二叉树节点
	 **/
	public static void inOrderTraveral(TreeNode node) {
		if (node == null) {
			return;
		}
		preOrderTraveral(node.leftChild);
		System.out.println(node.data);
		preOrderTraveral(node.rightChild);
	}

	/**
	 * @Description // 二叉树后序遍历
	 * @param node 二叉树节点
	 **/
	public static void postOrderTraveral(TreeNode node) {
		if (node == null) {
			return;
		}
		preOrderTraveral(node.leftChild);
		preOrderTraveral(node.rightChild);
		System.out.println(node.data);
	}

	/*
	 * 二叉树节点
	 **/
//	private static class TreeNode {
//		int data;
//		TreeNode leftChild;
//		TreeNode rightChild;
//
//		TreeNode(int data) {
//			this.data = data;
//		}
//	}

	public static void main(String[] args) {
		LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[] {3,2,9,null,null,10,null,null,8,null,4}));
		TreeNode treenode = createBinaryTree(inputList);
		System.out.println("前序遍历");
		preOrderTraveral(treenode);
		System.out.println("中序遍历");
		inOrderTraveral(treenode);
		System.out.println("后序遍历");
		postOrderTraveral(treenode);
	}
}
