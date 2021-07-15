/*
 * Copyright (c) 2021.  User:Unique66 File:NC71MinNumberInRotatesArray.java
 * Date:2021/07/10 22:40:10
 */

package com.autonomic.nowcoder.simpleness;

/**
 * @author Unique66
 * @description NC71 旋转数组的最小数字
 * @date 2021/7/10 22:40
 * <p>
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=117&&tqId=37768&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * 描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * <p>
 * 示例1
 * 输入：[3,4,5,1,2]
 * 返回值：1
 */
public class NC71MinNumberInRotatesArray {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int l = 0, r = array.length - 1;
        while (l < r) {
            if (array[l] < array[r]) {
                return array[l];
            }
            int mid = (r + l) / 2;
//            误区：那我们肯定在想，能不能把左端点看成target， 答案是不能。
//            原因：
//            情况1 ：1 2 3 4 5 ， arr[mid] = 3. target = 1, arr[mid] > target, 答案在mid 的左侧
//            情况2 ：3 4 5 1 2 ， arr[mid] = 5, target = 3, arr[mid] > target, 答案却在mid 的右侧
            if (array[mid] < array[r]) { // 在左边
                r = mid;
            } else if (array[mid] > array[r]) { // 在右边
                l = mid + 1;
            } else {
//                情况3，arr[mid] == target:
//                如果是 1 0 1 1 1， arr[mid] = target = 1, 显然答案在左边
//                如果是 1 1 1 0 1, arr[mid] = target = 1, 显然答案在右边
//                所以这种情况，不能确定答案在左边还是右边，那么就让last = last - 1;慢慢缩少区间，同时也不会错过答案。
                l++;
            }
        }
        return array[l];
    }
}
