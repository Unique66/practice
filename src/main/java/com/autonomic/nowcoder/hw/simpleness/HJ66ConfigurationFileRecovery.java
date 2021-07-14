/*
 * Copyright (c) 2021.  User:Unique66 File:HJ66ConfigurationFileRecovery.java
 * Date:2021/07/14 23:44:14
 */

package com.autonomic.nowcoder.hw.simpleness;

import java.util.*;

/**
 * @author Unique66
 * @description HJ66 配置文件恢复
 * @date 2021/7/14 23:44
 *
 * https://www.nowcoder.com/practice/ca6ac6ef9538419abf6f883f7d6f6ee5?tpId=37&&tqId=21289&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 有6条配置命令，它们执行的结果分别是：
 *
 * 命   令	            执   行
 * reset	            reset what
 * reset board	        board fault
 * board add	        where to add
 * board delete	        no board at all
 * reboot backplane	    impossible
 * backplane abort	    install first
 * he he	            unknown command
 * 注意：he he不是命令。
 *
 * 为了简化输入，方便用户，以“最短唯一匹配原则”匹配：
 * 1、若只输入一字串，则只匹配一个关键字的命令行。例如输入：r，根据该规则，匹配命令reset，
 * 执行结果为：reset what；输入：res，根据该规则，匹配命令reset，执行结果为：reset what；
 * 2、若只输入一字串，但本条命令有两个关键字，则匹配失败。例如输入：reb，可以找到命令reboot backpalne，
 * 但是该命令有两个关键词，所有匹配失败，执行结果为：unknown command
 * 3、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果仍不唯一，匹配失败。
 * 例如输入：r b，找到匹配命令reset board 和 reboot backplane，执行结果为：unknown command。
 * 4、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果唯一，匹配成功。
 * 例如输入：b a，无法确定是命令board add还是backplane abort，匹配失败。
 * 5、若输入两字串，第一关键字匹配成功，则匹配第二关键字，若无匹配，失败。例如输入：bo a，确定是命令board add，匹配成功。
 * 6、若匹配失败，打印“unknown command”
 *
 *
 * 输入描述：
 * 多行字符串，每行字符串一条命令
 *
 * 输出描述：
 * 执行结果，每条命令输出一行
 */
public class HJ66ConfigurationFileRecovery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        map.put("reset", "reset what");
        map.put("reset board", "board fault");
        map.put("board add", "where to add");
        map.put("reboot backplane", "impossible");
        map.put("backplane abort", "install first");
        map.put("board delete", "no board at all");
        map.put("noMatch", "unknown command");
        Set<String[]> str = new HashSet<>();
        for (String s : map.keySet()) {
            str.add(s.split(" "));
        }

        while (sc.hasNext()) {
            String[] arr = sc.nextLine().split(" ");
            String res = "noMatch";
            int count = 0;
            for (String[] s : str) {
                if (arr.length == 1) {
                    if (s.length == 2)
                        continue;
                    else {
                        if (s[0].startsWith(arr[0]))
                            res = s[0];
                    }
                }
                if (arr.length == 2 && s.length != 1
                        && s[0].startsWith(arr[0]) && s[1].startsWith(arr[1])) {
                    res = s[0] + " " + s[1];
                    count++;
                }
            }
            System.out.println(count > 1 ? "unknown command" : map.get(res));
        }
    }
}
