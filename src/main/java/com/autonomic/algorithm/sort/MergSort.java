package com.autonomic.algorithm.sort;/**
 * Created by SXH on 2020/5/25 22:36.
 */

import java.util.Arrays;

/**
 * @author SXH
 * @description 归并排序   O(n) 的时间复杂度
 * 归并排序（MergeSort）是利用归并的思想实现排序方法，该算法采用经典的分治（divide-and-conquer)策略
 * （分治法将问题分（divide）成一些小的问题然后递归求解，而治（conquer）的阶段则将分的阶段得到的答案“修补”在一起，即分而治之）。
 * @date 2020/5/25 22:36.
 */
public class MergSort {
	public static void main(String[] args) {
//		int [] arr = {8, 4, 5, 7, 1, 3, 6, 2};
//		int [] temp = new int[arr.length]; // 归并排序需要一个额外的空间（空间换时间）
//		mergeSort(arr, 0, arr.length - 1, temp);
//		System.out.println("归并排序后：" + Arrays.toString(arr));

		// 创建80000个随机数的数组
//		int MAX_SIZE = 800000;
//		int [] arr = new int[MAX_SIZE];
//		int [] temp = new int[MAX_SIZE];
//		for (int i = 0; i < MAX_SIZE; i++) {
//			arr[i] = (int)(Math.random() * 8000000);
//		}
//		long start = System.currentTimeMillis();
//		System.out.println(start);
//		mergeSort(arr, 0, MAX_SIZE - 1, temp);
//		long end = System.currentTimeMillis();
//		System.out.println(end);
//		System.out.println((end - start)); // 八万数据大概耗时 19ms


		// 测试练习
//		int [] arr = {1, 3, 5, 7, 2, 4, 6, 8};
		int [] arr = {8, 4, 5, 7, 1, 3, 6, 2};
		int [] temp = new int[arr.length]; // 归并排序需要一个额外的空间（空间换时间）
//		int mid = (0 + arr.length-1) / 2;
//		mergeTest1(arr, 0, mid, arr.length-1, temp);
		sortTest1(arr, 0, arr.length - 1, temp);
		System.out.println("归并排序后：" + Arrays.toString(arr));
	}

	/**************************** 2020/11/18 练习 *********************************/
	// 归并排序分为拆分数组 和 合并有序数组两个过程
	// 拆分数组
	// 归并排序是空间换时间的一种思想，所以需要用一个temp 数组来暂存两个有序数组合并后的数组
	public static void sortTest1(int [] arr, int l, int r, int [] temp) {
		if (l < r) {
			int mid = (l + r) / 2;
			// 向左拆分
			sortTest1(arr, l, mid, temp);
			// 向右拆分
			sortTest1(arr, mid+1, r, temp);
			// 拆分为一个个单个数组后，将单个数组（此时有序）再一个个的合并
			mergeTest1(arr, l, mid, r, temp);
		}
	}

	// 合并代码
	public static void mergeTest1(int [] arr, int l, int mid, int r, int [] temp) {
		// 1.将左右两个有序数组合并到temp 中，保证合并后的temp 数组还是有序的
		int tempIndex = 0; // 记录temp 数组的下标位置
		int left = l; // 用来记录处理左边数组的元素的情况
		int m = mid + 1; // 用来记录处理右边数组的元素的情况
		while (left <= mid && m <= r) { // 当都满足时
			// 判断两个数组 两边待处理的第一个元素的大小
			if (arr[left] > arr[m]) {
				temp[tempIndex++] = arr[m++];
			} else {
				temp[tempIndex++] = arr[left++];
			}
		}

		// 2.由于将其中一个数组完全的放入temp 数组后，另外一个数组可能还有好几个数没有放入temp 数组，
		// 所以后序要加此判断，将另外一个没有处理完毕的数组的元素也添加到temp 数组中
		while (left <= mid) {
			// 说明左边的数组没有全部放入到temp 数组中呢
			temp[tempIndex++] = arr[left++];
		}
		while (m <= r) {
			// 说明右边的数组没有全部放入到temp 数组中呢
			temp[tempIndex++] = arr[m++];
		}

		// 3.都放入到了temp 数组中后，就需要将temp 数组中的元素依次放回到arr 数组中去
		int index = 0; // 用于处理temp 数组中的元素
		for (int i = l; i <= r; i++) {
			arr[i] = temp[index++];
		}
	}

	/*********************************************************************************/


	// 分解 并 合并
	public static void mergeSort(int [] arr, int left, int right, int [] temp) {
		if (left < right) {
			int mid = (left + right) / 2; // 中间索引
			// 向左递归进行分解
			mergeSort(arr, left, mid, temp);
			// 向右递归进行分解
			mergeSort(arr, mid + 1, right, temp);
			// 分解后进行合并排序
			merge(arr, left, mid, right, temp);
		}
	}

	/**
	 * @Author SXH
	 * @param arr 排序的原始数组
	 * @param left 左边有序序列的初始索引
	 * @param mid 中间索引
	 * @param right 右边索引 （用来计算右边序列的初始索引，其实可以使用左右两个索引计算出来）
	 * @param temp 做中转的数组
	 * @Date 2020/5/25  22:39
	 **/
	public static void merge(int [] arr, int left, int mid, int right, int [] temp) {
		int i = left; // 初始化i，左边有序序列的初始索引
		int j = mid + 1; // 初始化j，右边有序序列的初始索引
		int t = 0; // 指向temp 数组的当前索引
		// 分三步
		// 1.需要左右序列遍历，按大小放入temp 中，直到左边或者右边有一边没有数据
		while (i <= mid && j <= right) { // 说明两边的有序序列还没有遍历完
			if (arr[i] < arr[j]) {
				temp[t] = arr[i]; // 将小的放入到临时数组，i+1
				t += 1;
				i += 1;
			} else {
				temp[t] = arr[j];
				t += 1;
				j += 1;
			}
		}
		// 2.此时一定有左右其中的一边没有遍历完毕，直接将其追加到temp 后即可（因为左右两边的序列都是有序序列）
		while (i <= mid) { // 说明左边有序序列没有遍历完毕
			temp[t] = arr[i];
			t += 1;
			i += 1;
		}

		while (j <= right) { // 说明右边有序序列没有遍历完毕
			temp[t] = arr[j];
			t += 1;
			j += 1;
		}
		// 3.最后将临时数组中的值放入到arr 对应位置（因为涉及递归，所以有left=0,right=1 这样的场景
		// 直到left = 0，right = arr.length-1  所以并不是每次都拷贝数组中所有数据
		t = 0;
		int tempLeft = left;
		while (tempLeft <= right) {
			arr[tempLeft] = temp[t];
			tempLeft += 1;
			t += 1;
		}
	}
}
