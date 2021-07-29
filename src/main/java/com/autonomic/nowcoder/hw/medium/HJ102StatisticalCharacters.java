/*
 * Copyright (c) 2021.  User:Unique66 File:HJ102StatisticalCharacters.java
 * Date:2021/07/29 22:31:29
 */

package com.autonomic.nowcoder.hw.medium;

import java.util.*;

/**
 * @author Unique66
 * @description HJ102 字符统计
 * @date 2021/7/29 22:31
 * <p>
 * https://www.nowcoder.com/practice/c1f9561de1e240099bdb904765da9ad0?tpId=37&&tqId=21325&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，
 * 如果统计的个数相同，则按照ASCII码由小到大排序输出。
 * 本题含有多组样例输入
 * <p>
 * 输入描述：
 * 一个只包含小写英文字母和数字的字符串。
 * <p>
 * 输出描述：
 * 一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出。
 * <p>
 * 示例1
 * 输入：
 * aaddccdc
 * 1b1bbbbbbbbb
 * 输出：
 * cda
 * b1
 * <p>
 * 说明：
 * 第一个样例里，c和d出现3次，a出现2次，但c的ASCII码比d小，所以先输出c，再输出d，最后输出a.
 */
public class HJ102StatisticalCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : str.toCharArray()) {
                map.merge(c, 1, Integer::sum);
            }
            List<MyString> list = new LinkedList<>();
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                list.add(new MyString(entry.getKey(), entry.getValue()));
            }
            list.sort((o1, o2) -> {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey() - o2.getKey(); // 在个数相同的情况下，ASCII 小的在前面
                }
                return o2.getValue() - o1.getValue(); // 个数多的在前面
            });
            StringBuilder sb = new StringBuilder();
            for (MyString s : list) {
                sb.append(s.getKey());
            }
            System.out.println(sb.toString());
        }
    }
}

class MyString {
    private Character key;
    private Integer value;

    public MyString(Character key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Character getKey() {
        return key;
    }

    public void setKey(Character key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}