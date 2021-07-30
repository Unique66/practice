/*
 * Copyright (c) 2021.  User:Unique66 File:HJ83TwoDimensionalArray.java
 * Date:2021/07/30 01:08:30
 */

package com.autonomic.nowcoder.hw.simpleness;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ83 二维数组操作
 * @date 2021/7/30 1:08
 * <p>
 * https://www.nowcoder.com/practice/2f8c17bec47e416897ce4b9aa560b7f4?tpId=37&&tqId=21306&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 有一个 m*n 大小的数据表，你会依次进行以下5种操作：
 * 1.输入m 和 n，初始化 m*n 大小的表格。
 * 2.输入x1、y1、x2、y2，交换坐标在(x1, y1) 和(x2, y2) 的两个数
 * 3.输入x ，在第x 行上方添加一行。
 * 4.输入y，在第y 列左边添加一列。
 * 5.输入x、y，查找坐标为(x, y)的单元格的值。
 * 请编写程序，判断对表格的各种操作是否合法。
 * <p>
 * 详细要求:
 * 1.数据表的最大规格为9行*9列，对表格进行操作时遇到超出规格应该返回错误。
 * 2.对于插入操作，如果插入后行数或列数超过9了则应返回错误。
 * 如果插入成功了则将数据表恢复至初始化的 m*n 大小，多出的数据则应舍弃。
 * 3.所有输入坐标操作，对 m*n 大小的表格，行号坐标只允许0~m-1，列号坐标只允许0~n-1。
 * 超出范围应该返回错误。
 * 本题含有多组样例输入！
 * <p>
 * 输入描述：
 * 输入数据按下列顺序输入：
 * 1 表格的行列值
 * 2 要交换的两个单元格的行列值
 * 3 输入要插入的行的数值
 * 4 输入要插入的列的数值
 * 5 输入要查询的单元格的坐标
 * <p>
 * 输出描述：
 * 输出按下列顺序输出：
 * 1 初始化表格是否成功，若成功则返回0， 否则返回-1
 * 2 输出交换单元格是否成功
 * 3 输出插入行是否成功
 * 4 输出插入列是否成功
 * 5 输出查询单元格数据是否成功
 * <p>
 * 示例1
 * 输入：
 * 4 9
 * 5 1 2 6
 * 0
 * 8
 * 2 3
 * 4 7
 * 4 2 3 2
 * 3
 * 3
 * 4 7
 * 输出：
 * 0
 * -1
 * 0
 * -1
 * 0
 * 0
 * -1
 * 0
 * 0
 * -1
 * 复制
 * 说明：
 * 本组样例共有2组样例输入。
 * 第一组样例：
 * 1.初始化数据表为4行9列，成功
 * 2.交换第5行1列和第2行6列的数据，失败。因为行的范围应该是(0,3)，不存在第5行。
 * 3.在第0行上方添加一行，成功。
 * 4.在第8列左边添加一列，失败。因为列的总数已经达到了9的上限。
 * 5.查询第2行第3列的值，成功。
 * 第二组样例：
 * 1.初始化数据表为4行7列，成功
 * 2.交换第4行2列和第3行2列的数据，失败。因为行的范围应该是(0,3)，不存在第4行。
 * 3.在第3行上方添加一行，成功。
 * 4.在第3列左边添加一列，成功。
 * 5.查询第4行7列的值，失败。因为虽然添加了一行一列，但数据表会在添加后恢复成4行7列的形态，
 * 所以行的区间仍然在[0,3]，列的区间仍然在[0,6]，无法查询到(4,7)坐标。
 */
public class HJ83TwoDimensionalArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt(); // 行
            int n = sc.nextInt(); // 列
            int[] zuobiao1 = new int[2];
            zuobiao1[0] = sc.nextInt();
            zuobiao1[1] = sc.nextInt();
            int[] zuobiao2 = new int[2];
            zuobiao2[0] = sc.nextInt();
            zuobiao2[1] = sc.nextInt();
            int x = sc.nextInt(); // 在第x行左边插入一行
            int y = sc.nextInt(); // 在第y列上方插入一列
            int searchHang = sc.nextInt();
            int searchLie = sc.nextInt();
            // 所有输入数据读取完毕
            // 1、
            if (m > 9 || n > 9) {
                // 初始化表格失败
                System.out.println(-1);
            } else {
                System.out.println(0);
            }
            // 2、
            if (zuobiao1[0] < m && zuobiao2[0] < m && zuobiao2[1] < n) {
                // 交换单元格成功
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            // 3、
            if (x < m && 1 + m <= 9) {
                // 插入行成功
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            // 4、
            if (y < n && 1 + n <= 9) {
                // 插入列成功
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            // 5、
            if (searchHang < m && searchLie < n) {
                // 查找成功
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
        }
    }
}
