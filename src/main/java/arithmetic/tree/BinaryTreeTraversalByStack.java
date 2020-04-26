package arithmetic.tree;/**
 * Created by SXH on 2019/12/23 23:37.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author SXH
 * @description 使用栈实现二叉树的遍历
 * @date 2019/12/23 23:37.
 */
public class BinaryTreeTraversalByStack {

	public static void preOrderTraveralWithStack(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode treeNode = root;
		while (treeNode != null || !stack.isEmpty()) {
			// 迭代访问节点的左孩子，并入栈
			while (treeNode != null) {
				System.out.println(treeNode.data);
				stack.push(treeNode);
				treeNode = treeNode.leftChild;
			}
			// 如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
			if (!stack.isEmpty()) {
				treeNode = stack.pop();
				treeNode = treeNode.rightChild;
			}
		}
	}

	public static void main(String[] args) {
		LinkedList<Integer> inputList = new LinkedList<>(Arrays
				.asList(new Integer[] {3,2,9,null,null,10,null,null,8,null,4}));
		TreeNode treenode = BinaryTreeTraversal.createBinaryTree(inputList);
		System.out.println("前序遍历");
		preOrderTraveralWithStack(treenode);
	}
}
