package com.autonomic.algorithm.sort;/**
 * Created by SXH on 2020/5/11 23:15.
 */

import javax.sound.midi.Soundbank;
import java.util.Date;

/**
 * @author SXH
 * @description 冒泡排序
 * @date 2020/5/11 23:15.
 * 思想：
 *  1.一共进行数组的大小-1 次大的循环
 *  2.每一趟排序的次数在逐渐减少
 *  3.如果我们发现某趟排序中，没有发生一次交换，可以提前结束冒泡
 */
public class BubblingSort {
	public static void main(String[] args) {
		int [] array = {3, 9, -1, 10, 20};
		int[] array2 = {6, 2, 1, 5, 3, 0};
		sort(array);
		print(array);

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

	// 从小到大排序 array数组
	// 冒泡排序的时间复杂度是 O(n²)
	public static void sort(int [] array) {
		int temp = 0;
		// 用于标识一次小的排序中是否发生过交换，如果没有发生过交换即可以优化算法，后面不用继续比较了
		boolean flag = true;
		for (int i = 0, len = array.length; i < len - 1; i++) {
			for (int j = 0; j < len - 1 -i; j++) {
				if (array[j] > array[j + 1]) { // 如果前面比后面大，就交换位置
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					flag = false;
				}
			}
//			System.out.println("第" + (i + 1) + "趟排序后的数组");
//			print(array);
			if (flag) { // 在一趟排序中，一次交换都没有发生过
				break;
			} else { // 重置flag
				flag = true;
			}
		}
	}

	public static void print(int [] array) {
		for (int i = 0, len = array.length; i < len; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
