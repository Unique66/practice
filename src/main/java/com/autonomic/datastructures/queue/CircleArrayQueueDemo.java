package com.autonomic.datastructures.queue;/**
 * Created by SXH on 2020/4/15 23:37.
 */

import java.util.Scanner;

/**
 * @author SXH
 * @description 环形数组实现的队列
 * @date 2020/4/15 23:37.
 */
public class CircleArrayQueueDemo {
	public static void main(String[] args) {
		// 定义队列
		System.out.println("测试数组模拟的环形队列：");
		CircleArrayQueue arrayQueue = new CircleArrayQueue(4); // 设置为4，但队列最大数量为3
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

class CircleArrayQueue{
	private int maxSize;// 数组最大容量
	// 队列头，含义：front 就是指向队列第一个元素 也就是arr[front]
	// front 的初始值 = 0
	private int front;
	// 队列尾部 含义：rear 指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定
	// rear 的初始值 = 0
	private int rear;
	private int [] arr; // 组成队列的数组

	public CircleArrayQueue (int maxSize) {
		this.maxSize = maxSize; // 构造函数定义数组长度
		this.arr = new int [this.maxSize];
//		front = 0;
//		rear = 0;
	}

	// 判断队列是否满了
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
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
			arr[rear] = data; // 将数据加到队尾
			rear = (rear + 1) % maxSize; // rear 后移一位  环形队列 要考虑取模
		}
	}

	// 出队，从队列中拿出数据
	public void popDataFromQueue() {
		if (isEmpty()) {
			System.out.println("队列为空，不可以出队~~~popDataFromQueue() ");
			return;
		} else {
			// front 是指向队列的第一个元素
			System.out.println("出队数据为：" + arr[front]);
			// 将front 后移，考虑取模
			front = (front + 1) % maxSize;
		}
	}
	// 展示队列
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("队列为空，不能showQueue()");
			return;
		}
		for (int i = front; i < front + size(); i++) {
//			System.out.print("arr[%d]=%d\n", i, arr[i]);
			System.out.println("i：" + i % maxSize + "###" +arr[i % maxSize]);
		}
	}

	// 求当前队列有效数据个数
	public int size() {
		// rear = 2
		// front = 1
		// maxSize = 3
		return (rear + maxSize - front) % maxSize;
	}

	// 展示队列头部，不是取出头部数据
	public int queueHead() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空，没有头数据");
		}
		return arr[front];
	}
}