package com.autonomic.algorithm.sort;/**
 * Created by SXH on 2020/5/12 22:15.
 */

import java.util.Arrays;

/**
 * @author SXH
 * @description 选择排序
 * @date 2020/5/12 22:15.
 */
public class SelectSort {
	public static void main(String[] args) {
//		int [] arr1 = {103, 80 ,60, 70, 50, -1, 90, 66, 3, -10,90};
//		System.out.println(Arrays.toString(arr1));
//		sort(arr1);
//		System.out.println(Arrays.toString(arr1));

		// 创建80000个随机数的数组
		int [] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int)(Math.random() * 8000000);
		}
		long start = System.currentTimeMillis();
		System.out.println(start);
		sort(arr);
		long end = System.currentTimeMillis();
		System.out.println(end);
		System.out.println((end - start));
	}

	// 首先假定第一个数是最小数，向后遍历，一直找比第一个数小的数，遍历完就找到了，记录下标，如果下标不是0，就替换
	// 第二次循环也是，不过从第二个数开始，依次类推，一直循环n-1 次
	public static void sort(int[] arr) {
		// 时间复杂度是O(n²)
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i; // 最小值index 假定
			int min = arr[i]; // 最小值 假定
			for (int j = i + 1; j < arr.length; j++) { // 假定第i 个，那么就从第 i+1 个数开始遍历比较，直接比较到最后
				if (min > arr[j]) { // 此循环找到比假定更小的值，更新最小值及其下标
					index = j;
					min = arr[j];
				}
			}
			if (i != index) { // 遍历一遍后，如果最小值下标不是假定的那个下标，就做交换操作，此时下标i 对应的数就是当前顺序最小值了
				arr[index] = arr[i];
				arr[i] = min;
			}
		}
	}
}
