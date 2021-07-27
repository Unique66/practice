/*
 * Copyright (c) 2021.  User:Unique66 File:HJ64MP3CursorPosition.java
 * Date:2021/07/27 23:08:27
 */

package com.autonomic.nowcoder.hw.medium;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ64 MP3光标位置
 * @date 2021/7/27 23:08
 *
 * https://www.nowcoder.com/practice/eaf5b886bd6645dd9cfb5406f3753e15?tpId=37&&tqId=21287&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * MP3 Player因为屏幕较小，显示歌曲列表的时候每屏只能显示几首歌曲，用户要通过上下键才能浏览所有的歌曲。
 * 为了简化处理，假设每屏只能显示4首歌曲，光标初始的位置为第1首歌。
 *
 *
 * 现在要实现通过上下键控制光标移动来浏览歌曲列表，控制逻辑如下：
 *
 * 歌曲总数<=4的时候，不需要翻页，只是挪动光标位置。
 *
 * 光标在第一首歌曲上时，按Up键光标挪到最后一首歌曲；光标在最后一首歌曲时，按Down键光标挪到第一首歌曲。
 * 其他情况下用户按Up键，光标挪到上一首歌曲；用户按Down键，光标挪到下一首歌曲。
 *
 * 2. 歌曲总数大于4的时候（以一共有10首歌为例）：
 *
 *
 * 特殊翻页：屏幕显示的是第一页（即显示第1 – 4首）时，光标在第一首歌曲上，用户按Up键后，
 * 屏幕要显示最后一页（即显示第7-10首歌），同时光标放到最后一首歌上。同样的，屏幕显示最后一页时，光
 * 标在最后一首歌曲上，用户按Down键，屏幕要显示第一页，光标挪到第一首歌上。
 *
 * 一般翻页：屏幕显示的不是第一页时，光标在当前屏幕显示的第一首歌曲时，用户按Up键后，屏幕从当前歌曲的
 * 上一首开始显示，光标也挪到上一首歌曲。光标当前屏幕的最后一首歌时的Down键处理也类似。
 * 其他情况，不用翻页，只是挪动光标就行。
 *
 * 输入描述：
 * 输入说明：
 * 1 输入歌曲数量
 * 2 输入命令 U或者D
 *
 * 本题含有多组输入数据！
 *
 * 输出描述：
 * 输出说明
 * 1 输出当前列表
 * 2 输出当前选中歌曲
 *
 * 示例1
 * 输入：
 * 10
 * UUUU
 * 输出：
 * 7 8 9 10
 * 7
 */
public class HJ64MP3CursorPosition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());
            String command = in.nextLine();
            // 前提条件：初始光标在1，屏幕中只能有4首歌
            int bottom = Math.min(n, 4); // 底部，总数大于4个的底部初始为4
            int index = 1; // 初始光标所在位置
            for (char c : command.toCharArray()) {
                if (c == 'U') { // up
                    if (index == 1) { // 最顶部情况处理
                        bottom = n;
                        index = n;
                    } else if (index == bottom - 3){ // 光标在顶部
                        if (n > 4) {
                            bottom--;
                        }
                        index--;
                    } else { // 底部不动，光标正常up
                        index--;
                    }
                } else { // down
                    if (index == n) { // 最底部情况处理
                        index = 1;
                        bottom = Math.min(n, 4);
                    } else if (index == bottom) { // 光标在底部
                        bottom++;
                        index = bottom;
                    } else { // 底部不动，光标正常down
                        index++;
                    }
                }
            }
            if (n <= 4) { // 4首歌以内的情况
                for (int i = 1; i <=n; i++) {
                    System.out.print(i);
                    if (i != n) {
                        System.out.print(" ");
                    }
                }
            } else { // 超过四首歌的情况
                for (int i = 3; i >= 0; i--) {
                    System.out.print(bottom - i);
                    if (i != 0) {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
            System.out.println(index);
        }
    }
}
