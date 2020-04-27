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
		circleSingleLinkedList.addBoy(20);
		circleSingleLinkedList.showBoy();
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