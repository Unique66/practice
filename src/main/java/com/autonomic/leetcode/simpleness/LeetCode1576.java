/*
 * Copyright (c) 2022.  User:Unique66 File:LeetCode1576.java
 * Date:2022/01/05 22:18:05
 */

package com.autonomic.leetcode.simpleness;

/**
 * 替换所有的问号
 *
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 *
 * 注意：你 不能 修改非 '?' 字符。
 *
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 *
 * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date 2022/1/5 22:18
 */
public class LeetCode1576 {
    public String modifyString(String s) {
        char[] split = s.toCharArray();
        for (int i = 0; i < split.length; i++) {
            if ('?' == split[i]) {
                split[i] = getRandomChar(i, split);
            }
        }
        return new String(split);
    }

    /**
     * 获取一个满足题意的字符
     *
     * @param index 当前下标
     * @param split 待处理的字符串
     * @return char
     */
    public char getRandomChar(int index, char[] split) {
        // 需要关注当前下标两边的元素，如果是头或者尾，那么就只用关注另一边
        char pre = '1';
        char post = '2';
        pre = index == 0 ? pre : split[index - 1];
        post = index == split.length - 1 ? post : split[index + 1];
        // 在替换时，实际不需要遍历所有的小写字母，只需要遍历三个互不相同的字母，就能保证一定找到一个与前后字符均不相同的字母，
        // 在此我们可以限定三个不同的字母为(‘a’,‘b’,‘c’)。
        for (int i = 0; i < 26; i++) {
            char tmp = (char)('a' + i);
            if (tmp != pre && tmp != post) {
                return tmp;
            }
        }
        return '!';
    }
}
