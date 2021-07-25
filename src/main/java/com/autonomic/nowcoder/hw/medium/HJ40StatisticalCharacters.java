/*
 * Copyright (c) 2021.  User:Unique66 File:HJ40StatisticalCharacters.java
 * Date:2021/07/26 01:36:26
 */

package com.autonomic.nowcoder.hw.medium;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ40 统计字符
 * @date 2021/7/26 1:36
 * <p>
 * https://www.nowcoder.com/practice/539054b4c33b4776bc350155f7abd8f5?tpId=37&&tqId=21263&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
 * <p>
 * 本题包含多组输入。
 * <p>
 * <p>
 * 输入描述：
 * 输入一行字符串，可以有空格
 * <p>
 * 输出描述：
 * 统计其中英文字符，空格字符，数字字符，其他字符的个数
 * <p>
 * 示例1
 * 输入：1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\][
 * 输出：
 * 26
 * 3
 * 10
 * 12
 */
public class HJ40StatisticalCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            int letter = 0;
            int space = 0;
            int digit = 0;
            int other = 0;
            for (char c : str.toCharArray()) {
                if (Character.isLetter(c)) {
                    letter++;
                } else if (Character.isSpaceChar(c)) {
                    space++;
                } else if (Character.isDigit(c)) {
                    digit++;
                } else {
                    other++;
                }
            }
            System.out.println(letter);
            System.out.println(space);
            System.out.println(digit);
            System.out.println(other);
        }
    }
}
