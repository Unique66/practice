package com.autonomic.algorithm.sort;/**
 * Created by SXH on 2020/5/14 22:13.
 */

import java.util.Arrays;

/**
 * @author SXH
 * @description 插入排序
 * @date 2020/5/14 22:13.
 */
public class InsertionSort {
	public static void main(String[] args) {
		int [] arr1 = {103, 80 ,60, 70, 50, -1, 90, 66, 3, -10,90};
		System.out.println(Arrays.toString(arr1));
//		sort(arr1);
		practiceSort(arr1);
		System.out.println(Arrays.toString(arr1));

		// 创建80000个随机数的数组
//		int MAX_SIZE = 80000;
//		int [] arr = new int[MAX_SIZE];
//		for (int i = 0; i < MAX_SIZE; i++) {
//			arr[i] = (int)(Math.random() * 8000000);
//		}
//		long start = System.currentTimeMillis();
//		System.out.println(start);
//		sort(arr);
//		long end = System.currentTimeMillis();
//		System.out.println(end);
//		System.out.println((end - start)); // 八万数据大概耗时 600ms
	}

	/**
	 * my practice
	 * 左边有序表  右边无序表，从第二个开始（也就是index=1），index=0 为初始有序表
	 * 效率降低50%
	 * @date 2020/10/29 22:53.
	 */
	public static void practiceSort(int [] arr) {
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
			}
		}
	}

	/**
	 * @Author SXH
	 * // 思路：
	 * 		把n 个待排序的元素看成一个有序表和一个无序表，开始时有序表质保函一个元素，
	 * 		无序表中包含n-1 个元素，排序过程中每次从无序表取出第一个元素，把它的排序码
	 * 		依次与有序表的排序码比较，将它插入到有序表中的适当位置，使之成为新的有序表。
	 * @Date 2020/5/14  22:42
	 **/
	public static void sort(int [] arr) {
		int insertVal = 0; // 待插入的值
		int insertIndex = 0; // 插入的下标
		for (int i = 1, len = arr.length; i < len; i++) { // 从第二个数开始比较，第一个数默认放入到有序队列
			// 暂存每次从无序表里面拿出要放入有序表中的数
			insertVal = arr[i];
			// 初始要插入的下标
			insertIndex = i - 1;
			// 第一个比较是防止下标越界
			// 第二个比较（从小到大排序） 比较要插入的值和插入下标对应的值，小了就交换双方的值向前然后继续循环
			while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
				// 满足while的条件，表明有序表中的那个值大于从无序表中拿出来的值，
				// 那么这个无序表中的值就还没有找到它的位置，需要将有序表的那个值向后移动一位
				arr[insertIndex + 1] = arr[insertIndex];
				// 并且继续拿无序表中的那个值和有序表的前一个值对比，（想定于从后向前遍历找无序表那个数的下标）
				insertIndex--;
			}
			// 判断如果需要插入的位置和自己本身的位置一样，就不需要进行赋值操作了
			if (insertIndex + 1 != i) {
				// 循环完毕后就确定了要插入的下标
				arr[insertIndex+1] = insertVal;
			}
//			System.out.println("第" + i + "轮插入");
//			System.out.println(Arrays.toString(arr));
		}
	}
}
