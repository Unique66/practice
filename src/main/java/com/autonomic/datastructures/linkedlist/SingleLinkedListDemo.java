package com.autonomic.datastructures.linkedlist;/**
 * Created by SXH on 2020/4/22 21:46.
 */

import java.util.Stack;

/**
 * @author SXH
 * @description 单向链表
 * @date 2020/4/22 21:46.
 */
public class SingleLinkedListDemo {
	public static void main(String[] args) {
		// 创建测试节点
		HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
		HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
		// 创建存储节点的单向链表
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		// 向单向链表中添加节点
//		singleLinkedList.add(heroNode1);
//		singleLinkedList.add(heroNode4);
//		singleLinkedList.add(heroNode3);
//		singleLinkedList.add(heroNode2);
		System.out.println("~~~~~~~~~~按序添加测试");
		singleLinkedList.sortedAdd(heroNode1);
		singleLinkedList.sortedAdd(heroNode4);
		singleLinkedList.sortedAdd(heroNode3);
		singleLinkedList.sortedAdd(heroNode2);
		singleLinkedList.list();

//		System.out.println("~~~~~~~~~~更新测试");
//		HeroNode newHeroNode = new HeroNode(4, "林冲1", "豹子头1");
//		singleLinkedList.update(newHeroNode);
//		// 遍历节点
//		singleLinkedList.list();
//		System.out.println("~~~~~~~~~~删除测试");
//		singleLinkedList.delete(1);
//		singleLinkedList.delete(4);
//		singleLinkedList.delete(2);
//		singleLinkedList.delete(3);
		// 遍历节点
//		singleLinkedList.list();

		System.out.println("~~~~~~~getLength 测试");
		System.out.println(getLength(singleLinkedList.getHead()));

		System.out.println("~~~~~~~getLastIndexNode 测试");
		System.out.println(getLastIndexNode(singleLinkedList.getHead(), 0));

		System.out.println("~~~~~~reverseLinkedList 测试");
		reverseLinkedList(singleLinkedList.getHead());
		singleLinkedList.list();

		System.out.println("~~~~~~~reversePrint 测试");
		reversePrint(singleLinkedList.getHead());
	}

	// TODO 合并两个有序的单链表，合并之后的链表依然有序  待做

	// 从尾部到头部打印单链表 【百度面试题】
	/* 思路：
		1.其实就是要求逆序打印单链表
		2.方式1：先将单链表反转，然后遍历即可。这样做会破坏单链表的结构，不建议使用
		3.方式2：可以利用栈，将各个节点压入栈中，然后利用栈先进后出的特点，实现逆序打印的效果
	 **/
	public static void reversePrint (HeroNode head) {
		if (head.next == null) {
			System.out.println("空链表");
			return;
		}
		// 先创建一个栈用于存储链表节点
		Stack<HeroNode> stack = new Stack<>();
		// 使用临时变量来遍历
		HeroNode cur = head.next;
		while (cur != null) {
			stack.add(cur);
			cur = cur.next; // cur 后移，这样就可以压入下一个节点
		}
		System.out.println("开始逆序打印节点信息");
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}

	// 单链表翻转【腾讯面试题】
	/* 思路：有点难度
		1.先定义一个节点 reverseHead = new HeroNode();
		2.从头到尾遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表 reverseHead 的最前端。
		3.原来的链表的 head.next = reverseHead.next 即可

		while 循环中的演算
		1 2 3 4 5

		cur   ->  reverse.next = null
		reverse -> cur
		reverse -> 1 -> null

		2 -> 1
		reverse -> 2
	 **/
	public static void reverseLinkedList(HeroNode head) {
		// 首先要判断链表是否为空或只有一个有效节点
		if (head.next == null || head.next.next == null) {
			System.out.println("空链或只有一个节点，不用做翻转");
			return;
		}
		// 开始处理翻转
		// 要定义一个辅助变量，帮助我们遍历原来的链表
		HeroNode cur = head.next;
		HeroNode next = null; // 指向当前节点[cur] 的下一个节点，用于后序处理
		HeroNode reverseHead = new HeroNode(0, "", "");
		// 遍历需要翻转的链表，每遍历一个节点，就将它取出来，并放到新的链表reverseHead 的最前端
		while (cur != null) {
			next = cur.next; // 记录当前节点的下一个节点，用于后序遍历
			//（☆☆ cur.next = xxx 是指向型操作 将cur 指向 xxx）
			cur.next = reverseHead.next; // 将当前节点取出，放到新链表的前面
			reverseHead.next = cur; // 将cur 连接到新的链表上
			cur = next; // 让cur 后移
		}
		// 将head.next 指向reverseHead.next，实现单链表反转
		head.next = reverseHead.next;
	}

	// 思路：自己的：先求出链表总长度，减去k 获得正数的顺序，就是要找的
	/**
	 * @Description // 查找单链表中的倒数第k 个节点【新浪面试题】
	 * @Date 2020/4/23  21:53
	 * @param head 链表的头结点
	 * @param index 倒数第index
	 * @return 返回的就是有效节点的个数
	 **/
	public static HeroNode getLastIndexNode (HeroNode head, int index) {
		// 首先判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return null;
		}
		// 获取链表总节点个数
		int size = getLength(head);
		// 判断 index 的合法性
		if (index < 0 || index > size) {
			System.out.println("index 不合法");
			return null;
		}
		// 走到这里就可以遍历找对应的倒数第index节点了
		// 定义辅助变量
		HeroNode temp = head.next;
		for (int i = 0; i < size - index; i++) {
			temp = temp.next;
		}
		return temp;
	}
	/**
	 * @Author SXH
	 * @Description // 获取到单链表的节点个数（如果是带头结点的链表，需要不统计头结点）
	 * @Date 2020/4/23  21:37
	 * @param head 链表的头结点
	 * @return 返回的就是有效节点的个数
	 **/
	public static int getLength(HeroNode head) {
		if (head.next == null) {
			System.out.println("空链表");
			return 0;
		}
		// 使用临时节点
		HeroNode cur = head;
		// 设置一个变量统计节点个数
		int len = 0;
		while (cur.next != null) {
			len++;
			cur = cur.next;
		}
		return len;
	}
}
// 定义SingleLinkedList 管理我们的英雄节点
class SingleLinkedList {
	// 需要先初始化一个头结点，头结点不动，不存放具体的数据
	private HeroNode head = new HeroNode(0, "", "");

	// public方法获取私有的头结点
	public HeroNode getHead() {
		return head;
	}

	// 添加节点到单向链表中
	public void add (HeroNode heroNode) {
		// 创建一个临时节点存放头结点来处理数据
		HeroNode temp = head;
		// 需要先找到最后那个节点，然后把新增的节点放到后面
		while (true) {
			if (temp.next == null) {
				temp.next = heroNode;
				break;
			}
			temp = temp.next;
		}
	}

	// 第二种添加节点的方法，根据英雄排名插入到指定的位置
	// 如果排名重复，则添加失败，并给出提示
	// 核心思想是：先找到添加节点的前一个节点，然后再做添加操作
	public void sortedAdd (HeroNode heroNode) {
		HeroNode temp = head;
		int addNo = heroNode.no;
		boolean flag = false;// flag 标志添加的编号是否存在，默认是false
		while (true) {
			if (temp.next == null) {// 说明 temp 已经在链表最后了
				break;
			}
			// 找到节点：该节点编号大于添加节点的编号
			if(temp.next.no > addNo) {
				break;
			} else if (temp.next.no == addNo) {
				flag = true;
			}
			temp = temp.next;
		}
		if (flag) {
			System.out.println("编号已经存在，不能添加:" + heroNode.no);
		} else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}

	// 修改节点信息，根据no 来修改，即no 编号不可以改
	public void update(HeroNode newHeroNode) {
		// 判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 定义辅助节点
		HeroNode temp = head;
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

	// 删除对应节点
	// 思路：找到要删除的那个节点的上一个节点
	public void delete (int deleteNo) {
		// 先判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空，无法做删除节点操作");
			return;
		}
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			}
			// 找到待删除节点的前一个节点
			if (temp.next.no == deleteNo) {
				flag = true;
				break;
			}
			temp = temp.next;// temp 后移，继续遍历
		}
		// 根据flag 来处理数据
		if (flag) {
			temp.next = temp.next.next;
		} else {
			System.out.println("遍历完毕，没有找到要删除的节点");
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
		HeroNode temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}
}

// 定义节点
class HeroNode {
	public int no;
	public String name;
	public String nickName;
	public HeroNode next;
	// 构造函数初始化节点信息
	public HeroNode (int hNo, String hName, String hNickName) {
		this.no = hNo;
		this.name = hName;
		this.nickName = hNickName;
	}

	@Override
	public String toString() {
		return "HeroNode{" +
				"no=" + no +
				", name='" + name + '\'' +
				", nickName='" + nickName + '\'' +
//				", next=" + next +
				'}';
	}
}
