/*
 * Copyright (c) 2021.  User:SXH  File:QuickSort.java
 * Date:2021/05/07 23:29:07
 */

package com.autonomic.algorithm.sort.quicksort;/**
 * Created by SXH on 2020/5/21 22:23.
 */

import java.util.Arrays;

/**
 * @author SXH
 * @description 快速排序
 * 	快速排序是冒泡排序的一种改进，基本思想：
 * 		通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 		然后再按此方法对这两部分数据进行快速排序，整个排序过程可以递归进行，以此达到整个数据的有序。
 * @date 2020/5/21 22:23.
 */
public class QuickSort {
	public static void main(String[] args) {
//		int [] arr1 = {-9, 78, 0, 23, -567, 70};
		int [] arr1 = {0, 78, 0, 23, -567, 0};
		System.out.println(Arrays.toString(arr1));
		sort1(arr1, 0, arr1.length - 1);
		System.out.println(Arrays.toString(arr1));


		// 创建80000个随机数的数组
//		int MAX_SIZE = 800000;
//		int [] arr = new int[MAX_SIZE];
//		for (int i = 0; i < MAX_SIZE; i++) {
//			arr[i] = (int)(Math.random() * 8000000);
//		}
//		long start = System.currentTimeMillis();
//		System.out.println(start);
//		sort(arr, 0, arr.length - 1);
//		long end = System.currentTimeMillis();
//		System.out.println(end);
//		System.out.println((end - start)); // 八十万数据大概耗时 147s
	}

	public static void sort (int[] arr, int left, int right) {
		int l = left; // 记录左下标
		int r = right; // 记录右下标
		int temp = 0; // 临时变量，交换时使用
		int pivot = arr[(left + right) / 2]; // 从数组中间找一个参照
		// while 循环的目的是让比pivot 值小放到左边，比pivot 值大放到右边
		while (l < r) { // 只要左下标大于右下标 就一直循环
			// 从左边开始，寻找比中间值大的数，没有 l 就加一 向后移动
			while (arr[l] < pivot) {
				l += 1;
			}
			// 从右边开始，寻找比中间值小的数，没有 r 就减一 向前移动
			while (arr[r] > pivot) {
				r -= 1;
			}
			// 遍历完 要么找到可以交换的下标了，要么就结束了
			if (l >= r) {
				break;
			}
			// 交换两个值
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			// 如果交换完成后，发现arr[l] == pivot 值，r--  右边前移   这块还是有点疑问
			// 疑问解释：如遇 7 8 4 6 4  交换完毕 4 8 4 6 7   这种情况，7肯定大于4 了，不用再比较中间值和right 值，right--
			if (arr[l] == pivot) {
				r -= 1;
			}
			// 如果交换完成后，发现 arr[r] == pivot 值， l++ 左边后移
			// 疑问解释：如遇 4 8 4 6 4  交换完毕 4 8 4 6 4   这种情况，7肯定大于4 了，不用再比较中间值和right 值，right--
			if (arr[r] == pivot) {
				l += 1;
			}
		}

		// 如果 l == r ,必须 l++, r--,否则出现栈溢出（退不出来）
		if (l == r) {
			l += 1;
			r -= 1;
		}
		// 向左递归
		if (left < r) {
			sort(arr, left, r);
		}
		// 向右递归
		if (right > l) {
			sort(arr, l, right);
		}
	}



	public static void sort1(int[] arr, int left, int right) {
		int l = left; // 记录左下标
		int r = right; // 记录右下标
		int temp = 0; // 临时变量，交换时使用
		int pivot = arr[(left + right) / 2]; // 从数组中间找一个参照
		// while 循环的目的是让比pivot 值小放到左边，比pivot 值大放到右边
		while (l < r) { // 只要左下标大于右下标 就一直循环
			// 从左边开始，寻找比中间值大的数，没有 l 就加一 向后移动
			while (arr[l] < pivot) {
				l += 1;
			}
			// 从右边开始，寻找比中间值小的数，没有 r 就减一 向前移动
			while (arr[r] > pivot) {
				r -= 1;
			}
			// 遍历完 要么找到可以交换的下标了，要么就结束了
			if (l >= r) {
				break;
			}
			// 交换两个值
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			// 如果交换完成后，发现arr[l] == pivot 值，r--  右边前移   这块还是有点疑问
			// 疑问解释：如遇 7 8 4 6 4  交换完毕 4 8 4 6 7   这种情况，7肯定大于4 了，不用再比较中间值和right 值，right--
			if (arr[l] == pivot) {
				r -= 1;
			}
			// 如果交换完成后，发现 arr[r] == pivot 值， l++ 左边后移
			// 疑问解释：如遇 4 8 4 6 4  交换完毕 4 8 4 6 4   这种情况，7肯定大于4 了，不用再比较中间值和right 值，right--
			if (arr[r] == pivot) {
				l += 1;
			}
		}
	}
}
