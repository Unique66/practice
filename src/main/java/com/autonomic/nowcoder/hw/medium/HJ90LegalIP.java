/*
 * Copyright (c) 2021.  User:Unique66 File:HJ90LegalIP.java
 * Date:2021/07/29 00:15:29
 */

package com.autonomic.nowcoder.hw.medium;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ90 合法IP
 * @date 2021/7/29 0:15
 * <p>
 * https://www.nowcoder.com/practice/995b8a548827494699dc38c3e2a54ee9?tpId=37&&tqId=21313&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 现在IPV4下用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，每个部分为8位，表示成一个无符号整数（因此不需要用正号出现），如10.137.17.1，是我们非常熟悉的IP地址，一个IP地址串中没有空格出现（因为要表示成一个32数字）。
 * <p>
 * 现在需要你用程序来判断IP是否合法。
 * <p>
 * 注意本题有多组样例输入。
 * <p>
 * 输入描述：
 * 输入一个ip地址，保证是xx.xx.xx.xx的形式（xx为整数）
 * <p>
 * 输出描述：
 * 返回判断的结果YES or NO
 * <p>
 * 示例1
 * 输入：
 * 10.138.15.1
 * 255.0.0.255
 * 255.255.255.1000
 * 输出：
 * YES
 * YES
 * NO
 */
public class HJ90LegalIP {
    // 疑虑：是否可以使用八个0与 的方式判断是否合法
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String ip = in.nextLine();
            String[] splitIp = ip.split("\\.");
            if (splitIp.length != 4) {
                System.out.println("NO");
            } else {
                System.out.println(isLegal(splitIp[0]) && isLegal(splitIp[1])
                        && isLegal(splitIp[2]) && isLegal(splitIp[3]) ? "YES" : "NO");
            }
        }
    }

    public static boolean isLegal(String i) {
        int num = Integer.parseInt(i);
        return num >= 0 && num <= 255;
    }
}
