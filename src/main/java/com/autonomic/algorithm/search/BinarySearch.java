package com.autonomic.algorithm.search;/**
 * Created by SXH on 2020/5/27 23:02.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author SXH
 * @description 二分查找  只用于有序数组的查找
 * @date 2020/5/27 23:02.
 */
public class BinarySearch {
	public static void main(String[] args) {
//		int	[] arr = {1, 9, 14, 80, 100, 200, 300, 500, 1000};
//		System.out.println(binarySearch(arr, 0, arr.length - 1, -1));

		int	[] arr = {1, 9, 14, 80, 100, 100,100, 200, 300, 500, 1000};
		System.out.println(binarySearch2(arr, 0, arr.length - 1, 100));
	}

	/**
	 * @Author SXH
	 * @Description // 使用递归的方式查找目标参数的下标  这个方法不能找出多个目标值的下标
	 * @param arr 目标数组
	 * @param left	最左边下标
	 * @param right 最右边下标
	 * @param findVal 目标数值
	 * @Date 2020/5/27  23:04
	 **/
	public static Integer binarySearch(int [] arr, int left, int right, int findVal) {
		// 退出递归的条件，防止下标越界
		if (left > right) {
			return -1;
		}
		// 首先找出中间下标
		int mid = (left + right) / 2;
		// 然后拿中间下标对应的数值与目标数值进行对比
		if (arr[mid] > findVal) { // 如果大于目标数值，那么就要递归向左查找
			return binarySearch(arr, left, mid - 1, findVal);
		} else if (arr[mid] < findVal) { // 如果小于目标数值，那么久递归向右查找
			return binarySearch(arr, mid + 1, right, findVal);
		} else { // 否则就找到目标数值所在下标 并且返回
			return mid;
		}
	}

	/**
	 * @Author SXH
	 * @Description // 使用递归的方式查找目标参数的下标  这个方法能找出多个目标值的下标
	 * @param arr 目标数组
	 * @param left	最左边下标
	 * @param right 最右边下标
	 * @param findVal 目标数值
	 * @Date 2020/5/27  23:04
	 **/
	public static List<Integer> binarySearch2(int [] arr, int left, int right, int findVal) {
		// 退出递归的条件，防止下标越界
		if (left > right) {
			return new ArrayList<Integer>();
		}
		// 首先找出中间下标
		int mid = (left + right) / 2;
		List<Integer> list = new ArrayList<>();
		// 然后拿中间下标对应的数值与目标数值进行对比
		if (arr[mid] > findVal) { // 如果大于目标数值，那么就要递归向左查找
			return binarySearch2(arr, left, mid - 1, findVal);
		} else if (arr[mid] < findVal) { // 如果小于目标数值，那么久递归向右查找
			return binarySearch2(arr, mid + 1, right, findVal);
		} else { // 否则就找到目标数值所在下标 并且返回
			// 此时防止有多个,先向左
			int temp = mid - 1;
			while (temp > left && arr[temp] == findVal) {
				list.add(temp);
				temp -= 1;
			}
			// 将找到的中间下标放入返回列表中
			list.add(mid);
			// 向右
			temp = mid + 1;
			while (temp < right && arr[temp] == findVal) {
				list.add(temp);
				temp += 1;
			}
			return list;
		}
	}
}
