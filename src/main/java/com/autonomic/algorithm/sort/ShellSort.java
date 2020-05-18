package com.autonomic.algorithm.sort;/**
 * Created by SXH on 2020/5/14 22:58.
 */

import java.util.Arrays;

/**
 * @author SXH
 * @description 希尔排序  也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序
 *  希尔排序是吧记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，
 *  当增量减至1时，整个文件恰被分成一组，算法便终止
 * @date 2020/5/18 22:58.
 */
public class ShellSort {
	public static void main(String[] args) {
//		int [] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//		sort2(arr);

		// 创建80000个随机数的数组
		int MAX_SIZE = 800000;
		int [] arr = new int[MAX_SIZE];
		for (int i = 0; i < MAX_SIZE; i++) {
			arr[i] = (int)(Math.random() * 8000000);
		}
		long start = System.currentTimeMillis();
		System.out.println(start);
		sort2(arr);
		long end = System.currentTimeMillis();
		System.out.println(end);
		System.out.println((end - start)); // 八十万数据大概耗时 165ms
	}


	// 对有序队列插入时采用交换法  实质上就是冒泡排序的交换方法
	public static void sort1(int [] arr) {

		int len = arr.length;
		int temp = 0;
		while ((len/=2) > 0) {
			for (int i = len; i < arr.length; i++) {
				for (int j = i - len; j >=0; j-=len) {
					if (arr[j] > arr[j + len]) {
						temp = arr[j];
						arr[j] = arr[j + len];
						arr[j + len] = temp;
					}
				}
			}
			System.out.println(Arrays.toString(arr));
		}


//		// 使用逐步推导的方式来编写希尔排序
//		// 希尔排序第一轮，10个数据分 10/2 = 5 组
//		int temp = 0;
//		for (int i = 5; i < arr.length; i++) {
//			for (int j = i - 5; j >=0; j-=5) {
//				if (arr[j] > arr[j + 5]) {
//					temp = arr[j];
//					arr[j] = arr[j + 5];
//					arr[j + 5] = temp;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(arr));
//
//		// 希尔排序第二轮， 5 / 2 = 2 组
//		for (int i = 2; i < arr.length; i++) {
//			for (int j = i - 2; j >=0; j-=2) {
//				if (arr[j] > arr[j + 2]) {
//					temp = arr[j];
//					arr[j] = arr[j + 2];
//					arr[j + 2] = temp;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(arr));
//
//		// 希尔排序第三轮   2/2 = 1 组
//		for (int i = 1; i < arr.length; i++) {
//			for (int j = i - 1; j >=0; j-=1) {
//				if (arr[j] > arr[j + 1]) {
//					temp = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = temp;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(arr));
	}


	// 对有序队列插入时采用移动法，也就是引入插入排序
	public static void sort2(int [] arr) {
		// 增量gap，并逐步的缩小增量
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// 从第gap 个元素，逐个对其所在的组进行直接插入排序
			for (int i = gap; i < arr.length; i++) {
				int j = i; // 待插入下标
				int temp = arr[j]; // 待插入值
				if (arr[j] < arr[j - gap]) { // 可以不用加这个if
					while (j - gap >= 0 && temp < arr[j - gap]) {
						// 移动
						arr[j] = arr[j - gap];
						j -= gap;
					}
					// 当退出while 循环后，就给temp 找到插入的位置
					arr[j] = temp;
				}
			}
//			System.out.println(Arrays.toString(arr));
		}
	}
}
