package com.autonomic.algorithm.search;

import java.util.Arrays;

public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        int index = fibonacciSearch(a, 5);
        System.out.println(index);

    }

    public static int[] fib() {//返回一个斐波那契数组
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static int fibonacciSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0;//表示斐波那契分割值的下标
        int[] f = fib();//获取斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }

        //因为f[k]这个值可能大于数组a的长度，因此需要使用Arrays类，构造一个新的数组并指向a
        int[] temp = Arrays.copyOf(a, f[k]);//不足的部分会使用0填充
        //用数组的最后一个数来填充
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }

        while (low <= high) {
            int mid = low + f[k - 1] - 1;
            if (key < temp[mid])//应当向前面进行查找
            {
                high = mid - 1;
                k--;//全部元素=前面的元素+后面的元素
                //f[k]=f[k-1]+f[k-2]
                //因为前面有f[k-1]个元素所以可以继续拆分分配f[k-1]=f[k-2]+f[k-3]
                //即f[k-1]的前面继续查找k--
                //下次训话mid=f[k-1-1]-1
            } else if (k > temp[mid]) { //后面查找，右边查找
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}