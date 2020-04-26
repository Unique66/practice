package com.autonomic.datastructures.queue;/**
 * Created by SXH on 2020/4/15 22:07.
 */

import sun.plugin.WJcovUtil;

import java.util.Scanner;

/**
 * @author SXH
 * @description 数组实现的队列
 * @date 2020/4/15 22:07.
 */
public class ArrayQueueDemo {
	public static void main(String[] args) {
		// 定义队列
		ArrayQueue arrayQueue = new ArrayQueue(3);
		char key = ' ';
		Scanner in = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("s(show)：显示队列");
			System.out.println("e(exit)：退出程序");
			System.out.println("a(add)：添加数据到队列");
			System.out.println("g(get)：从队列中取出数据");
			System.out.println("h(head)：查看队列头部数据");
			key = in.next().charAt(0);
			switch (key) {
				case 's':
					arrayQueue.showQueue();
					break;
				case 'e':
					loop = false;
					break;
				case 'a':
					int value = in.nextInt();
					arrayQueue.addData2Queue(value);
					break;
				case 'g':
					arrayQueue.popDataFromQueue();
					break;
				case 'h':
					try {
						int headValue = arrayQueue.queueHead();
						System.out.println("队列头部数据值为：" + headValue);
					} catch (RuntimeException e) {
						System.out.println(e.getMessage());
					}
					arrayQueue.queueHead();
					break;
				default:
					break;
			}
		}
		System.out.println("程序结束~~~~~~~~~");
	}
}
// 使用数组模拟队列
class ArrayQueue {
	private int maxSize;// 数组最大容量
	// 队列头 指向队列头部，front 是指向队列头的前一个位置
	// front 初始值 = -1
	private int front;
	// 队列尾部  指向队列尾部，指向队列尾的数据（即就是队列最后一个数据）
	// rear 初始值 = -1
	private int rear;
	private int [] arr; // 组成队列的数组

	public ArrayQueue (int maxSize) {
		this.maxSize = maxSize; // 构造函数定义数组长度
		this.arr = new int [this.maxSize];
		front = -1; // 指向队列头部，front 是指向队列头的前一个位置
		rear = -1; // 指向队列尾部，指向队列尾的数据（即就是队列最后一个数据）

	}

	// 判断队列是否满了
	public boolean isFull() {
		return rear == maxSize - 1;
	}
	// 判断队列是否为空
	public boolean isEmpty() {
		return rear == front;
	}
	// 入队，向队列添加数据
	public void addData2Queue(int data) {
		if (isFull()) {
			System.out.println("队列已满，不能入队~~~addData2Queue(int data)");
			return;
		} else {
			rear++; // rear 后移一位
			arr[rear] = data; // 将数据加到队尾
		}
	}

	// 出队，从队列中拿出数据
	public void popDataFromQueue() {
		if (isEmpty()) {
			System.out.println("队列为空，不可以出队~~~popDataFromQueue() ");
			return;
		} else {
			front++;
			System.out.println("出队数据为：" + arr[front]);
		}
	}
	// 展示队列
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("队列为空，不能showQueue()");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
//			System.out.print("arr[%d]=%d\n", i, arr[i]);
			System.out.println("i：" + i + "###" +arr[i]);
		}
	}

	// 展示队列头部，不是取出头部数据
	public int queueHead() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空，没有头数据");
		}
		return arr[front + 1];
	}
}
