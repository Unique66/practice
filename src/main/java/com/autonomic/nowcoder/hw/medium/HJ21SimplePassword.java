/*
 * Copyright (c) 2021.  User:Unique66 File:HJ21SimplePassword.java
 * Date:2021/07/26 01:23:26
 */

package com.autonomic.nowcoder.hw.medium;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ21 简单密码
 * @date 2021/7/26 1:23
 * <p>
 * https://www.nowcoder.com/practice/7960b5038a2142a18e27e4c733855dac?tpId=37&&tqId=21244&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 密码是我们生活中非常重要的东东，我们的那么一点不能说的秘密就全靠它了。哇哈哈. 接下来渊子要在密码之上再加一套密码，虽然简单但也安全。
 * <p>
 * <p>
 * 假设渊子原来一个BBS上的密码为zvbo9441987,为了方便记忆，他通过一种算法把这个密码变换成YUANzhi1987，这个密码是他的名字和出生年份，怎么忘都忘不了，而且可以明目张胆地放在显眼的地方而不被别人知道真正的密码。
 * <p>
 * <p>
 * 他是这么变换的，大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,就这么简单，渊子把密码中出现的小写字母都变成对应的数字，数字和其他的符号都不做变换，
 * <p>
 * <p>
 * 声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，如：X，先变成小写，再往后移一位，不就是y了嘛，简单吧。记住，z往后移是a哦。
 * <p>
 * <p>
 * 输入描述：
 * 输入包括多个测试数据。输入是一个明文，密码长度不超过100个字符，输入直到文件结尾
 * <p>
 * 输出描述：
 * 输出渊子真正的密文
 * <p>
 * 示例1
 * 输入：YUANzhi1987
 * 输出：zvbo9441987
 */
public class HJ21SimplePassword {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                sb.append(exchange(c));
            }
            System.out.println(sb.toString());
        }
    }

    public static char exchange(char c) {
        if (c >= 'A' && c <= 'Z') {
            // 'a' - 'A' = 32，因为大转下要往后移动一位，所以+33
            // /123 是因为'z' 的int 为122，'Y' 转'z' 后122 与123 取余，可以得到122，也就是'z'
            if ((c + 33) / 123 >= 1) { // 可能Z 转a 所以要取余，+ ‘a’
                return (char) ((c + 33) % 123 + 97);
            } else {
                return (char) ((c + 33) % 123);
            }
        } else if (c >= 'a' && c <= 'z') {
            if (c <= 'c') {
                return '2';
            } else if (c <= 'f') {
                return '3';
            } else if (c <= 'i') {
                return '4';
            } else if (c <= 'l') {
                return '5';
            } else if (c <= 'o') {
                return '6';
            } else if (c <= 's') {
                return '7';
            } else if (c <= 'v') {
                return '8';
            } else {
                return '9';
            }
        } else {
            return c;
        }
    }
}
