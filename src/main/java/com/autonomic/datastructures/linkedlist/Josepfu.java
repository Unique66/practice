package com.autonomic.datastructures.linkedlist;/**
 * Created by SXH on 2020/4/27 22:08.
 */

/**
 * @author SXH
 * @description 约瑟夫问题
 * @date 2020/4/27 22:08.
 */
public class Josepfu {
	public static void main(String[] args) {
		// 测试构建环形链表和遍历方法是否可以
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(5);
		circleSingleLinkedList.showBoy();

		// 测试小孩出圈是否正确
		circleSingleLinkedList.countBoy(1,2, 5); // 2->4->1->5->3
	}

}

// 创建一个环形的单向链表
class CircleSingleLinkedList {
	// 创建一个first 节点，当前没有编号
	private Boy first = null;
	// 添加孩子节点，构建成一个环形链表
	public void addBoy(int nums) {
		// 对nums 做校验
		if (nums < 1) {
			System.out.println("nums 值不合规");
			return;
		}
		Boy curBoy = null; // 辅助指针，帮助构建环形链表
		// 使用循环创建环形链表
		for (int i = 1; i <= nums; i++) {
			// 先创建孩子节点
			Boy boy = new Boy(i);
			if (i == 1) { // 第一个节点需要自己指向自己
				first = boy;
				first.setNext(first); // 构成环
				curBoy = first; // 让curBoy 辅助指针指向第一个小孩
			} else { // 处理后面的节点
				curBoy.setNext(boy); // 当前节点指向新增加的节点
				boy.setNext(first); // 新增节点指向first 节点，形成环
				curBoy = boy; // 将当前节点切换成最后添加的节点
			}
		}
	}

	// 遍历环形链表
	public void showBoy() {
		if (first == null) {
			System.out.println("空链表");
			return;
		}
		Boy curBoy = first; // 定义辅助节点
		while (true) {
			System.out.printf("节点：%d \n", curBoy.getNo());
			if (curBoy.getNext() == first) {
				break; // 遍历完毕，退出while
			}
			curBoy = curBoy.getNext(); // curBoy 后移
		}
	}

	/**
	 * @Author SXH
	 * @Description // 约瑟夫问题处理
	 * @Date 2020/4/27  23:26
	 * @param startNo  起始位置
	 * @param countNum 喊countNum 下出圈
	 * @param nums  循环队列节点个数
	 *	思路：
	 *  根据用户的输入，生成一个小孩出圈的顺序
	 *   n = 5 , 即有5个人
	 *   k = 1, 从第一个人开始报数
	 *   m = 2, 数2下
	 *  1.  需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点.
	 *  注：补充： 小孩报数前，先让 first 和  helper 移动 k - 1次
	 *  2.  当小孩报数时，让first 和 helper 指针同时 的移动  m  - 1 次
	 *  3.  这时就可以将first 指向的小孩节点 出圈
	 *  first = first .next
	 *  helper.next = first
	 *  原来first 指向的节点就没有任何引用，就会被回收
	 *
	 * 	出圈的顺序
	 * 	2->4->1->5->3
	 **/
	public void countBoy(int startNo, int countNum, int nums) {
		// 首先校验数据
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("参数输入有误，请重新输入");
			return;
		}
		// 创建辅助节点，帮助完成小孩出圈
		Boy helper = first;
		// helper 这个辅助节点需要事先指向环形链表的最后一个节点
		while (true) {
			if (helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}
		// 小孩报数前，先让 first 和helper 节点移动 startNo -1 次
		for (int j = 0; j < startNo -1; j++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		// 当小孩报数时，让first 和helper 节点同时移动 countNum - 1 次，然后出圈
		// 循环操作，直到循环链表只有一个节点
		while (true) {
			if (helper == first) { // 说明圈中只有一个节点
				break;
			}
			// 让first 和helper 节点同时移动 countNum - 1 次
			for (int j = 0; j < countNum - 1; j++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			// 此时first 指向的节点就是要出圈的节点
			System.out.printf("小孩%d出圈\n", first.getNo());
			// 将first指向的小孩移出圈外

			first = first.getNext();
			helper.setNext(first);
		}
		System.out.printf("最后留在圈中的小孩编号为：%d \n", first.getNo());
	}
}

// 创建一个Boy类，表示一个节点
class Boy {
	private int no; // 编号
	private Boy next; // 指向下一个节点，默认null

	public Boy(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}
}