/*
 * Copyright (c) 2021.  User:Unique66 File:HJ72OneHundredDollarsBuyAHundredChickens.java
 * Date:2021/07/15 00:05:15
 */

package com.autonomic.nowcoder.hw.simpleness;

/**
 * @author Unique66
 * @description HJ72 百钱买百鸡问题
 * @date 2021/7/15 0:05
 *
 * https://www.nowcoder.com/practice/74c493f094304ea2bda37d0dc40dc85b?tpId=37&&tqId=21295&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，
 * 鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
 *
 * 详细描述：
 *
 * 接口说明
 *
 * 原型：
 *
 * int GetResult(vector &list)
 *
 * 输入参数：
 *
 *         无
 *
 * 输出参数（指针指向的内存区域保证有效）：
 *
 *     list  鸡翁、鸡母、鸡雏组合的列表
 *
 * 返回值：
 *      -1 失败
 *
 *      0 成功
 *
 * 输入描述：
 * 输入任何一个整数，即可运行程序。
 *
 * 输出描述：
 *
 *
 * 示例1
 * 输入：1
 * 输出：
 * 0 25 75
 * 4 18 78
 * 8 11 81
 * 12 4 84
 */
public class HJ72OneHundredDollarsBuyAHundredChickens {
    public static void main(String[] args) {
        // 鸡公最多20 只、鸡母最多33只、鸡雏3只3只卖的，所以需要递增3
        for (int x = 0; x <= 20; x++) {
            for (int y = 0; y <= 33; y++) {
                for (int z = 0; z <= 100; z+=3) { // 1钱买三只，所以z+=3 ,百钱买百鸡-> 最多只能买100 只
                    if (x + y + z == 100 && x * 5 + y * 3 + z / 3 == 100) {
                        System.out.println(x + " " + y + " " + z);
                    }
                }
            }
        }
    }
}
