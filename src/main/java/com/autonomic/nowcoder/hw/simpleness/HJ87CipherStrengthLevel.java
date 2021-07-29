/*
 * Copyright (c) 2021.  User:Unique66 File:HJ87CipherStrengthLevel.java
 * Date:2021/07/14 00:26:14
 */

package com.autonomic.nowcoder.hw.simpleness;

import java.util.Scanner;

/**
 * @author Unique66
 * @description HJ87 密码强度等级
 * @date 2021/7/14 0:26
 * <p>
 * https://www.nowcoder.com/practice/52d382c2a7164767bca2064c1c9d5361?tpId=37&&tqId=21310&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 描述
 * 密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
 * <p>
 * 一、密码长度:
 * <p>
 * 5 分: 小于等于4 个字符
 * <p>
 * 10 分: 5 到7 字符
 * <p>
 * 25 分: 大于等于8 个字符
 * <p>
 * 二、字母:
 * <p>
 * 0 分: 没有字母
 * <p>
 * 10 分: 全都是小（大）写字母
 * <p>
 * 20 分: 大小写混合字母
 * <p>
 * 三、数字:
 * <p>
 * 0 分: 没有数字
 * <p>
 * 10 分: 1 个数字
 * <p>
 * 20 分: 大于1 个数字
 * <p>
 * 四、符号:
 * <p>
 * 0 分: 没有符号
 * <p>
 * 10 分: 1 个符号
 * <p>
 * 25 分: 大于1 个符号
 * <p>
 * 五、奖励:
 * <p>
 * 2 分: 字母和数字
 * <p>
 * 3 分: 字母、数字和符号
 * <p>
 * 5 分: 大小写字母、数字和符号
 * <p>
 * 最后的评分标准:
 * <p>
 * >= 90: 非常安全
 * <p>
 * >= 80: 安全（Secure）
 * <p>
 * >= 70: 非常强
 * <p>
 * >= 60: 强（Strong）
 * <p>
 * >= 50: 一般（Average）
 * <p>
 * >= 25: 弱（Weak）
 * <p>
 * >= 0:  非常弱
 * <p>
 * <p>
 * 对应输出为：
 * <p>
 * VERY_SECURE
 * <p>
 * SECURE,
 * <p>
 * VERY_STRONG,
 * <p>
 * STRONG,
 * <p>
 * AVERAGE,
 * <p>
 * WEAK,
 * <p>
 * VERY_WEAK,
 * <p>
 * <p>
 * 请根据输入的密码字符串，进行安全评定。
 * <p>
 * 注：
 * <p>
 * 字母：a-z, A-Z
 * <p>
 * 数字：-9
 * <p>
 * 符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)
 * <p>
 * !"#$%&'()*+,-./     (ASCII码：x21~0x2F)
 * <p>
 * :;<=>?@             (ASCII<=><=><=><=><=>码：x3A~0x40)
 * <p>
 * [\]^_`              (ASCII码：x5B~0x60)
 * <p>
 * {|}~                (ASCII码：x7B~0x7E)
 * <p>
 * <p>
 * 输入描述：
 * 本题含有多组输入样例。
 * 每组样例输入一个string的密码
 * <p>
 * 输出描述：
 * 每组样例输出密码等级
 * <p>
 * 示例1
 * 输入：
 * 38$@NoNoNo
 * 123
 * 输出：
 * VERY_SECURE
 * WEAK
 * 说明：
 * 第一组样例密码强度为95分。
 * 第二组样例密码强度为25分。
 */
public class HJ87CipherStrengthLevel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String pPasswordStr = in.nextLine();
            String safeLevel = GetPwdSecurityLevel(pPasswordStr);
            System.out.println(safeLevel);
        }
    }

    public static String GetPwdSecurityLevel(String pPasswordStr) {
        int score = 0;

        boolean number = false;
        boolean upper = false;
        boolean lower = false;
        boolean symbol = false;
        boolean numberOnce = true;
        boolean symbolOnce = true;

        if (pPasswordStr.length() <= 4) {
            score += 5;
        } else if (pPasswordStr.length() <= 7) {
            score += 10;
        } else {
            score += 25;
        }

        for (char ch : pPasswordStr.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                if (number && numberOnce) {
                    score += 20;
                    numberOnce = false;
                }
                number = true;
            } else if (ch >= 'a' && ch <= 'z') {
                lower = true;
            } else if (ch >= 'A' && ch <= 'Z') {
                upper = true;
            } else if (
                    ch >= 0x21 && ch <= 0x2F ||
                            ch >= 0x3A && ch <= 0x40 ||
                            ch >= 0x5B && ch <= 0x60 ||
                            ch >= 0x7B && ch <= 0x7E) {
                if (symbol && symbolOnce) {
                    score += 25;
                    symbolOnce = false;
                }
                symbol = true;
            }

        }

        if (number && numberOnce) {
            score += 10;
        }
        if (symbol && symbolOnce) {
            score += 10;
        }
        if (lower && upper) {
            score += 20;
        } else if (lower || upper) {
            score += 10;
        }
        if (lower && upper && number && symbol) {
            score += 5;
        } else if ((lower || upper) && number && symbol) {
            score += 3;
        } else if ((lower || upper) && number) {
            score += 2;
        }

        if (score >= 90) {
            return "VERY_SECURE";
        } else if (score >= 80) {
            return "SECURE";
        } else if (score >= 70) {
            return "VERY_STRONG";
        } else if (score >= 60) {
            return "STRONG";
        } else if (score >= 50) {
            return "AVERAGE";
        } else if (score >= 25) {
            return "WEAK";
        } else {
            return "VERY_WEAK";
        }
    }
}
