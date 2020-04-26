package com.autonomic.datastructures.linkedlist;/**
 * Created by SXH on 2020/4/22 21:46.
 */

import java.util.Stack;

/**
 * @author SXH
 * @description 单向链表
 * @date 2020/4/22 21:46.
 */
public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		System.out.println("双向链表测试：");
		// 创建测试节点
		HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
		HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "玉麒麟");
		HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
		HeroNode2 heroNode4 = new HeroNode2(4, "林冲", "豹子头");
		// 创建一个双向链表
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.add(heroNode1);
		doubleLinkedList.add(heroNode2);
		doubleLinkedList.add(heroNode3);
		doubleLinkedList.add(heroNode4);
		doubleLinkedList.list();
	}
}



// 定义DoubleLinkedList 管理我们的英雄节点
class DoubleLinkedList {
	// 需要先初始化一个头结点，头结点不动，不存放具体的数据
	private HeroNode2 head = new HeroNode2(0, "", "");

	// public方法获取私有的头结点
	public HeroNode2 getHead() {
		return head;
	}

	// 按照编号顺序添加   TODO

	// 添加节点到双向链表中
	public void add (HeroNode2 heroNode) {
		// 创建一个临时节点存放头结点来处理数据
		HeroNode2 temp = head;
		// 需要先找到最后那个节点，然后把新增的节点放到后面
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		// 当退出while 循环时，temp 就指向了链表最后
		// 构成一个双向链表
		temp.next = heroNode;
		heroNode.pre = temp;
	}

	// 修改节点信息，根据no 来修改，即no 编号不可以改
	public void update(HeroNode2 newHeroNode) {
		// 判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 定义辅助节点
		HeroNode2 temp = head;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break; // 已经遍历完链表了
			}
			if (temp.no == newHeroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		// 根据flag 的值来确定是否修改
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickName = newHeroNode.nickName;
		} else {
			System.out.println("链表中没有对应编号的节点:" + newHeroNode.no);
		}
	}

	// 删除双向链表的节点
	// 思路：对于双向俩表，可以直接删除节点（因为可以定位到前后节点）
	// 删除双向链表：定位到no，然后
	public void delete (int deleteNo) {
		// 先判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空，无法做删除节点操作");
			return;
		}
		HeroNode2 temp = head; // 辅助指针
		boolean flag = false;
		while (true) {
			// 已经到达链表最后
			if (temp == null) {
				break;
			}
			if (temp.no == deleteNo) {
				// 找到待删除节点
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.pre.next = temp.next;
			// 如果要删除最后一个节点，那么就不用进行下面的操作，防止NPE
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
		} else {
			System.out.println("没有这样的节点：" + deleteNo);
		}
	}

	// 遍历单向链表
	public void list() {
		// 判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 因为头结点，不能动，我们需要一个辅助变量来遍历
		HeroNode2 temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}
}

// 定义节点 双向链表节点
class HeroNode2 {
	public int no;
	public String name;
	public String nickName;
	public HeroNode2 next; // 指向下一个节点，默认为null
	public HeroNode2 pre; // 指向前一个节点，默认为null
	// 构造函数初始化节点信息
	public HeroNode2 (int hNo, String hName, String hNickName) {
		this.no = hNo;
		this.name = hName;
		this.nickName = hNickName;
	}

	@Override
	public String toString() {
		return "HeroNode2{" +
				"no=" + no +
				", name='" + name + '\'' +
				", nickName='" + nickName + '\'' +
//				", next=" + next +
				'}';
	}
}
