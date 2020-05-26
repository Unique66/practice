package com.autonomic.algorithm.sort;/**
 * Created by SXH on 2020/5/26 22:45.
 */

import java.util.Arrays;

/**
 * @author SXH
 * @description 基数排序    O(n * k)   n 指数组长度，k 指最大位数
 * @date 2020/5/26 22:45.
 */
public class RadixSort {
	public static void main(String[] args) {
		int [] arr = {53, 3, 542, 748, 14, 214};
		radixSort(arr);

		// 创建80000个随机数的数组
//		int MAX_SIZE = 8000000;
//		int [] arr = new int[MAX_SIZE];
//		for (int i = 0; i < MAX_SIZE; i++) {
//			arr[i] = (int)(Math.random() * 8000000);
//		}
//		long start = System.currentTimeMillis();
//		System.out.println(start);
//		radixSort(arr);
//		long end = System.currentTimeMillis();
//		System.out.println(end);
//		System.out.println((end - start)); // 八十万数据大概耗时 81ms
	}

	// 基数排序代码实现
	public static void radixSort(int [] arr) {
		// 基本思路
		// 首先需要创建十个桶（十指数值0-9）
		int len = arr.length;
		int[][] bucket = new int[10][len];
		// 设置一个数组来存放10个桶中存放数据的个数,数组下标代表第几个桶，值代表该桶有几个数
		int[] bucketElementCounts = new int[10];

		// 需要了解排序数组的最大位数
		// 假设第一位是最大值，开始遍历找
		int max = arr[0];
		for (int i = 1; i < len; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		// 遍历完成找到最大值，计算最大位数
		int n = (max + "").length();

		// 最大位几位，就需要遍历几次
		for (int k = 0, num = 1; k < n; k++, num *= 10) {
			// 遍历数组内容，依次放到10个桶中   num 指当前位数，1-个位 10-十位 100-百位
			for (int i = 0; i < len; i++) {
				// 得到当前值个位的数值
				int index = arr[i] / num % 10;
				// 将该数放到num位值 对应的桶中 比如个位是8 就放在bucket[8][] 桶中
				bucket[index][bucketElementCounts[index]] = arr[i];
				// 放入桶中后，将该桶的数值标记加1
				bucketElementCounts[index] += 1;
			}
			// 数组下标，以便下面遍历10个桶将数据依次放入到arr 数组中
			int arrIndex = 0;
			// 然后需要将10个桶中的数据依次放入到数组中
			for (int i = 0; i < bucket.length; i++) {
				if (bucketElementCounts[i] > 0) {
					for (int j = 0; j < bucketElementCounts[i]; j++) {
						arr[arrIndex++] = bucket[i][j];
					}
					// 注：做完遍历后，将当前桶的存放数个数置为0，以便下次使用
					bucketElementCounts[i] = 0;
				}
			}
//			System.out.println("第" + (k+1) + "次遍历" + Arrays.toString(arr));
		}
	}

	/**
	 * @Author SXH
	 * @Description //  使用以下例子，一步一步分析基数排序思想，以便完成上面的组合
	 * int [] arr = {53, 3, 542, 748, 14, 214};
	 * @Date 2020/5/26  23:12
	 **/
	public static void radixSortAnalysis(int [] arr) {
		// 基本思路
		// 首先需要创建十个桶（十指数值0-9）
		int len = arr.length;
		int [][] bucket = new int [10][len];
		// 设置一个数组来存放10个桶中存放数据的个数,数组下标代表第几个桶，值代表该桶有几个数
		int [] bucketElementCounts = new int[10];

		// 第一次遍历
		// 遍历数组内容，依次放到10个桶中
		for (int i = 0; i < len; i++) {
			// 得到当前值个位的数值
			int index = arr[i] % 10;
			// 将该数放到个位值 对应的桶中 比如个位是8 就放在bucket[8][] 桶中
			bucket[index][bucketElementCounts[index]] = arr[i];
			// 放入桶中后，将该桶的数值标记加1
			bucketElementCounts[index] += 1;
		}
		// 数组下标，以便下面遍历10个桶将数据依次放入到arr 数组中
		int arrIndex = 0;
		// 然后需要将10个桶中的数据依次放入到数组中
		for (int i = 0; i < bucket.length; i++) {
			if (bucketElementCounts[i] > 0) {
				for (int j = 0; j < bucketElementCounts[i]; j++) {
					arr[arrIndex++] = bucket[i][j];
				}
				// 做完遍历后，将当前桶的存放数个数置为0，以便下次使用
				bucketElementCounts[i] = 0;
			}
		}
		System.out.println("第一次遍历" + Arrays.toString(arr));

		// 第二轮
		// 遍历数组内容，依次放到10个桶中
		for (int i = 0; i < len; i++) {
			// 得到当前值十位的数值
			int index = arr[i] / 10 % 10;
			// 将该数放到十位值 对应的桶中 比如十位是8 就放在bucket[8][] 桶中
			bucket[index][bucketElementCounts[index]] = arr[i];
			// 放入桶中后，将该桶的数值标记加1
			bucketElementCounts[index] += 1;
		}
		// 数组下标，以便下面遍历10个桶将数据依次放入到arr 数组中
		arrIndex = 0;
		// 然后需要将10个桶中的数据依次放入到数组中
		for (int i = 0; i < bucket.length; i++) {
			if (bucketElementCounts[i] > 0) {
				for (int j = 0; j < bucketElementCounts[i]; j++) {
					arr[arrIndex++] = bucket[i][j];
				}
				// 做完遍历后，将当前桶的存放数个数置为0，以便下次使用
				bucketElementCounts[i] = 0;
			}
		}
		System.out.println("第二次遍历" + Arrays.toString(arr));

		// 第三轮
		// 遍历数组内容，依次放到10个桶中
		for (int i = 0; i < len; i++) {
			// 得到当前值百位的数值
			int index = arr[i] / 100 % 10;
			// 将该数放到百位值 对应的桶中 比如百位是8 就放在bucket[8][] 桶中
			bucket[index][bucketElementCounts[index]] = arr[i];
			// 放入桶中后，将该桶的数值标记加1
			bucketElementCounts[index] += 1;
		}
		// 数组下标，以便下面遍历10个桶将数据依次放入到arr 数组中
		arrIndex = 0;
		// 然后需要将10个桶中的数据依次放入到数组中
		for (int i = 0; i < bucket.length; i++) {
			if (bucketElementCounts[i] > 0) {
				for (int j = 0; j < bucketElementCounts[i]; j++) {
					arr[arrIndex++] = bucket[i][j];
				}
				// 做完遍历后，将当前桶的存放数个数置为0，以便下次使用
				bucketElementCounts[i] = 0;
			}
		}
		System.out.println("第三次遍历" + Arrays.toString(arr));
	}
}
