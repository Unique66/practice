/*
 * Copyright (c) 2021.  User:Unique66 File:HJ36StringEncryption.java
 * Date:2021/07/26 01:32:26
 */

package com.autonomic.nowcoder.hw.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ36 字符串加密
 * @date 2021/7/26 1:32
 * <p>
 * https://www.nowcoder.com/practice/e4af1fe682b54459b2a211df91a91cf3?tpId=37&&tqId=21259&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。现在，修改过的那个单词属于字母表的下面，如下所示：
 * <p>
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 * <p>
 * T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
 * <p>
 * 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。因此，使用这个密匙，Attack AT DAWN(黎明时攻击)就会被加密为Tpptad TP ITVH。
 * <p>
 * 请实现下述接口，通过指定的密匙和明文得到密文。
 * <p>
 * <p>
 * 本题有多组输入数据。
 * <p>
 * 输入描述：
 * 先输入key和要加密的字符串
 * <p>
 * 输出描述：
 * 返回加密后的字符串
 * <p>
 * 示例1
 * 输入：
 * nihao
 * ni
 * 输出：le
 */
public class HJ36StringEncryption {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String key = in.nextLine();
            String data = in.nextLine();

            String s2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String s1 = s2.toLowerCase();


            List<String> list = new ArrayList<>();
            for (int i = 0; i < s1.length(); i++) {
                list.add(s1.charAt(i) + "");
            }

            StringBuilder str = new StringBuilder();
            for (int i = 0; i < key.length(); i++) {
                if (!(str.toString().contains(key.charAt(i) + ""))) {
                    str.append(key.charAt(i));
                }
            }

            //2.删一个添一个
            for (int i = 0; i < str.length(); i++) {
                list.remove(str.charAt(i) + "");
                list.add(i, str.charAt(i) + "");
            }

            for (int i = 0; i < data.length(); i++) {
                System.out.print(list.get(s1.indexOf(data.charAt(i))));
            }
            System.out.println();
        }
    }
}
