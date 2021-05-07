package com.autonomic.algorithm.sort;/**
 * Created by SXH on 2020/5/11 23:15.
 */

import java.util.Arrays;

/**
 * @author SXH
 * @description 冒泡排序
 * @date 2020/5/11 23:15.
 * 思想：
 * 1.一共进行数组的大小-1 次大的循环
 * 2.每一趟排序的次数在逐渐减少
 * 3.如果我们发现某趟排序中，没有发生一次交换，可以提前结束冒泡
 */
public class BubblingSort {
    public static void main(String[] args) {
        int[] array = {3, 9, -1, 10, 20};
        sort(array);
        System.out.println(Arrays.toString(array));

        int[] array2 = {3, 4, 2, 1, 5, 6, 7, 8};
        optimizeSort(array2);
        System.out.println(Arrays.toString(array2));

        int[] array3 = {2, 3, 4, 5, 6, 7, 8, 1};
        cocktailSort(array3);
        System.out.println(Arrays.toString(array3));

        // 创建80000个随机数的数组
		int MAX_SIZE = 80000;
		int [] arr = new int[MAX_SIZE];
		for (int i = 0; i < MAX_SIZE; i++) {
			arr[i] = (int)(Math.random() * 8000000);
		}
		long start = System.currentTimeMillis();
        optimizeSort(arr);
//        System.out.println(Arrays.toString(arr));
		long end = System.currentTimeMillis();
		System.out.println((end - start)); // 八万数据普通冒泡大概耗时 14s   鸡尾酒排序大概8s

    }

    // 第一次优化后的冒泡排序
    // 从小到大排序 array数组
    // 冒泡排序的时间复杂度是 O(n²)
    public static void sort(int[] array) {
        for (int i = 0, len = array.length; i < len - 1; i++) {
            // 用于标识一次小的排序中是否发生过交换，如果没有发生过交换即可以优化算法，后面不用继续比较了
            boolean flag = true;
            for (int j = 0; j < len - 1 - i; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) { // 如果前面比后面大，就交换位置
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
//			System.out.println("第" + (i + 1) + "趟排序后的数组");
            if (flag) { // 在一趟排序中，一次交换都没有发生过
                break;
            }
        }
    }

    // 第二次优化的冒泡排序
    public static void optimizeSort(int[] arr) {
        // 存在一种情况：3,4,2,1,5,6,7,8 后半段已经是有序的了，之后多次遍历后半部分是没有必要的
        // 按照现有的逻辑，有序区的长度和排序的轮数是相等的，例如第1轮排序过后的有序区长度是1，第2轮排序过后的有序区长度是2...
        // 上述情况有序区长度会大于排序的轮数，所以记录有序区的位置即可省去不必要的排序
        int sortBorder = arr.length - 1; // 初始有序边界为最后一个元素
        int lastExchangeIndex = 0; // 记录最后一次交换的位置
        for (int i = 0; i < arr.length - 1; i++) { // 依旧是arr.length - 1 次遍历
            boolean isSorted = true; // 如果数组处于排序完毕状态，就可以直接跳出该循环
            for (int j = 0; j < sortBorder; j++) {
                int temp = 0;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false;
                    // 更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    // 基于冒泡排序的鸡尾酒排序法
    public static void cocktailSort(int[] arr) {
        int tmp = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            // 有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            // 奇数轮，从左向右比较和交换
            for (int j = i; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    // 有元素交换，所以不是有序的，标记变为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }

            // 偶数轮之前，将isSorted 重新标记为true
            isSorted = true;
            // 偶数轮，从右向左比较和交换
            for (int j = arr.length - i - 2; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                    // 有元素交换，所以不是有序的，标记变为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}
