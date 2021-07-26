/*
 * Copyright (c) 2021.  User:Unique66 File:HJ63DNASequences.java
 * Date:2021/07/27 00:31:27
 */

package com.autonomic.nowcoder.hw.medium;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ63 DNA序列
 * @date 2021/7/27 0:31
 * <p>
 * https://www.nowcoder.com/practice/e8480ed7501640709354db1cc4ffd42a?tpId=37&&tqId=21286&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例（定义为GC-Ratio）是序列中G和C两个
 * 字母的总的出现次数除以总的字母数目（也就是序列长度）。在基因工程中，这个比例非常重要。
 * 因为高的GC-Ratio可能是基因的起始点。
 * <p>
 * 给定一个很长的DNA序列，以及限定的子串长度N，请帮助研究人员在给出的DNA序列中
 * 从左往右找出GC-Ratio最高且长度为N的第一个子串。
 * DNA序列为ACGT的子串有:ACG,CG,CGT等等，但是没有AGT，CT等等
 * 输入描述：
 * 输入一个string型基因序列，和int型子串的长度
 * <p>
 * 输出描述：
 * 找出GC比例最高的子串,如果有多个则输出第一个的子串
 * <p>
 * 示例1
 * 输入：
 * ACGT
 * 2
 * 输出：
 * CG
 * <p>
 * 说明：
 * ACGT长度为2的子串有AC,CG,GT3个，其中AC和GT2个的GC-Ratio都为0.5，CG为1，故输出CG
 * <p>
 * 示例2
 * 输入：
 * AACTGTGCACGACCTGA
 * 5
 * 输出：
 * GCACG
 * <p>
 * 说明：
 * 虽然CGACC的GC-Ratio也是最高，但它是从左往右找到的GC-Ratio最高的第2个子串，所以只能输出GCACG。
 */
public class HJ63DNASequences {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            int n = Integer.parseInt(in.nextLine());
            String result = ""; // 含G 和 C 最多的字符串

            for (int i = 0; i <= str.length() - n; i++) {
                String substring = str.substring(i, i + n); // 截取字符串
                int size = getGCSize(substring);
                if (getGCSize(result) < size) { // 如果比历史最高出现的频率还高，则替换
                    result = substring;
                }
            }
            System.out.println(result);
        }
    }

    // 获取str 字符串中G 和C 的个数
    public static int getGCSize(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'G' || str.charAt(i) == 'C') {
                count++;
            }
        }
        return count;
    }
}
