/*
 * Copyright (c) 2021.  User:Unique66 File:HJ43Maze.java
 * Date:2021/07/26 01:38:26
 */

package com.autonomic.nowcoder.hw.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Unique66
 * @description HJ43 迷宫问题
 * @date 2021/7/26 1:38
 * <p>
 * https://www.nowcoder.com/practice/cf24906056f4488c9ddb132f317e03bc?tpId=37&&tqId=21266&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示：
 * <p>
 * int maze[5][5] = {
 * 0, 1, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 1, 0,
 * };
 * <p>
 * <p>
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一格是可以走的路。
 * <p>
 * <p>
 * 本题含有多组数据。
 * <p>
 * 输入描述：
 * 输入两个整数，分别表示二维数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
 * <p>
 * 输出描述：
 * 左上角到右下角的最短路径，格式如样例所示。
 * <p>
 * 示例1
 * 输入：
 * 5 5
 * 0 1 0 0 0
 * 0 1 1 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 * <p>
 * 输出：
 * (0,0)
 * (1,0)
 * (2,0)
 * (2,1)
 * (2,2)
 * (2,3)
 * (2,4)
 * (3,4)
 * (4,4)
 * <p>
 * 示例2
 * 输入：
 * 5 5
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 1
 * 0 1 1 1 0
 * 0 0 0 0 0
 * <p>
 * 输出：
 * (0,0)
 * (1,0)
 * (2,0)
 * (3,0)
 * (4,0)
 * (4,1)
 * (4,2)
 * (4,3)
 * (4,4)
 * <p>
 * 说明：
 * 注意：不能斜着走！！
 */
public class HJ43Maze {
    public static Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int row = in.nextInt();
            int list = in.nextInt();
            // 制作迷宫
            int[][] maze = new int[row][list];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < list; j++) {
                    maze[i][j] = in.nextInt();
                }
            }
            // 从0,0 开始
            find(0, 0, maze);
            List<String> l = new ArrayList<>();
            while (!stack.isEmpty()) {
                l.add(stack.pop());
            }
            for (int i = l.size() - 1; i >= 0; i--) {
                System.out.println(l.get(i));
            }
        }
    }

    public static boolean find(int row, int list, int[][] maze) {
        if (row < 0 || list < 0 || row > maze.length - 1 || list > maze[0].length - 1) {
            return false;
        }
        if (maze[maze.length - 1][maze[0].length - 1] == 2) {
            return true;
        }
        // 如果可以通过将该处设为2，表示走过了
        if (maze[row][list] == 0) {
            maze[row][list] = 2;
            stack.push("(" + row + "," + list + ")");
            if (find(row + 1, list, maze)) { // 向下
                return true;
            } else if (find(row, list + 1, maze)) { // 向右
                return true;
            } else if (find(row - 1, list, maze)) { // 向上
                return true;
            } else if (find(row, list - 1, maze)) { // 向左
                return true;
            } else {
                maze[row][list] = 3;
                stack.pop();
                return false;
            }
        } else {
            stack.pop();
            return false;
        }
    }
}
